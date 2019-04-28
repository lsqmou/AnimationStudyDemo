package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_animation_set.*
import android.view.animation.ScaleAnimation
import android.view.animation.AlphaAnimation
import android.view.animation.TranslateAnimation
import android.view.animation.RotateAnimation



/**
 * 作者：Lmoumou
 * 时间：2019/4/28 17:28
 */
class AnimationSetActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, AnimationSetActivity::class.java)
            mContext.startActivity(intent)
        }
    }


    private val setAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.animation_set) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_set)

        btSet1.setOnClickListener {
            it.startAnimation(setAnimation)
        }
        btSet2.setOnClickListener {
            // 组合动画设置
            // 步骤1:创建组合动画对象(设置为true)
            val setAnimation=AnimationSet(true)

            // 步骤2:设置组合动画的属性
            // 特别说明以下情况
            // 因为在下面的旋转动画设置了无限循环(RepeatCount = INFINITE)
            // 所以动画不会结束，而是无限循环
            // 所以组合动画的下面两行设置是无效的
            setAnimation.repeatMode = Animation.RESTART
            setAnimation.repeatCount = 1// 设置了循环一次,但无效

            // 子动画1:旋转动画
            val rotate = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 1000
            rotate.repeatMode = Animation.RESTART
            rotate.repeatCount = Animation.INFINITE

            // 子动画2:平移动画
            val translate = TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                TranslateAnimation.RELATIVE_TO_SELF, 0f, TranslateAnimation.RELATIVE_TO_SELF, 0f
            )
            translate.duration = 10000

            // 子动画3:透明度动画
            val alpha = AlphaAnimation(1f, 0.5f)
            alpha.duration = 3000
            alpha.startOffset = 7000

            // 子动画4:缩放动画
            val scale1 =
                ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            scale1.duration = 1000
            scale1.startOffset = 4000

            // 步骤4:将创建的子动画添加到组合动画里
            setAnimation.addAnimation(alpha)
            setAnimation.addAnimation(rotate)
            setAnimation.addAnimation(translate)
            setAnimation.addAnimation(scale1)

            it.startAnimation(setAnimation)

        }

    }
}
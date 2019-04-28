package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_scale_animation.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/28 16:05
 *
 * 缩放动画
 *
 * xml资源：animation_translate
 */
class ScaleAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, ScaleAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    //引用xml动画
    private val scaleAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.animation_scale) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale_animation)

        btScale1.setOnClickListener {
            it.startAnimation(scaleAnimation)
        }

        btScale2.setOnClickListener {
            val sacalAnimation: Animation =
                ScaleAnimation(1F, 2F, 1F, 2F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F)
            sacalAnimation.duration = 3000
            it.startAnimation(sacalAnimation)
        }
    }

}
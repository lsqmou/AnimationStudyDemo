package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_rotate_animation.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/28 16:46
 *
 * 旋转动画
 *
 * XML资源：animation_rotate.xml
 */
class RotateAnimationActivity : AppCompatActivity() {
    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, RotateAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    private val rotateAnimation:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.animation_rotate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate_animation)

        btRotate1.setOnClickListener {
            it.startAnimation(rotateAnimation)
        }

        btRotate2.setOnClickListener {
            val rotateAnimation:Animation=RotateAnimation(0F,270F,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
            rotateAnimation.duration=3000
            it.startAnimation(rotateAnimation)
        }
    }
}
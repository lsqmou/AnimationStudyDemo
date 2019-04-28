package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_alpha_animation.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/28 17:00
 *
 * 透明度动画
 *
 * xml资源：animation_alpha.xml
 */
class AlphaAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, AlphaAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    private val alphaAnimation:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.animation_alpha) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha_animation)

        btAlpha1.setOnClickListener {
            it.startAnimation(alphaAnimation)
        }

        btAlpha2.setOnClickListener {
            val  alphaAnimation = AlphaAnimation(1.0F,0.0f)
            alphaAnimation.duration=3000
            it.startAnimation(alphaAnimation)
        }
    }
}
package com.lmoumou.frame

import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_frame_activity.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 11:20
 *
 * 1.作用对象：
 *   视图控件（View）,不能作用于View的属性（如：颜色，长度，位置等）
 * 2.原理：
 *   将动画拆分为帧的形似
 * 3：使用：
 */
class FrameAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, FrameAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    private val animationDrawable: AnimationDrawable by lazy { mImageView.drawable as AnimationDrawable }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_activity)

        btStart.setOnClickListener {
            animationDrawable.start()
        }

        btStop.setOnClickListener {
            animationDrawable.stop()
        }
    }
}
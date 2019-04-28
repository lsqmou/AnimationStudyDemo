package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_translate.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/28 15:03
 *
 * 使用方法
 *  1.在 res/anim文件夹里创建动画效果 .xml文件(animation_translate.xml)
 *  2.在代码中设置
 */
class TranslateActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, TranslateActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    //引用xml动画文件
    private val translateAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.animation_translate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        btTranslate.setOnClickListener {
            it.startAnimation(translateAnimation)
        }


        //方法2，代码设置
        btTranslate2.setOnClickListener {
            //参数
            //1.fromXDelta
            //2.toXDelta
            //3.fromYDelta
            //4.toYDelta
            val translateAnimation: Animation = TranslateAnimation(0F, 500F, 0F, 500F)
            translateAnimation.duration = 3000
            it.startAnimation(translateAnimation)
        }
    }
}
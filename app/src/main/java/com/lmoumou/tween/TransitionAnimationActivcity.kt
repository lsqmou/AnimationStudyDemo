package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 09:43
 *
 * Activity转场动画
 *
 * 5.0之后的转场动画待定。。。
 */
class TransitionAnimationActivcity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, TransitionAnimationActivcity::class.java)
            mContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_animation)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
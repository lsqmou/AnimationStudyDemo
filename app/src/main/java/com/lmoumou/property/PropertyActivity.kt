package com.lmoumou.property

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_proper.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 14:09
 */
class PropertyActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, PropertyActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proper)

        btValue.setOnClickListener {
            ValueAnimatorActivity.startThis(this)
        }
    }
}
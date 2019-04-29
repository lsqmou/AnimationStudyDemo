package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_fragment_animation.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 10:07
 */
class FragmentAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, FragmentAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    private val fragmentTransaction: FragmentTransaction by lazy { supportFragmentManager.beginTransaction() }
    private val fragment1:TransitionAnimationFragment by lazy { TransitionAnimationFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_animation)


        fragmentTransaction.setCustomAnimations(
            R.anim.fade_in,
            R.anim.fade_out
        )


        mButton.setOnClickListener {
            if (!fragment1.isAdded){
                fragmentTransaction.add(R.id.flContent, fragment1)
                    .commit()
            }else{
//                fragmentTransaction.remove(fragment1).commit()
            }

        }
    }
}
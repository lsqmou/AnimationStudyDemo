package com.lmoumou.property

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_value_animator.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 14:07
 *
 * ValueAnimator
 * 1.原理：通过不断的控制值的变化，在不断手动赋给对象的属性，从而实现动画效果
 * 2.方法：
 *   ValueAnimator.ofInt(int values)        作用：将初始值以整型数值的形式过渡到结束值
 *   ValueAnimator.ofFloat(Floaf values)    作用：将初始值以浮点型数值的形式过渡到结束值
 *   ValueAnimator.ofObject()               作用：将初始值以对象的形式过渡到结束值
 * 3.说明：本质是一种值的操作机制，（一个值变化到另一个值的过程）
 * 4.操作方式：代码设置,XML设置
 */
class ValueAnimatorActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, ValueAnimatorActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        //代码创建
        btIntCode.setOnClickListener { view ->

            //1.设置动画属性的初始值和结束值
            val intValueAnimatior = ValueAnimator.ofInt(view.measuredWidth, view.measuredWidth * 2, view.measuredWidth)
            //ofInt()作用：
            //(1).创建ValueAnimator实例
            //(2).将传入的多个Int参数进行平滑过渡：此处传入0&3，表示从0平滑过渡到3
            //如果传入了3个Int参数a,b,c,则先从a平滑过渡到b，在从b平滑过渡到c,以此类推
            //(3).ValueAnimator.ofInt()内置整型估值器。

            //2.设置动画的各种属性
            intValueAnimatior.duration = 1000//动画运行时长

            intValueAnimatior.startDelay = 0//动画延迟播放时间

            intValueAnimatior.repeatCount = 0//重复播放次数=repeatCount+1,为infinite无限重复

            intValueAnimatior.repeatMode =
                ValueAnimator.RESTART//模式，ValueAnimator.RESTART(默认)：正序播放，ValueAnimator.REVERSE：倒叙

            //3.添加监听
            intValueAnimatior.addUpdateListener { intValueAnimatior ->
                val currentValue: Int = intValueAnimatior.animatedValue as Int
                Log.e("ValueAnimatorActivity", "currentValue->$currentValue")
                view.layoutParams.width = currentValue
                view.requestLayout()
            }

            //4.开始动画
            intValueAnimatior.start()

        }

        //XML创建
        btIntXML.setOnClickListener { view ->
            val animator: Animator = AnimatorInflater.loadAnimator(this, R.animator.animator_int)
            animator.setTarget(view)
            animator.start()
        }


        btFloatCode.setOnClickListener { view ->
            //与ofInt()类似
            val valueFloatAnimator = ValueAnimator.ofFloat(
                view.measuredWidth.toFloat(),
                (view.measuredWidth * 2).toFloat(),
                view.measuredWidth.toFloat()
            )
            valueFloatAnimator.duration = 1000
            valueFloatAnimator.startDelay = 0
            valueFloatAnimator.repeatCount = 0
            valueFloatAnimator.repeatMode = ValueAnimator.RESTART

            valueFloatAnimator.addUpdateListener { animator ->
                val currentValue: Float = animator.animatedValue as Float
                view.layoutParams.width = currentValue.toInt()
                view.requestLayout()
                Log.e("ValueAnimatorActivity", "currentValue->$currentValue")
            }
            valueFloatAnimator.start()
        }

        btFloatXML.setOnClickListener { view ->
            val animator: Animator = AnimatorInflater.loadAnimator(this, R.animator.animator_float)
            if (animator is ValueAnimator) {
                animator.setTarget(view)
                animator.addUpdateListener { animator ->
                    val currentValue: Float = animator.animatedValue as Float
                    view.layoutParams.width = currentValue.toInt()
                    view.requestLayout()
                    Log.e("ValueAnimatorActivity", "currentValue->$currentValue")
                }
                animator.start()
            }

        }
    }

}
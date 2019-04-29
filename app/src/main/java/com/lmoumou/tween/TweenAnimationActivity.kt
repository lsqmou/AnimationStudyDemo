package com.lmoumou.tween

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lmoumou.animationstudydemo.R

/**
 * 作者：Lmoumou
 * 时间：2019/4/28 14:27
 *
 * 1.补间动画
 *   作用对象：视图控件（View）,不能作用于View的属性（如：颜色，长度，位置等）
 *
 * 2.原理
 *   通过视图开始的样式和结尾的样式，中间动画变化的过程有系统补全来确定一个动画
 *
 * 3.分类
 *   平移动画（Translate），对应类:（TanslateAnimation）,原理：移动视图的位置
 *   缩放动画（scale）    ，对应类：（ScaleAnimation）   ,原理：放大/缩小 视图的大小
 *   旋转动画（rotate）   ，对应类：（RotateAnimation）  ,原理：旋转视图的角度
 *   透明度动画（alpha）   ，对应类：（AlphaAnimation）   ,原理：改变视图的透明度
 *
 * 4.使用看下面案例
 *
 */
class TweenAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, TweenAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_animation)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btTranslate -> {
                TranslateActivity.startThis(this)
            }
            R.id.btScale -> {
                ScaleAnimationActivity.startThis(this)
            }
            R.id.btRotate -> {
                RotateAnimationActivity.startThis(this)
            }
            R.id.btAlpha -> {
                AlphaAnimationActivity.startThis(this)
            }
            R.id.btSet -> {
                AnimationSetActivity.startThis(this)
            }
            R.id.btActivity -> {
                TransitionAnimationActivcity.startThis(this)

                //系统自带效果
                //淡入，淡出
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_in)
                //左进又出
//                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                //自定义淡入淡出效果
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
            R.id.btFragment -> {
                FragmentAnimationActivity.startThis(this)
            }
            R.id.btViewGroup -> {
                ViewGroupAnimationActivity.startThis(this)
            }
        }
    }
}
package com.lmoumou.property

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 15:41
 */
class MyView : View {

    companion object {
        const val RADIUS: Float = 70F//圆的半径
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    //当前点坐标
    private var currentPoint: Point? = null
    //画笔
    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        if (currentPoint == null) {
            currentPoint = Point(RADIUS, RADIUS)
            canvas.drawCircle(currentPoint!!.x, currentPoint!!.y, RADIUS, mPaint)

            //将属性动画作用到View
            //1.创建初始动画点 & 结束动画点
            val startPoint = Point(RADIUS, RADIUS)
            val endPoint = Point(700F, 700F)

            //2.创建对象
            val anim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint,startPoint)
            //3.设置动画参数
            anim.duration = 5000
            anim.addUpdateListener { anim ->
                currentPoint = anim.animatedValue as Point?
                invalidate()
            }
            anim.start()
        } else {
            canvas.drawCircle(currentPoint!!.x, currentPoint!!.y, RADIUS, mPaint)
        }
    }
}
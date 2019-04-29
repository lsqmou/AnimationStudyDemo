package com.lmoumou.property

import android.animation.TypeEvaluator

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 15:36
 */
class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
        var x: Float = startValue.x + fraction * (endValue.x - startValue.x)
        val y: Float = startValue.y + fraction * (endValue.y - startValue.y)
        return Point(x, y)
    }
}
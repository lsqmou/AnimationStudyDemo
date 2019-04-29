package com.lmoumou.tween

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lmoumou.animationstudydemo.R

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 10:12
 *
 * Fragment进出动画
 */
class TransitionAnimationFragment : Fragment() {

    companion object {
        fun newInstance(): TransitionAnimationFragment = TransitionAnimationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_transition_animation,container,false)
        return view
    }
}
package com.lmoumou.animationstudydemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lmoumou.frame.FrameAnimationActivity
import com.lmoumou.tween.TweenAnimationActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main.view.*

class MainActivity : AppCompatActivity() {

    private val mInflater: LayoutInflater by lazy { LayoutInflater.from(this) }
    private val dataList: MutableList<String> by lazy { mutableListOf<String>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = MainAdapter()

    }

    private fun initData() {
        dataList.add("补间动画")
        dataList.add("逐帧动画")
        dataList.add("属性动画")
    }

    inner class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

            return MainViewHolder(mInflater.inflate(R.layout.item_main, parent, false))
        }

        override fun getItemCount(): Int = dataList.size

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.itemView.mTextView.text = dataList[position]
            holder.itemView.setOnClickListener {
                when (position) {
                    0 -> {
                        TweenAnimationActivity.startThis(this@MainActivity)
                    }
                    1 -> {
                        FrameAnimationActivity.startThis(this@MainActivity)
                    }
                    2 -> {

                    }
                }
            }
        }


        inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
    }

}



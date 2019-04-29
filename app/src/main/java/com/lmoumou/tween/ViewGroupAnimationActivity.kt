package com.lmoumou.tween

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lmoumou.animationstudydemo.R
import kotlinx.android.synthetic.main.activity_viewgroup_animation.*
import kotlinx.android.synthetic.main.item_viewgroup.view.*

/**
 * 作者：Lmoumou
 * 时间：2019/4/29 10:41
 */
class ViewGroupAnimationActivity : AppCompatActivity() {

    companion object {
        fun startThis(mContext: Context) {
            val intent = Intent(mContext.applicationContext, ViewGroupAnimationActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    private val dataList: MutableList<String> by lazy { mutableListOf<String>() }
    private val mInflater: LayoutInflater by lazy { LayoutInflater.from(this) }

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewgroup_animation)

        initData()

        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mRecyclerView.adapter = ViewGroupAdapter()

        btAdd.setOnClickListener {
            val textView = TextView(this)
            textView.setPadding(20, 20, 20, 20)
            textView.setBackgroundColor(Color.YELLOW)
            textView.text = "Item$count"
            mLinearLayout.addView(textView)
            count++
        }

        btRemove.setOnClickListener {
            if (count != 0) {
                mLinearLayout.removeViewAt(--count)
            }


        }
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        for (i in 0..20) {
            dataList.add("Item$i")

        }
    }


    inner class ViewGroupAdapter : RecyclerView.Adapter<ViewGroupAdapter.ViewGroupViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewGroupViewHolder {
            return ViewGroupViewHolder(mInflater.inflate(R.layout.item_viewgroup, parent, false))
        }

        override fun getItemCount(): Int = dataList.size

        override fun onBindViewHolder(holder: ViewGroupViewHolder, position: Int) {
            holder.itemView.tvContent.text = dataList[position]
        }


        inner class ViewGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}
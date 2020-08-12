package com.biginsect.simplechatdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */
class MessageAdapter(private val msgList: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val message = msgList[position]
        return message.tyep
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == Message.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_msg_left, parent, false)
            LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_msg_right, parent, false)
            RightViewHolder(view)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = msgList[position]
        when (holder) {
            is RightViewHolder -> holder.rightText.text = message.content
            is LeftViewHolder -> holder.leftText.text = message.content
            else -> throw IllegalAccessException()
        }
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    class RightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rightText: TextView = itemView.findViewById(R.id.tv_right_msg);
    }

    class LeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leftText: TextView = itemView.findViewById(R.id.tv_left_msg)
    }


}
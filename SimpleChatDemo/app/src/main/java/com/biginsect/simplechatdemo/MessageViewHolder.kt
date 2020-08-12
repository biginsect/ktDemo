package com.biginsect.simplechatdemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */

sealed class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class RightViewHolder(itemView: View) : MessageViewHolder(itemView) {
    val rightText: TextView = itemView.findViewById(R.id.tv_right_msg);
}

class LeftViewHolder(itemView: View) : MessageViewHolder(itemView) {
    val leftText: TextView = itemView.findViewById(R.id.tv_left_msg)
}
package com.biginsect.simplechatdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */
class MessageAdapter(private val msgList: List<Message>) :
    RecyclerView.Adapter<MessageViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val message = msgList[position]
        return message.tyep
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder =
        if (viewType == Message.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_msg_left, parent, false)
            LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_msg_right, parent, false)
            RightViewHolder(view)
        }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = msgList[position]
        when (holder) {
            is RightViewHolder -> holder.rightText.text = message.content
            is LeftViewHolder -> holder.leftText.text = message.content
        }
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

}
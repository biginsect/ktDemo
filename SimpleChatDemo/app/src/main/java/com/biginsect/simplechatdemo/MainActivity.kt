package com.biginsect.simplechatdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mMessages = ArrayList<Message>()
    private var mAdapter: MessageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMessage()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mAdapter = MessageAdapter(mMessages)
        rv_content.layoutManager = layoutManager
        rv_content.adapter = mAdapter
        btn_send.setOnClickListener(this)
    }

    private fun initMessage() {
        val msg1 = Message("hello guys.", Message.TYPE_RECEIVED)
        mMessages.add(msg1)
        val msg2 = Message("Hello. Who is that?", Message.TYPE_SEND)
        mMessages.add(msg2)
        val msg3 = Message("This is Tom. Nice to talking to you!", Message.TYPE_RECEIVED)
        mMessages.add(msg3)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_send -> {
                val content = et_input.text.toString()
                if (content.isNotEmpty()) {
                    val newMessage = Message(content, Message.TYPE_SEND)
                    mMessages.add(newMessage)
                    mAdapter?.notifyItemInserted(mMessages.size - 1)
                    rv_content.scrollToPosition(mMessages.size - 1)
                    et_input.setText("")
                }
            }
        }
    }
}
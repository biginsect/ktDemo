package com.biginsect.simplenewsdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : AppCompatActivity() {

    companion object {
        private const val KEY_TITLE = "news_title"
        private const val KEY_CONTENT = "news_content"

        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra(KEY_TITLE, title)
                putExtra(KEY_CONTENT, content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        val title = intent.getStringExtra(KEY_TITLE)
        val content = intent.getStringExtra(KEY_CONTENT)

        if (title != null && content != null) {
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title, content)
        }
    }
}
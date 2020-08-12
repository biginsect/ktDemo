package com.biginsect.simplenewsdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.news_content_frag.*

/**
 *
 * @author biginsect
 * @date 2020/8/12
 */
class NewsContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.news_content_frag, container, false)
    }

    fun refresh(title: String, content: String) {
        content_layout.visibility = View.VISIBLE
        newsTitle.text = title
        newsContent.text = content
    }
}
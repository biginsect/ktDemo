package com.biginsect.simplebroadcastdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

/**
 *
 * @author biginsect
 * @date 2020/8/15
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBtn.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if ("Admin" == account && "123" == password) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Account or password is invalid.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
}
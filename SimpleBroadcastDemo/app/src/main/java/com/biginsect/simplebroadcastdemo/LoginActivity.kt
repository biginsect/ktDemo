package com.biginsect.simplebroadcastdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

/**
 *
 * @author biginsect
 * @date 2020/8/15
 */
class LoginActivity : BaseActivity() {

    private lateinit var mPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPrefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = mPrefs.getBoolean("remember_password", false)
        if (isRemember) {
            val account = mPrefs.getString("account", "")
            val password = mPrefs.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }
        loginBtn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val account = accountEdit.text.toString()
        val password = passwordEdit.text.toString()
        if ("Admin" == account && "123" == password) {
            val editor = mPrefs.edit()
            if (rememberPass.isChecked) {
                editor.putBoolean("remember_password", true)
                editor.putString("account", account)
                editor.putString("password", password)
            } else {
                editor.clear()
            }
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Account or password is invalid.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
}
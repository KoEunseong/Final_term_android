package com.example.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var passWord : EditText
    lateinit var loginBtn : Button
    lateinit var joinBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        email = findViewById(R.id.login_email)
        passWord = findViewById(R.id.login_password)
        loginBtn = findViewById(R.id.login_button)
        joinBtn = findViewById(R.id.join_button)

        loginBtn.setOnClickListener {
            var isLogin : Boolean

        }

        joinBtn.setOnClickListener {
            var intent = Intent(applicationContext, join::class.java)
            startActivity(intent)
        }

    }
}

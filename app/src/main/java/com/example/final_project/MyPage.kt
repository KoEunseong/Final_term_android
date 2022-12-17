package com.example.final_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MyPage : AppCompatActivity() {
    lateinit var profileBtn: androidx.appcompat.widget.AppCompatButton
    lateinit var goLogin : TextView
    lateinit var loginView: ConstraintLayout
    lateinit var profileView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage)
        profileBtn = findViewById(R.id.btn_view_profile)
        goLogin = findViewById(R.id.tv_login)

        profileBtn.setOnClickListener {
            intent = Intent(applicationContext,Profile::class.java)
            startActivityForResult(intent,0)
        }
        goLogin.setOnClickListener {
            intent = Intent(applicationContext,Login::class.java)
            startActivityForResult(intent,0)
            //TEST1
        }
    }

}
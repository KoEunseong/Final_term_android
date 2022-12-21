package com.example.final_project

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var passWord : EditText
    lateinit var loginBtn : Button
    lateinit var joinBtn : Button
    lateinit var myHelper : MemberDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        var isValidEmail : Boolean
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        email = findViewById(R.id.login_email)
        passWord = findViewById(R.id.login_password)
        loginBtn = findViewById(R.id.login_button)
        joinBtn = findViewById(R.id.join_button)
        myHelper = MemberDBHelper(this)

        loginBtn.setOnClickListener {
            isValidEmail = true
            isValidEmail = myHelper!!.checkPassword(email.text.toString(), passWord.text.toString())
            if(isValidEmail == true){
                Toast.makeText(applicationContext,"로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(applicationContext, MainActivity::class.java)
                startActivityForResult(intent,0)
            }
            else {
                Toast.makeText(applicationContext,"이메일 및 비밀번호를 확인하십시오.", Toast.LENGTH_SHORT).show()
            }
        }

        joinBtn.setOnClickListener {
            var intent = Intent(applicationContext, join::class.java)
            startActivity(intent)
        }

    }
}

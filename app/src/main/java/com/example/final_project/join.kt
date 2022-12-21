package com.example.final_project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.join.*

class join : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var btnEmailCheck :Button
    lateinit var passWord : EditText
    lateinit var passWordCheck : EditText
    lateinit var joinBtn : Button
    lateinit var cancelBtn : Button
    lateinit var myHelper: MemberDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join)
        name = findViewById(R.id.join_name)
        email = findViewById(R.id.join_email)
        btnEmailCheck = findViewById(R.id.check_button)
        passWord = findViewById(R.id.join_password)
        passWordCheck = findViewById(R.id.join_pwck)
        joinBtn = findViewById(R.id.join_button)
        cancelBtn = findViewById(R.id.delete)
        myHelper = MemberDBHelper(this)

        var isValidEmail = false
//        var isValidPassWord = false
        var tmpbutton : Button
                = findViewById(R.id.tmpbutton)
        tmpbutton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2) // 인수는 아무거나 입력하면 됨.
            sqlDB.close()
            Toast.makeText(applicationContext,"초기화.", Toast.LENGTH_SHORT).show()
        }
        btnEmailCheck.setOnClickListener {
            isValidEmail = true
            isValidEmail = myHelper!!.checkEmail(email.text.toString())
            if(!isValidEmail){
                Toast.makeText(applicationContext,"이미 가입된 이메일 입니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"가능한 이메일", Toast.LENGTH_SHORT).show()
            }
        }

        joinBtn.setOnClickListener {
            var readyForJoin = true

            if(isValidEmail == false){
                Toast.makeText(applicationContext,"이메일 확인을 다시하세요", Toast.LENGTH_SHORT).show()
                readyForJoin = false;
            }

            if(!passWord.text.toString().equals(passWordCheck.text.toString())){
                Toast.makeText(applicationContext,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                readyForJoin = false;
            } // 후에 정규식을 통해 비밀번호 형식 지정해 주기, 메서드로 묶어서 처리하게 할것


            if(readyForJoin == true){
                myHelper!!.insertData(email.text.toString(),name.text.toString(),passWord.text.toString())
                //데이터 베이스 회원가입된 회원정보 저장
                Toast.makeText(applicationContext,"회원가입이 완료됐습니다.", Toast.LENGTH_SHORT).show()
                sqlDB.close()
                finish()
            }
        }
        cancelBtn.setOnClickListener {
            finish()
        }



    }

}
package com.example.final_project

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Post_regist : AppCompatActivity() {

    lateinit var post_name : EditText   // 스터디 제목
    lateinit var post_major : EditText  // 전공/회사/학교 카테고리
    lateinit var post__certificate : EditText   //자격증 카테고리

    lateinit var period : EditText  // 기간 설정 - DatePicker 사용


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}
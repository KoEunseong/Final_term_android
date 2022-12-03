package com.example.final_project

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Search : Activity() {
    lateinit var edit_search :EditText
    lateinit var search_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 위젯 연결
        edit_search = findViewById<EditText>(R.id.edit_search)
        search_btn = findViewById<Button>(R.id.search_btn)

        search_btn.setOnClickListener {
            // 검색 버튼 클릭시

        }


    }
}
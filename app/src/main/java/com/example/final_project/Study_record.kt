package com.example.final_project

import android.app.Activity
import android.os.Bundle
import android.widget.*

class Study_record :Activity() {

    lateinit var calendarview :CalendarView
    lateinit var recordView : LinearLayout

    lateinit var insertBtn : Button
    lateinit var editTv : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_record)

        var year :String
        var month : String
        var dayOfMonth : String
        var date1 : String
        var memo : String

        var selectMemo =""  // db에서 날짜별 회원 정보로 memo 조회

        calendarview = findViewById<CalendarView>(R.id.calendarView)

        calendarview.setOnDateChangeListener { calendarView, i, i2, i3 ->
            year = i.toString()
            month= i2.toString()
            dayOfMonth = i3.toString()

            Toast.makeText(this, year + "년 " + (month + 1) + "월 " + dayOfMonth + "일", Toast.LENGTH_SHORT).show();

            date1 = year+"-"+month+"-"+dayOfMonth

            // db에서 날짜별 메모 조회
            memo = selectMemo
            editTv.setText(memo)

        }

        insertBtn = findViewById<Button>(R.id.insetBtn)

        insertBtn.setOnClickListener {

            editTv = findViewById<EditText>(R.id.ed1Text)
            memo = selectMemo + editTv.text.toString()

            // 캘린더 뷰에서 날짜값 가져오기

            // db에 INSERT


        }
    }
}
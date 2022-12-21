package com.example.final_project

import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*

class Study_record :Activity() {

    lateinit var calendarview :CalendarView
    lateinit var recordView : LinearLayout

    lateinit var myHelper: RecordDBHelper
    lateinit var sqlDB: SQLiteDatabase

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
            month= (i2+1).toString()
            dayOfMonth = i3.toString()

            Toast.makeText(this, year + "년 " + month  + "월 " + dayOfMonth + "일", Toast.LENGTH_SHORT).show();

            date1 = year+"-"+month+"-"+dayOfMonth

            // db에서 날짜별 메모 조회
            memo = myHelper!!.selectMemoAndDate(1,date1)
            editTv.setText(memo)


            myHelper.close()
        }

        insertBtn = findViewById<Button>(R.id.insetBtn)

        insertBtn.setOnClickListener {
            editTv = findViewById<EditText>(R.id.ed1Text)
            memo = selectMemo + editTv.text.toString()

            // 캘린더 뷰에서 날짜값 가져오기

            // db에 INSERT


            Toast.makeText(this,"메모가 추가되었습니다",Toast.LENGTH_SHORT).show()

            myHelper!!.insertData(1,"2022-12-22",memo)
            myHelper.close()
        }
    }
}
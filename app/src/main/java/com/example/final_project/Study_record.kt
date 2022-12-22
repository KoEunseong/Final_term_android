package com.example.final_project

import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import kotlinx.android.synthetic.main.study_record.*

class Study_record :Activity() {

    lateinit var myHelper : RecordDBHelper
    lateinit var calendarView: CalendarView
    lateinit var textCalendar : TextView
    lateinit var editMemo : EditText
    lateinit var insertBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_record)

        myHelper = RecordDBHelper(this)

        calendarView = findViewById<CalendarView>(R.id.calendarView)
        textCalendar = findViewById<TextView>(R.id.textCalendar)
        editMemo = findViewById<EditText>(R.id.edMemo)
        insertBtn = findViewById<Button>(R.id.insetBtn)

        var sqlDB : SQLiteDatabase

        calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            var year = i.toString()
            var month = (i2+1).toString()
            var dayOfMonth=i3.toString()
            myHelper.writableDatabase

            var date = year+"-"+month+"-"+dayOfMonth

            textCalendar.text = date

            // memberId, date 로 조회
            var memo = myHelper.checkMemo(date,"1")

            editMemo.setText(memo)
        }

        insertBtn.setOnClickListener {
            var date = textCalendar.text.toString()

            var memoDB = editMemo.text.toString()

            // 조회 했을때 값 없으면 insert
            var memo : String? = myHelper.checkMemo(date,"1")

            //memoDB = memoDB + memo
            sqlDB = myHelper.writableDatabase

           // myHelper.onUpgrade(sqlDB,0,1)


            if(memo == null){
                myHelper.insertData("1",date,memoDB)
            }else{
                myHelper.upgradeData("1",date,memoDB)
            }



            // 조회 했을때 값 있으면 upgrade
            Toast.makeText(this,"추가되었습니다",Toast.LENGTH_SHORT).show()
        }

    }
}
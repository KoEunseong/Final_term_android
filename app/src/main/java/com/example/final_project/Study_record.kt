package com.example.final_project

import android.app.Activity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.LinearLayout

class Study_record :Activity() {

    lateinit var calendarview :CalendarView
    lateinit var recordView : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_record)

        calendarview = findViewById<CalendarView>(R.id.calendarView)
        calendarview.setOnDateChangeListener { calendarView, i, i2, i3 ->


        }


        recordView = findViewById<LinearLayout>(R.id.record_view)

        recordView.setOnClickListener {


        }


    }
}
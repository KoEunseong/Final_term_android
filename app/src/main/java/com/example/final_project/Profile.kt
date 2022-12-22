package com.example.final_project

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Profile :Activity(){

    lateinit var tvName : TextView  // 이름
    lateinit var tvSns : TextView   // SNS
    lateinit var tvTeam : TextView  // 소속(학교, 회사)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        // 위젯 연결
        tvName =findViewById<TextView>(R.id.tvName)
        tvSns =findViewById<TextView>(R.id.tvSns)
        tvTeam =findViewById<TextView>(R.id.tvTeam)



    }
}
package com.example.final_project

import android.app.TabActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("deprecation")
class MainActivity : TabActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tabHost = this.tabhost
        var intent : Intent


        var tabSpecHome = tabHost.newTabSpec("home").setIndicator("홈")
        tabSpecHome.setContent(R.id.home) //여기서 인텐트 연결 하면 될듯
        tabHost.addTab(tabSpecHome)

        intent = Intent(applicationContext,Search::class.java)
        var tabSpecFind = tabHost.newTabSpec("find").setIndicator("스터디 찾기")
        tabSpecFind.setContent(intent)
        tabHost.addTab(tabSpecFind)

        intent = Intent(applicationContext,Study_record::class.java)
        var tabSpecRecord = tabHost.newTabSpec("record").setIndicator("학습 기록")
        tabSpecRecord.setContent(intent)
        tabHost.addTab(tabSpecRecord)

        intent = Intent(applicationContext,MyPage::class.java)
        var tabSpecSettings = tabHost.newTabSpec("settings").setIndicator("마이페이지")
        tabSpecSettings.setContent(intent)
        tabHost.addTab(tabSpecSettings)

        tabHost.currentTab = 0
        //반영



    }
}

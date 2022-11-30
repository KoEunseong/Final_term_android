package com.example.final_project

import android.app.TabActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("deprecation")
class MainActivity : TabActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tabHost = this.tabhost

        var tabSpecHome = tabHost.newTabSpec("home").setIndicator("홈")
        tabSpecHome.setContent(R.id.home)
        tabHost.addTab(tabSpecHome)

        var tabSpecFind = tabHost.newTabSpec("find").setIndicator("스터디 찾기")
        tabSpecFind.setContent(R.id.find_study)
        tabHost.addTab(tabSpecFind)

        var tabSpecRecord = tabHost.newTabSpec("record").setIndicator("학습 기록")
        tabSpecRecord.setContent(R.id.record_study)
        tabHost.addTab(tabSpecRecord)

        var tabSpecSettings = tabHost.newTabSpec("settings").setIndicator("설정")
        tabSpecSettings.setContent(R.id.settings)
        tabHost.addTab(tabSpecSettings)


        tabHost.currentTab = 0

    }
}

package com.example.final_project

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity(){
    var myStudyList = arrayListOf<Study>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainListAdapter
    lateinit var myDBHelper: RecordDBHelper
    lateinit var sqlDB : SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.home)


        myDBHelper = RecordDBHelper(this)

        var memoArrayList : ArrayList<MemoByMemberIdInfo> = myDBHelper.selectMemoById("1")

        for(i in memoArrayList){
            print(i.date+" : ")
            println(i.memo)
        }

    }



    fun setAdapter(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainListAdapter(myStudyList, this)
        recyclerView.adapter = adapter
    }



}
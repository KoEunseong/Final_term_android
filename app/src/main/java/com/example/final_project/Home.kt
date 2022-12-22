package com.example.final_project

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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        recyclerView = findViewById(R.id.recyclerView)
        myStudyList
        setAdapter()
    }

    fun setAdapter(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainListAdapter(myStudyList, this)
        recyclerView.adapter = adapter
    }



}
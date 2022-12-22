package com.example.final_project

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.registerdialog.*

class Search : AppCompatActivity() {
    var studyList = arrayListOf<Study>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainListAdapter
    lateinit var searchView: SearchView
    lateinit var registerButton: Button
    lateinit var dialogView : View
    lateinit var dlgSubject : EditText
    lateinit var dlgContent : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)
        searchView = findViewById(R.id.search_view)
        recyclerView = findViewById(R.id.recyclerView)

        searchView.setOnQueryTextListener(searchViewTextListner)

        studyList = tempStudy()
        setAdapter()
        registerButton = findViewById(R.id.register)
        registerButton.setOnClickListener {

            dialogView = View.inflate(this@Search, R.layout.registerdialog, null)
            var dlg = AlertDialog.Builder(this@Search)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ko)
            dlg.setView(dialogView)
            dlg.setPositiveButton("등록"){dialog, which ->
                dlgSubject = dialogView.findViewById(R.id.dlgEdt1)
                dlgContent = dialogView.findViewById(R.id.dlgEdt2)
                studyList.add(0, Study(dlgSubject.text.toString(), dlgContent.text.toString()))
                Toast.makeText(applicationContext,"등록 완료", Toast.LENGTH_SHORT).show()
                searchView.setOnQueryTextListener(searchViewTextListner)
            }
            dlg.setNegativeButton("취소", null)

            dlg.show()
            //test2

        }

    }
    var searchViewTextListner : SearchView.OnQueryTextListener =
        object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            //텍스트 입력/수정 시 호출
            override fun onQueryTextChange(s: String?): Boolean {
                adapter!!.filter.filter(s)
                return false
            }

        }

    fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainListAdapter(studyList, this)
        recyclerView.adapter = adapter
    }
    fun tempStudy(): ArrayList<Study> {
        var sList = ArrayList<Study>()
        sList.add(Study("algorithm","백준 사이트 알고리즘 풀 사람 구합니다."))
        sList.add(Study("software2","기말 텀 과제 같이 할 사람 구합니다."))
        sList.add(Study("java","java 스터디 할 사람 구합니다."))
        sList.add(Study("software2","안드로이드 공부 할 사람"))
        sList.add(Study("java","객체 지향 설명해 주실 분~"))
        sList.add(Study("software1","자바 스크립트 할 사람"))
        sList.add(Study("c++","c++고수분 구합니다."))
        sList.add(Study("software1","node.js할 줄 아는사람 구합니다."))
        sList.add(Study("compiler","과제1 같이 할 사람~"))
        return sList
    }
}
package com.example.final_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecordDBHelper(context: Context) : SQLiteOpenHelper(context, "recordDB.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL("CREATE TABLE  record_tbl ( memberId INTEGER PRIMARY KEY, date TEXT, memo TEXT);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS record_tbl")
        onCreate(p0)
    }
    fun insertData(memberId : Int?, date : String? , memo : String) : Boolean {
        val myDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("memberId",memberId)
        contentValues.put("date",date)
        contentValues.put("memo",memo)
        val result = myDB.insert("record_tbl",null,contentValues)

        if(result == -1L)
            return false
        return true
    }

    fun selectMemoAndDate(memberId: Int,date:String) : String {
        val myDB = this.writableDatabase
        var res = true
        val cursor = myDB.rawQuery("select * from record_tbl where email = ? AND memberId", null)
        var memo = cursor.getString(2)
        return memo

    }
}
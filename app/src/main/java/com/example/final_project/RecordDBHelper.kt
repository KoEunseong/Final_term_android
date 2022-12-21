package com.example.final_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecordDBHelper(context: Context) : SQLiteOpenHelper(context, "recordDB.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL("CREATE TABLE  recordTbl ( memberId INTEGER PRIMARY KEY, date TEXT, memo TEXT);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS recordTbl")
        onCreate(p0)
    }
    fun insertData(memberId : Int?, date : String? , memo : String) : Unit {
        val myDB = this.writableDatabase

        val values = ContentValues()
        values.put("memberId", memberId)
        values.put("date", date)
        values.put("memo", memo)

        myDB.insert("recordTbl", null, values)

    }

    fun selectMemoAndDate(memberId: Int,date:String) : String {
        val myDB = this.writableDatabase
        var sql = "select * from recordTbl where memberId = "+memberId+" AND date = "+date

        val cursor = myDB.rawQuery(sql, null)
        var memo = cursor.getString(2)


        return memo
    }
}
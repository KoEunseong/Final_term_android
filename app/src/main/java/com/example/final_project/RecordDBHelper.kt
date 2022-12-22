package com.example.final_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecordDBHelper(context: Context) : SQLiteOpenHelper(context, "recordDB.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL("CREATE TABLE  recordTBL ( memberId TEXT, date TEXT, memo TEXT);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS recordTBL")
        onCreate(p0)
    }
    fun insertData(memberId : String?, date : String? , memo : String) : Boolean {
        val myDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("memberId",memberId)
        contentValues.put("date",date)
        contentValues.put("memo",memo)
        val result = myDB.insert("recordTBL",null,contentValues)

        if(result == -1L)
            return false
        return true
    }

    fun upgradeData(memberId : String?, date : String? , memo : String) : Unit {
        val myDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("memo",memo)
        val result = myDB.update("recordTBL ",contentValues,"date = ? AND memberId = ?", arrayOf(date,memberId))

        //var query = "UPDATE recordTBL SET memo = '"+memo+"' WHERE memberId ='"+memberId+"' AND date ='"+date+"';"
        //myDB.execSQL(query)

    }

    fun checkMemo(date: String, memberId: String) : String? {
        val myDB = this.writableDatabase
        val cursor = myDB.rawQuery("select * from recordTBL where date = ? and memberId = ?",arrayOf(date, memberId))
        var result : String? = null

        while(cursor.moveToNext()){
            result = cursor.getString(2)
        }
        return result
    }

    fun selectMemoById(memberId: String) : ArrayList<MemoByMemberIdInfo> {
        val myDB = this.writableDatabase
        val cursor = myDB.rawQuery("select * from recordTBL where memberId = ?",arrayOf(memberId))

        var arrayList = ArrayList<MemoByMemberIdInfo>(2)

        while(cursor.moveToNext()){
            var memoByMemberIdInfo  = MemoByMemberIdInfo()

            memoByMemberIdInfo.date = cursor.getString(1)
            memoByMemberIdInfo.memo = cursor.getString(2)

            arrayList.add(memoByMemberIdInfo)
        }
        return arrayList
    }
}
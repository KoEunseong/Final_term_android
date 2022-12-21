package com.example.final_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MemberDBHelper(context: Context) : SQLiteOpenHelper(context, "memberDB.db", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL("CREATE TABLE  memberTBL ( email TEXT PRIMARY KEY, name TEXT, password TEXT);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS memberTBL")
        onCreate(p0)
    }
    fun insertData(email : String?, name : String? , password : String) : Boolean {
        val myDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("email",email)
        contentValues.put("name",name)
        contentValues.put("password",password)
        val result = myDB.insert("memberTBL",null,contentValues)

        if(result == -1L)
            return false
        return true
    }

    fun checkEmail(email: String) : Boolean {
        val myDB = this.writableDatabase
        var res = true
        val cursor = myDB.rawQuery("select * from memberTBL where email = ?",arrayOf(email))
        if(cursor.count <= 0) res = false
        return !res
    }

    fun checkPassword(email: String, password: String) : Boolean {
        val myDB = this.writableDatabase
        var res = true
        val cursor = myDB.rawQuery("select * from memberTBL where email = ? and password = ?",arrayOf(email, password))
        if(cursor.count <= 0) res = false
        return res
    }
}
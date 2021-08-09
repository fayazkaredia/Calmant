package com.example.calmdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DBHelper( Context context) {
        super(context,"Login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table users (username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");

    }
    public boolean insertdata(String uname,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",uname);
        contentValues.put("password",pass);
        long result=db.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean Updatedata(String uname,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",pass);
        long result=db.update("users",contentValues,"username = ?",new String[]{uname});
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean checkusername(String uname){
    SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=?",new String[]{uname});
        if (cursor.getCount()>0)
            return  true;
        else
            return false;
    }
    public boolean checkusernamepass(String uname,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=? and password=?",new String[]{uname,pass});
        if (cursor.getCount()>0)
            return  true;
        else
            return false;
    }
}

package com.example.dekutapp.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDB extends SQLiteOpenHelper {

    public LoginDB(Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table users(firstname Text not null,lastname Text not null,RegNo Text not null, email Text not null primary key,password Text not null,constraint username unique(email,RegNo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists users");
    }

    public boolean insertUserData(String firstname,String lastname, String regNo, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("RegNo",regNo);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = db.insert("users",null,contentValues);
        return result != -1;
    }

    public boolean checkUser(String regNo, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("select * from users where RegNo = ? and email = ?",new String[]{regNo,email});
        return cursor.getCount() > 0;
    }

    public boolean checkUserEmailAndPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from users where email = ? and password = ?",new String[]{email,password});
        return cursor.getCount() > 0;
    }

}

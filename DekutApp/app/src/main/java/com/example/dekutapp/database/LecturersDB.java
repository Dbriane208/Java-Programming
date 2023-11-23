package com.example.dekutapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LecturersDB extends SQLiteOpenHelper {

    public LecturersDB(Context context) {
        super(context,"lecturers.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table lecturers(Name Text not null,Department Text not null,Email Text not null,Time Text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         db.execSQL("drop table if exists lecturers");
    }

    public  boolean insertLecturersData(String name,String department, String email,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Department",department);
        contentValues.put("Email",email);
        contentValues.put("Time",time);
        long result = db.insert("lecturers",null,contentValues);
        return result != -1;
    }

    public Cursor getAvailableLecturers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from lecturers ",null);
        return cursor;
    }
}

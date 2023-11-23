package com.example.dekutapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class StudentsDB extends SQLiteOpenHelper {

    public StudentsDB(Context context) {
        super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("Create Table students(Name Text not null,Course Text not null,Department Text not null,Email Text not null,Image blob not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists students");
    }

    public boolean insertStudentData(String name, String course, String department, String email, byte[] Image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Course",course);
        contentValues.put("Department",department);
        contentValues.put("Email",email);
        contentValues.put("Image",Image);
        long result = db.insert("students",null,contentValues);
        return result != -1;
    }

    public Cursor getAllStudents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from students ",null);
        return cursor;
    }
}

package com.foslipy.languagetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String Db_Name="Content";
    private static final int Db_Version=1;

    public DatabaseHelper(Context context) {
        super(context, Db_Name, null, Db_Version);
        Log.d("DataBase","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        String CreateContentTable="CREATE TABLE Content(levle TEXT,chapter_number VARCHAR,chapter_name VARCHAR,section_number VARCHAR, section_name VARCHAR, section_data VARCHAR, section_example VARCAR)";
        sqldb.execSQL(CreateContentTable);
        Log.d("DataBase","Content Table Created");
    }

    public void addContent(String lvl,String chno,String chname,String sectno,String sectname,String sectdata,String sectexp){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("lvl",lvl);
        contentValues.put("chno",chno);
        contentValues.put("chname",chname);
        contentValues.put("sectno",sectno);
        contentValues.put("sectname",sectname);
        contentValues.put("sectdata",sectdata);
        contentValues.put("sectexp",sectexp);
        db.insert("Content",null,contentValues);
        db.close();
        Log.d("DataBase","One row inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.foslipy.languagetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "LanguageTutorials.db";
    public static final int version = 1;
    public static final String Table_Name1 = "content";
    public static final String column1_1 = "levels";
    public static final String column2_1 = "chapter_no";
    public static final String column3_1 = "chapter_name";
    public static final String column4_1= "section_no";
    public static final String column5_1 = "section_name";
    public static final String column6_1 = "section_data";
    public static final String column7_1 = "section_example";

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table content (levels TEXT,chapter_no VARCHAR,chapter_name VARCHAR,section_no VARCHAR,section_name VARCHAR,section_data VARCHAR,section_example VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+Table_Name1);
            onCreate(db);
    }

    public boolean putData(String lvl, String chno, String chname, String sectno, String sectname, String sectdata, String sectexp){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1_1, lvl);
        contentValues.put(column2_1, chno);
        contentValues.put(column3_1, chname);
        contentValues.put(column4_1, sectno);
        contentValues.put(column5_1, sectname);
        contentValues.put(column6_1, sectdata);
        contentValues.put(column7_1, sectexp);
        long data = db.insert(Table_Name1,null,contentValues);
        if (data==-1)
        {
            return false;
        }else {
            return true;
        }
    }


    public Cursor getData(String lvl,String chno,String chnm,String sectno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections={column5_1,column6_1,column7_1};
        String selection=column1_1+" LIKE ? AND "+column2_1+" LIKE ? AND "+column3_1+" LIKE ? AND "+column4_1+" LIKE ?";
        String[] selection_args={lvl,chno,chnm,sectno};
        Cursor cr=db.query(Table_Name1,projections,selection,selection_args,null,null,null);
        return cr;
    }

    public Cursor getSectioNames(String lvl,String chnm){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections={column5_1};
        String selection=column1_1+" LIKE ?"+" AND "+column3_1+" LIKE ?";
        String[] selection_args={lvl,chnm};
        Cursor cr=db.query(Table_Name1,projections,selection,selection_args,null,null,null);
        return cr;
    }

    public Cursor getChapterNames(String lvl){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections ={column2_1,column3_1};
        String selection=column1_1+" LIKE ?";
        String[] selection_args={lvl};
        String  order=column2_1+" ASC";
        Cursor cr=db.query(Table_Name1,projections,selection,selection_args,null,null,order);
        return cr;
    }

}

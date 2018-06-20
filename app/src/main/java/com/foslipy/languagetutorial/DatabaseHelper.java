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
    public static final String column1 = "levels";
    public static final String column2 = "chapter_no";
    public static final String column3 = "chapter_name";
    public static final String column4 = "section_no";
    public static final String column5 = "section_name";
    public static final String column6 = "section_data";
    public static final String column7 = "section_example";
    public static final String Table_Name2 = "userData";

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table content (levels TEXT,chapter_no VARCHAR,chapter_name VARCHAR,section_no VARCHAR,section_name VARCHAR,section_data VARCHAR,section_example VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name1);
        onCreate(db);
    }

    public void putData(String lvl, String chno, String chname, String sectno, String sectname, String sectdata, String sectexp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1, lvl);
        contentValues.put(column2, chno);
        contentValues.put(column3, chname);
        contentValues.put(column4, sectno);
        contentValues.put(column5, sectname);
        contentValues.put(column6, sectdata);
        contentValues.put(column7, sectexp);
        long data = db.insert(Table_Name1, null, contentValues);
    }


    public Cursor getData(String lvl, String chno, String chnm, String sectno) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column5, column6, column7};
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ? AND " + column3 + " LIKE ? AND " + column4 + " LIKE ?";
        String[] selection_args = {lvl, chno, chnm, sectno};
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, null);
        return cr;
    }

    public Cursor getSectioNames(String lvl, String chnm) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column5};
        String selection = column1 + " LIKE ?" + " AND " + column3 + " LIKE ?";
        String[] selection_args = {lvl, chnm};
        String order=column4 + " ASC";
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, order);
        return cr;
    }

    public Cursor getChapterNames(String lvl) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column2, column3};
        String selection = column1 + " LIKE ?";
        String[] selection_args = {lvl};
        String order = column2 + " ASC";
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, order);
        return cr;
    }

    public Cursor checkIfDataExists(String lvl, String chno, String chname, String sectno, String sectname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column1, column2, column3, column4, column5};
        String selection = column1 +" LIKE ? AND "+ column2 +" LIKE ? AND "+ column3 +" LIKE ? AND "+ column4 +" LIKE ? AND " + column5 + " LIKE ?";
        String[] selection_args={lvl,chno,chname,sectno,sectname};
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, null);
        return cr;
    }

    public void deleteExistingRow(String lvl, String chno, String sectno) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = column1 +" LIKE ? AND "+ column2 +" LIKE ? AND "+ column4 +" LIKE ?";
        String[] selection_args={lvl,chno,sectno};
         db.delete(Table_Name1, selection, selection_args);
    }



}

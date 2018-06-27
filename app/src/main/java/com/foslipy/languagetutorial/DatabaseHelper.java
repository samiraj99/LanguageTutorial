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
    public static final String column1 = "languages";
    public static final String column2 = "levels";
    public static final String column3 = "chapter_no";
    public static final String column4 = "chapter_name";
    public static final String column5 = "section_no";
    public static final String column6 = "section_name";
    public static final String column7 = "section_data";
    public static final String column8 = "section_example";
    public static final String Table_Name2 = "userData";

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table content (languages TEXT,levels TEXT,chapter_no VARCHAR,chapter_name VARCHAR,section_no VARCHAR,section_name VARCHAR,section_data VARCHAR,section_example VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name1);
        onCreate(db);
    }

    public void putData(String lng, String lvl, String chno, String chname, String sectno, String sectname, String sectdata, String sectexp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1, lng);
        contentValues.put(column2, lvl);
        contentValues.put(column3, chno);
        contentValues.put(column4, chname);
        contentValues.put(column5, sectno);
        contentValues.put(column6, sectname);
        contentValues.put(column7, sectdata);
        contentValues.put(column8, sectexp);
        long data = db.insert(Table_Name1, null, contentValues);
    }


    public Cursor getData(String lng, String lvl, String chno, String chnm, String sectno) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column6, column7, column8};
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ? AND " + column3 + " LIKE ? AND " + column4 + " LIKE ? AND " + column5 + " LIKE ?";
        String[] selection_args = {lng, lvl, chno, chnm, sectno};
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, null);
        return cr;
    }

    public Cursor getSectionNames(String lng, String lvl, String chno) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column6};
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ? AND " + column3 + " LIKE ?";
        String[] selection_args = {lng, lvl, chno};
        String order = column5 + " ASC";
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, order);
        return cr;
    }

    public Cursor getChapterNames(String lng, String lvl) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column3, column4};
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ?";
        String[] selection_args = {lng, lvl};
        String order = column3 + " ASC";
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, order);
        return cr;
    }

    public Cursor checkIfDataExists(String lng, String lvl, String chno, String chname, String sectno, String sectname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] projections = {column1, column2, column3, column4, column5, column6};
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ? AND " + column3 + " LIKE ? AND " + column4 + " LIKE ? AND " + column5 + " LIKE ? AND " + column6 + " LIKE ?";
        String[] selection_args = {lng, lvl, chno, chname, sectno, sectname};
        Cursor cr = db.query(Table_Name1, projections, selection, selection_args, null, null, null);
        return cr;
    }

    public void deleteExistingRow(String lng, String lvl, String chno, String sectno) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = column1 + " LIKE ? AND " + column2 + " LIKE ? AND " + column3 + " LIKE ? AND " + column5 + " LIKE ?";
        String[] selection_args = {lng, lvl, chno, sectno};
        db.delete(Table_Name1, selection, selection_args);
    }


}

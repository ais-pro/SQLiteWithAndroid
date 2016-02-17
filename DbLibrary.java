package com.example.root.dbexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Al Imran Suvro on 2/17/16.
 */
public class DbLibrary extends SQLiteOpenHelper {
    public static final String DB="info.db";
    public static final String TABLE="info";
    public static final String C1="id";
    public static final String C2="name";


    public DbLibrary(Context context) {
        super(context, DB, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
        Log.d("tableData","0");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE + " (id integer PRIMARY KEY autoincrement, name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

    public Boolean addNew(){
        try{
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(C2, "Suvro");
            long l=db.insert(TABLE,null,cv);
            Log.d("tableDataResult",String.valueOf(l));
            if(l==-1)return false;
            else return true;

        }catch (Throwable t){
            Log.d("tableData",t.toString());
        }

        return false;
    }
}

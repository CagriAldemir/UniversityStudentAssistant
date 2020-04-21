package tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.MyLog;

public class Donem implements BaseModel<Donem> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private String donemAdi;
    private int donemID;

    public Donem(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Donem(SQLiteOpenHelper mDatabase, String donemAdi, int donemID) {
        this.mDatabase = mDatabase;
        this.donemAdi = donemAdi;
        this.donemID = donemID;
    }

    //region Getters Setters
    public String getDonemAdi() {
        return donemAdi;
    }

    public void setDonemAdi(String donemAdi) {
        this.donemAdi = donemAdi;
    }

    public int getDonemID() {
        return donemID;
    }

    public void setDonemID(int donemID) {
        this.donemID = donemID;
    }
    //endregion


    @Override
    public boolean save() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_DONEMLER_donemAdi, getDonemAdi());

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_DONEMLER, null, values);
        if (result == -1) {
            MyLog.i(TAG, "save()", "Insert success!");
            return false;
        } else {
            MyLog.e(TAG, "save()", "Insert error!");
            return true;
        }
    }

    @Override
    public int update() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_DONEMLER_donemAdi, getDonemAdi());

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_DONEMLER, values, DatabaseSchema.COL_DERSLER_dersID + " =? ", new String[]{String.valueOf(getDonemID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_DONEMLER_donemID};

        // validation
        String selection = DatabaseSchema.COL_DONEMLER_donemID + " =? ";

        //arguments
        String[] args = {String.valueOf(getDonemID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DONEMLER,
                columns, //return
                selection, //where clause
                args, // value of the clause
                null,
                null,
                null);

        int count = cursor.getCount();
        cursor.close();
        mDatabase.close();
        if (count > 0) {
            MyLog.i(TAG, "check", "TRUE");
            return true;
        }
        MyLog.i(TAG, "check", "FALSE");
        return false;
    }

    @Override
    public void getByID() {

        String[] columns = {
                DatabaseSchema.COL_DONEMLER_donemID,
                DatabaseSchema.COL_DONEMLER_donemAdi
        };

        String selection = DatabaseSchema.COL_DONEMLER_donemID + " =? ";
        String[] args = {String.valueOf(getDonemID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DONEMLER, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");

            setDonemAdi(cursor.getString(1));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }

    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_DONEMLER, DatabaseSchema.COL_DONEMLER_donemID + " =? ", new String[]{String.valueOf(getDonemID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Donem> getAllByID(String where, String[] args) {

        List<Donem> mList;

        String[] columns = {
                DatabaseSchema.COL_DERSLER_dersID,
                DatabaseSchema.COL_DERSLER_donemID,
                DatabaseSchema.COL_DERSLER_dersAdi,
                DatabaseSchema.COL_DERSLER_dersKodu,
                DatabaseSchema.COL_DERSLER_dersKredisi,
                DatabaseSchema.COL_DERSLER_dersHarfNotu,
                DatabaseSchema.COL_DERSLER_dersDevamsizlikSiniri,
                DatabaseSchema.COL_DERSLER_dersYeri,
                DatabaseSchema.COL_DERSLER_dersGunuSaati
        };

        String selection = DatabaseSchema.COL_DERSLER_dersID + " =? ";

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DERSLER, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            mList = new ArrayList<>();

            while (cursor.moveToNext()) {
                setDonemID(cursor.getInt(0));
                setDonemAdi(cursor.getString(1));

                mList.add(this);
            }
            MyLog.i(TAG, "getAllByID", "Success!");
            return mList;
        } else {
            MyLog.i(TAG, "getAllByID", "Failed!");
            return null;
        }
    }

}
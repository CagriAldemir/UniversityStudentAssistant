package tr.com.cagrialdemir.universitystudentassistant.Core.Data.Models;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.MyLog;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Sinav implements BaseModel<Sinav> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private int dersID;
    private int sinavID;
    private int sinavNotu;
    private Date sinavTarihi;
    private int sinavTipi;
    private String sinavYeri;
    private int sinavYuzdesi;

    public Sinav(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Sinav(SQLiteOpenHelper mDatabase, int dersID, int sinavID, int sinavNotu, Date sinavTarihi, int sinavTipi, String sinavYeri, int sinavYuzdesi) {
        this.mDatabase = mDatabase;
        this.dersID = dersID;
        this.sinavID = sinavID;
        this.sinavNotu = sinavNotu;
        this.sinavTarihi = sinavTarihi;
        this.sinavTipi = sinavTipi;
        this.sinavYeri = sinavYeri;
        this.sinavYuzdesi = sinavYuzdesi;
    }

    //region Getters Setters
    public int getDersID() {
        return dersID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public int getSinavID() {
        return sinavID;
    }

    public void setSinavID(int sinavID) {
        this.sinavID = sinavID;
    }

    public int getSinavNotu() {
        return sinavNotu;
    }

    public void setSinavNotu(int sinavNotu) {
        this.sinavNotu = sinavNotu;
    }

    public Date getSinavTarihi() {
        return sinavTarihi;
    }

    public void setSinavTarihi(Date sinavTarihi) {
        this.sinavTarihi = sinavTarihi;
    }

    public int getSinavTipi() {
        return sinavTipi;
    }

    public void setSinavTipi(int sinavTipi) {
        this.sinavTipi = sinavTipi;
    }

    public String getSinavYeri() {
        return sinavYeri;
    }

    public void setSinavYeri(String sinavYeri) {
        this.sinavYeri = sinavYeri;
    }

    public int getSinavYuzdesi() {
        return sinavYuzdesi;
    }

    public void setSinavYuzdesi(int sinavYuzdesi) {
        this.sinavYuzdesi = sinavYuzdesi;
    }
    //endregion


    @Override
    public boolean save() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_SINAVLAR_dersID, getDersID());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavYeri, getSinavYeri());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavTarihi, UtilsDateTime.dateToString(getSinavTarihi()));
        values.put(DatabaseSchema.COL_SINAVLAR_sinavTipi, getSinavTipi());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavNotu, getSinavNotu());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavYuzdesi, getSinavYuzdesi());

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_SINAVLAR, null, values);
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

        values.put(DatabaseSchema.COL_SINAVLAR_dersID, getDersID());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavYeri, getSinavYeri());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavTarihi, UtilsDateTime.dateToString(getSinavTarihi()));
        values.put(DatabaseSchema.COL_SINAVLAR_sinavTipi, getSinavTipi());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavNotu, getSinavNotu());
        values.put(DatabaseSchema.COL_SINAVLAR_sinavYuzdesi, getSinavYuzdesi());

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_SINAVLAR, values, DatabaseSchema.COL_SINAVLAR_sinavID + " =? ", new String[]{String.valueOf(getSinavID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_SINAVLAR_sinavID};

        // validation
        String selection = DatabaseSchema.COL_SINAVLAR_sinavID + " =? ";

        //arguments
        String[] args = {String.valueOf(getSinavID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_SINAVLAR,
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
                DatabaseSchema.COL_SINAVLAR_sinavID,
                DatabaseSchema.COL_SINAVLAR_dersID,
                DatabaseSchema.COL_SINAVLAR_sinavYeri,
                DatabaseSchema.COL_SINAVLAR_sinavTarihi,
                DatabaseSchema.COL_SINAVLAR_sinavTipi,
                DatabaseSchema.COL_SINAVLAR_sinavNotu,
                DatabaseSchema.COL_SINAVLAR_sinavYuzdesi
        };

        String selection = DatabaseSchema.COL_SINAVLAR_sinavID + " =? ";
        String[] args = {String.valueOf(getSinavID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_SINAVLAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");
            setDersID(cursor.getInt(1));
            setSinavYeri(cursor.getString(2));
            setSinavTarihi(UtilsDateTime.stringToDate(cursor.getString(3)));
            setSinavTipi(cursor.getInt(4));
            setSinavNotu(cursor.getInt(5));
            setSinavYuzdesi(cursor.getInt(6));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }

    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_SINAVLAR, DatabaseSchema.COL_SINAVLAR_sinavID + " =? ", new String[]{String.valueOf(getSinavID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Sinav> getAllByID(String where, String[] args) {

        List<Sinav> mList;

        String[] columns = {
                DatabaseSchema.COL_SINAVLAR_sinavID,
                DatabaseSchema.COL_SINAVLAR_dersID,
                DatabaseSchema.COL_SINAVLAR_sinavYeri,
                DatabaseSchema.COL_SINAVLAR_sinavTarihi,
                DatabaseSchema.COL_SINAVLAR_sinavTipi,
                DatabaseSchema.COL_SINAVLAR_sinavNotu,
                DatabaseSchema.COL_SINAVLAR_sinavYuzdesi
        };

        String selection = DatabaseSchema.COL_SINAVLAR_sinavID + " =? ";

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_SINAVLAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            mList = new ArrayList<>();

            while (cursor.moveToNext()) {
                setSinavID(cursor.getInt(0));
                setDersID(cursor.getInt(1));
                setSinavYeri(cursor.getString(2));
                setSinavTarihi(UtilsDateTime.stringToDate(cursor.getString(3)));
                setSinavTipi(cursor.getInt(4));
                setSinavNotu(cursor.getInt(5));
                setSinavYuzdesi(cursor.getInt(6));

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
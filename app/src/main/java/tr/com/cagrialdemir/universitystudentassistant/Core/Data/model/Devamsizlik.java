package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.MyLog;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Devamsizlik implements BaseModel<Devamsizlik> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private int dersID;
    private int devamsizlikID;
    private int devamsizlikSaatSayisi;
    private Date devamsizlikTarihi;

    public Devamsizlik(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Devamsizlik(SQLiteOpenHelper mDatabase, int dersID, int devamsizlikID, int devamsizlikSaatSayisi, Date devamsizlikTarihi) {
        this.mDatabase = mDatabase;
        this.dersID = dersID;
        this.devamsizlikID = devamsizlikID;
        this.devamsizlikSaatSayisi = devamsizlikSaatSayisi;
        this.devamsizlikTarihi = devamsizlikTarihi;
    }

    //region Getters Setters
    public int getDersID() {
        return dersID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public int getDevamsizlikID() {
        return devamsizlikID;
    }

    public void setDevamsizlikID(int devamsizlikID) {
        this.devamsizlikID = devamsizlikID;
    }

    public int getDevamsizlikSaatSayisi() {
        return devamsizlikSaatSayisi;
    }

    public void setDevamsizlikSaatSayisi(int devamsizlikSaatSayisi) {
        this.devamsizlikSaatSayisi = devamsizlikSaatSayisi;
    }

    public Date getDevamsizlikTarihi() {
        return devamsizlikTarihi;
    }

    public void setDevamsizlikTarihi(Date devamsizlikTarihi) {
        this.devamsizlikTarihi = devamsizlikTarihi;
    }
    //endregion


    @Override
    public boolean save() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID, getDersID());
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi, UtilsDateTime.dateToString(getDevamsizlikTarihi()));
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi, getDevamsizlikSaatSayisi());

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_DEVAMSIZLIKLAR, null, values);
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

        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID, getDersID());
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi, UtilsDateTime.dateToString(getDevamsizlikTarihi()));
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi, getDevamsizlikSaatSayisi());

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_DEVAMSIZLIKLAR, values, DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + " =? ", new String[]{String.valueOf(getDevamsizlikID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID};

        // validation
        String selection = DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + " =? ";

        //arguments
        String[] args = {String.valueOf(getDevamsizlikID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DEVAMSIZLIKLAR,
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
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi
        };

        String selection = DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + " =? ";
        String[] args = {String.valueOf(getDevamsizlikID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DEVAMSIZLIKLAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");
            setDevamsizlikID(cursor.getInt(1));
            setDersID(cursor.getInt(2));
            setDevamsizlikTarihi(UtilsDateTime.stringToDate(cursor.getString(3)));
            setDevamsizlikSaatSayisi(cursor.getInt(4));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }
    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_DEVAMSIZLIKLAR, DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + " =? ", new String[]{String.valueOf(getDevamsizlikID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Devamsizlik> getAllByID(String where, String[] args) {

        List<Devamsizlik> mList;

        String[] columns = {
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi,
                DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi
        };

        String selection = DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + " =? ";

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DEVAMSIZLIKLAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            mList = new ArrayList<>();

            while (cursor.moveToNext()) {
                setDevamsizlikID(cursor.getInt(0));
                setDersID(cursor.getInt(1));
                setDevamsizlikTarihi(UtilsDateTime.stringToDate(cursor.getString(2)));
                setDevamsizlikSaatSayisi(cursor.getInt(3));

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
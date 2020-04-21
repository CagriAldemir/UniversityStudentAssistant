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

public class Odev implements BaseModel<Odev> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private int dersID;
    private String odevAciklamasi;
    private String odevBasligi;
    private int odevID;
    private Date odevTarihi;

    public Odev(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Odev(SQLiteOpenHelper mDatabase, int dersID, String odevAciklamasi, String odevBasligi, int odevID, Date odevTarihi) {
        this.mDatabase = mDatabase;
        this.dersID = dersID;
        this.odevAciklamasi = odevAciklamasi;
        this.odevBasligi = odevBasligi;
        this.odevID = odevID;
        this.odevTarihi = odevTarihi;
    }

    //region Getters Setters
    public int getDersID() {
        return dersID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public String getOdevAciklamasi() {
        return odevAciklamasi;
    }

    public void setOdevAciklamasi(String odevAciklamasi) {
        this.odevAciklamasi = odevAciklamasi;
    }

    public String getOdevBasligi() {
        return odevBasligi;
    }

    public void setOdevBasligi(String odevBasligi) {
        this.odevBasligi = odevBasligi;
    }

    public int getOdevID() {
        return odevID;
    }

    public void setOdevID(int odevID) {
        this.odevID = odevID;
    }

    public Date getOdevTarihi() {
        return odevTarihi;
    }

    public void setOdevTarihi(Date odevTarihi) {
        this.odevTarihi = odevTarihi;
    }
    //endregion


    @Override
    public boolean save() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_ODEVLER_odevID, getDersID());
        values.put(DatabaseSchema.COL_ODEVLER_odevBasligi, getOdevBasligi());
        values.put(DatabaseSchema.COL_ODEVLER_odevAciklamasi, getOdevAciklamasi());
        values.put(DatabaseSchema.COL_ODEVLER_odevTarihi, UtilsDateTime.dateToString(getOdevTarihi()));

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_ODEVLER, null, values);
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

        values.put(DatabaseSchema.COL_ODEVLER_odevID, getDersID());
        values.put(DatabaseSchema.COL_ODEVLER_odevBasligi, getOdevBasligi());
        values.put(DatabaseSchema.COL_ODEVLER_odevAciklamasi, getOdevAciklamasi());
        values.put(DatabaseSchema.COL_ODEVLER_odevTarihi, UtilsDateTime.dateToString(getOdevTarihi()));

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_ODEVLER, values, DatabaseSchema.COL_ODEVLER_odevID + " =? ", new String[]{String.valueOf(getOdevID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_ODEVLER_odevID};

        // validation
        String selection = DatabaseSchema.COL_ODEVLER_odevID + " =? ";

        //arguments
        String[] args = {String.valueOf(getOdevID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_ODEVLER,
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
                DatabaseSchema.COL_ODEVLER_odevID,
                DatabaseSchema.COL_ODEVLER_dersID,
                DatabaseSchema.COL_ODEVLER_odevBasligi,
                DatabaseSchema.COL_ODEVLER_odevAciklamasi,
                DatabaseSchema.COL_ODEVLER_odevTarihi
        };

        String selection = DatabaseSchema.COL_ODEVLER_odevID + " =? ";
        String[] args = {String.valueOf(getOdevID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_ODEVLER, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");
            setDersID(cursor.getInt(1));
            setOdevBasligi(cursor.getString(2));
            setOdevAciklamasi(cursor.getString(3));
            setOdevTarihi(UtilsDateTime.stringToDate(cursor.getString(4)));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }

    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_ODEVLER, DatabaseSchema.COL_ODEVLER_odevID + " =? ", new String[]{String.valueOf(getOdevID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Odev> getAllByID(String where, String[] args) {

        List<Odev> mList;

        String[] columns = {
                DatabaseSchema.COL_ODEVLER_odevID,
                DatabaseSchema.COL_ODEVLER_dersID,
                DatabaseSchema.COL_ODEVLER_odevBasligi,
                DatabaseSchema.COL_ODEVLER_odevAciklamasi,
                DatabaseSchema.COL_ODEVLER_odevTarihi
        };

        String selection = DatabaseSchema.COL_ODEVLER_odevID + " =? ";

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_ODEVLER, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            mList = new ArrayList<>();

            while (cursor.moveToNext()) {
                setOdevID(cursor.getInt(0));
                setDersID(cursor.getInt(1));
                setOdevBasligi(cursor.getString(2));
                setOdevAciklamasi(cursor.getString(3));
                setOdevTarihi(UtilsDateTime.stringToDate(cursor.getString(4)));

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
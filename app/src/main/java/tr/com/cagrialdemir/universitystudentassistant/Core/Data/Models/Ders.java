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

public class Ders implements BaseModel<Ders> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private String dersAdi;
    private int dersDevamsizlikSiniri;
    private Date dersGunuSaati;
    private int dersHarfNotu;
    private int dersID;
    private String dersKodu;
    private int dersKredisi;
    private String dersYeri;
    private int donemID;

    public Ders(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Ders(SQLiteOpenHelper mDatabase, String dersAdi, int dersDevamsizlikSiniri, Date dersGunuSaati, int dersHarfNotu, String dersKodu, int dersKredisi, String dersYeri, int donemID) {
        this.mDatabase = mDatabase;
        this.dersAdi = dersAdi;
        this.dersDevamsizlikSiniri = dersDevamsizlikSiniri;
        this.dersGunuSaati = dersGunuSaati;
        this.dersHarfNotu = dersHarfNotu;
        this.dersKodu = dersKodu;
        this.dersKredisi = dersKredisi;
        this.dersYeri = dersYeri;
        this.donemID = donemID;
    }

    //region Getters Setters
    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersDevamsizlikSiniri() {
        return dersDevamsizlikSiniri;
    }

    public void setDersDevamsizlikSiniri(int dersDevamsizlikSiniri) {
        this.dersDevamsizlikSiniri = dersDevamsizlikSiniri;
    }

    public Date getDersGunuSaati() {
        return dersGunuSaati;
    }

    public void setDersGunuSaati(Date dersGunuSaati) {
        this.dersGunuSaati = dersGunuSaati;
    }

    public int getDersHarfNotu() {
        return dersHarfNotu;
    }

    public void setDersHarfNotu(int dersHarfNotu) {
        this.dersHarfNotu = dersHarfNotu;
    }

    public int getDersID() {
        return dersID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public int getDersKredisi() {
        return dersKredisi;
    }

    public void setDersKredisi(int dersKredisi) {
        this.dersKredisi = dersKredisi;
    }

    public String getDersYeri() {
        return dersYeri;
    }

    public void setDersYeri(String dersYeri) {
        this.dersYeri = dersYeri;
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

        values.put(DatabaseSchema.COL_DERSLER_donemID, getDonemID());
        values.put(DatabaseSchema.COL_DERSLER_dersAdi, getDersAdi());
        values.put(DatabaseSchema.COL_DERSLER_dersKodu, getDersKodu());
        values.put(DatabaseSchema.COL_DERSLER_dersKredisi, getDersKredisi());
        values.put(DatabaseSchema.COL_DERSLER_dersHarfNotu, getDersHarfNotu());
        values.put(DatabaseSchema.COL_DERSLER_dersDevamsizlikSiniri, getDersDevamsizlikSiniri());
        values.put(DatabaseSchema.COL_DERSLER_dersYeri, getDersYeri());
        values.put(DatabaseSchema.COL_DERSLER_dersGunuSaati, UtilsDateTime.dateToString(getDersGunuSaati()));

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_DERSLER, null, values);
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

        values.put(DatabaseSchema.COL_DERSLER_donemID, getDonemID());
        values.put(DatabaseSchema.COL_DERSLER_dersAdi, getDersAdi());
        values.put(DatabaseSchema.COL_DERSLER_dersKodu, getDersKodu());
        values.put(DatabaseSchema.COL_DERSLER_dersKredisi, getDersKredisi());
        values.put(DatabaseSchema.COL_DERSLER_dersHarfNotu, getDersHarfNotu());
        values.put(DatabaseSchema.COL_DERSLER_dersDevamsizlikSiniri, getDersDevamsizlikSiniri());
        values.put(DatabaseSchema.COL_DERSLER_dersYeri, getDersYeri());
        values.put(DatabaseSchema.COL_DERSLER_dersGunuSaati, UtilsDateTime.dateToString(getDersGunuSaati()));

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_DERSLER, values, DatabaseSchema.COL_DERSLER_dersID + " =? ", new String[]{String.valueOf(getDersID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_DERSLER_dersID};

        // validation
        String selection = DatabaseSchema.COL_DERSLER_dersID + " =? ";

        //arguments
        String[] args = {String.valueOf(getDersID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DERSLER,
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
        String[] args = {String.valueOf(getDersID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_DERSLER, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");
            setDonemID(cursor.getInt(1));
            setDersAdi(cursor.getString(2));
            setDersKodu(cursor.getString(3));
            setDersKredisi(cursor.getInt(4));
            setDersHarfNotu(cursor.getInt(5));
            setDersDevamsizlikSiniri(cursor.getInt(6));
            setDersYeri(cursor.getString(7));
            setDersGunuSaati(UtilsDateTime.stringToDate(cursor.getString(8)));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }
    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_DERSLER, DatabaseSchema.COL_DERSLER_dersID + " =? ", new String[]{String.valueOf(getDersID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Ders> getAllByID(String where, String[] args) {

        List<Ders> mList;

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
                setDersID(cursor.getInt(0));
                setDonemID(cursor.getInt(1));
                setDersAdi(cursor.getString(2));
                setDersKodu(cursor.getString(3));
                setDersKredisi(cursor.getInt(4));
                setDersHarfNotu(cursor.getInt(5));
                setDersDevamsizlikSiniri(cursor.getInt(6));
                setDersYeri(cursor.getString(7));
                setDersGunuSaati(UtilsDateTime.stringToDate(cursor.getString(8)));

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
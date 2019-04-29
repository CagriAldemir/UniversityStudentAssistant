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

public class Hatirlatma implements BaseModel<Hatirlatma> {

    private final String TAG = this.getClass().getSimpleName();

    private SQLiteOpenHelper mDatabase;

    private String hatirlatmaAciklamasi;
    private String hatirlatmaBasligi;
    private boolean hatirlatmaBildirimDurumu;
    private int hatirlatmaBildirimNeKadarOnceGonderilecek;
    private int hatirlatmaID;
    private Date hatirlatmaTarihi;

    public Hatirlatma(SQLiteOpenHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    public Hatirlatma(SQLiteOpenHelper mDatabase, String hatirlatmaAciklamasi, String hatirlatmaBasligi, boolean hatirlatmaBildirimDurumu, int hatirlatmaBildirimNeKadarOnceGonderilecek, int hatirlatmaID, Date hatirlatmaTarihi) {
        this.mDatabase = mDatabase;
        this.hatirlatmaAciklamasi = hatirlatmaAciklamasi;
        this.hatirlatmaBasligi = hatirlatmaBasligi;
        this.hatirlatmaBildirimDurumu = hatirlatmaBildirimDurumu;
        this.hatirlatmaBildirimNeKadarOnceGonderilecek = hatirlatmaBildirimNeKadarOnceGonderilecek;
        this.hatirlatmaID = hatirlatmaID;
        this.hatirlatmaTarihi = hatirlatmaTarihi;
    }

    //region Getters Setters
    public String getHatirlatmaAciklamasi() {
        return hatirlatmaAciklamasi;
    }

    public void setHatirlatmaAciklamasi(String hatirlatmaAciklamasi) {
        this.hatirlatmaAciklamasi = hatirlatmaAciklamasi;
    }

    public String getHatirlatmaBasligi() {
        return hatirlatmaBasligi;
    }

    public void setHatirlatmaBasligi(String hatirlatmaBasligi) {
        this.hatirlatmaBasligi = hatirlatmaBasligi;
    }

    public boolean isHatirlatmaBildirimDurumu() {
        return hatirlatmaBildirimDurumu;
    }

    public void setHatirlatmaBildirimDurumu(boolean hatirlatmaBildirimDurumu) {
        this.hatirlatmaBildirimDurumu = hatirlatmaBildirimDurumu;
    }

    public int getHatirlatmaBildirimNeKadarOnceGonderilecek() {
        return hatirlatmaBildirimNeKadarOnceGonderilecek;
    }

    public void setHatirlatmaBildirimNeKadarOnceGonderilecek(int hatirlatmaBildirimNeKadarOnceGonderilecek) {
        this.hatirlatmaBildirimNeKadarOnceGonderilecek = hatirlatmaBildirimNeKadarOnceGonderilecek;
    }

    public int getHatirlatmaID() {
        return hatirlatmaID;
    }

    public void setHatirlatmaID(int hatirlatmaID) {
        this.hatirlatmaID = hatirlatmaID;
    }

    public Date getHatirlatmaTarihi() {
        return hatirlatmaTarihi;
    }

    public void setHatirlatmaTarihi(Date hatirlatmaTarihi) {
        this.hatirlatmaTarihi = hatirlatmaTarihi;
    }
    //endregion


    @Override
    public boolean save() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID, getHatirlatmaID());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi, getHatirlatmaBasligi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi, getHatirlatmaAciklamasi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi, UtilsDateTime.dateToString(getHatirlatmaTarihi()));
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu, isHatirlatmaBildirimDurumu());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek, getHatirlatmaBildirimNeKadarOnceGonderilecek());

        long result = mDatabase.getWritableDatabase().insert(DatabaseSchema.TABLE_HATIRLATMALAR, null, values);
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

        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID, getHatirlatmaID());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi, getHatirlatmaBasligi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi, getHatirlatmaAciklamasi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi, UtilsDateTime.dateToString(getHatirlatmaTarihi()));
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu, isHatirlatmaBildirimDurumu());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek, getHatirlatmaBildirimNeKadarOnceGonderilecek());

        return mDatabase.getWritableDatabase().update(DatabaseSchema.TABLE_HATIRLATMALAR, values, DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + " =? ", new String[]{String.valueOf(getHatirlatmaID())});
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public boolean check() {
        //columns to fetch
        String[] columns = {DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID};

        // validation
        String selection = DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + " =? ";

        //arguments
        String[] args = {String.valueOf(getHatirlatmaID())};

        //query to user table
        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_HATIRLATMALAR,
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
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek
        };

        String selection = DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + " =? ";
        String[] args = {String.valueOf(getHatirlatmaID())};

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_HATIRLATMALAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            MyLog.i(TAG, "getByID", "Row found!");
            setHatirlatmaBasligi(cursor.getString(1));
            setHatirlatmaAciklamasi(cursor.getString(2));
            setHatirlatmaTarihi(UtilsDateTime.stringToDate(cursor.getString(3)));
            setHatirlatmaBildirimDurumu((cursor.getInt(4) != 0));
            setHatirlatmaBildirimNeKadarOnceGonderilecek(cursor.getInt(5));
        } else {
            MyLog.i(TAG, "getByID", "Row not found!");

            //todo Logları kontrol et.
        }
    }

    @Override
    public boolean delete() {
        return mDatabase.getWritableDatabase().delete(DatabaseSchema.TABLE_HATIRLATMALAR, DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + " =? ", new String[]{String.valueOf(getHatirlatmaID())}) > 0;
        //todo Return edilen integer değere göre log metodu yaz.
    }

    @Override
    public List<Hatirlatma> getAllByID(String where, String[] args) {

        List<Hatirlatma> mList;

        String[] columns = {
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu,
                DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek
        };

        String selection = DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + " =? ";

        Cursor cursor = mDatabase.getReadableDatabase().query(DatabaseSchema.TABLE_HATIRLATMALAR, columns, selection, args, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            mList = new ArrayList<>();

            while (cursor.moveToNext()) {
                setHatirlatmaID(cursor.getInt(0));
                setHatirlatmaBasligi(cursor.getString(1));
                setHatirlatmaAciklamasi(cursor.getString(2));
                setHatirlatmaTarihi(UtilsDateTime.stringToDate(cursor.getString(3)));
                setHatirlatmaBildirimDurumu((cursor.getInt(4) != 0));
                setHatirlatmaBildirimNeKadarOnceGonderilecek(cursor.getInt(5));

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
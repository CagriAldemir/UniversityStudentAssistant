package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;

import java.util.Date;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Sinav implements BaseModel {

    private int dersID;
    private int sinavID;
    private int sinavNotu;
    private Date sinavTarihi;
    private int sinavTipi;
    private String sinavYeri;
    private int sinavYuzdesi;

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

        return mSqLiteHelper.insertData(SqliteTable.TABLE_USER, values);
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

        return sqliteHelper.updateData(SqliteTable.TABLE_USER, values, email);
    }

    @Override
    public boolean check() {
        return sqliteHelper.checkUser(email, password);
    }

    @Override
    public void getByID() {
        return sqliteHelper.getUserDetail(id);
    }

    @Override
    public boolean delete() {
        return sqliteHelper.deleteUser(email);
    }
}
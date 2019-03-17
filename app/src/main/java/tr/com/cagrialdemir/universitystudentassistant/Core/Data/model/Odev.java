package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;

import java.util.Date;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Odev implements BaseModel {

    private int dersID;
    private String odevAciklamasi;
    private String odevBasligi;
    private int odevID;
    private Date odevTarihi;

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

        values.put(DatabaseSchema.COL_ODEVLER_dersID, getDersID());
        values.put(DatabaseSchema.COL_ODEVLER_odevBasligi, getOdevBasligi());
        values.put(DatabaseSchema.COL_ODEVLER_odevAciklamasi, getOdevAciklamasi());
        values.put(DatabaseSchema.COL_ODEVLER_odevTarihi, UtilsDateTime.dateToString(getOdevTarihi()));

        return mSqLiteHelper.insertData(SqliteTable.TABLE_USER, values);
    }

    @Override
    public int update() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_ODEVLER_dersID, getDersID());
        values.put(DatabaseSchema.COL_ODEVLER_odevBasligi, getOdevBasligi());
        values.put(DatabaseSchema.COL_ODEVLER_odevAciklamasi, getOdevAciklamasi());
        values.put(DatabaseSchema.COL_ODEVLER_odevTarihi, UtilsDateTime.dateToString(getOdevTarihi()));

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
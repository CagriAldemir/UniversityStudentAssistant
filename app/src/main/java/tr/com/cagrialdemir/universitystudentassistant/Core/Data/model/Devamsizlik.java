package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;

import java.util.Date;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Devamsizlik implements BaseModel {

    private int dersID;
    private int devamsizlikID;
    private int devamsizlikSaatSayisi;
    private Date devamsizlikTarihi;

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

        return mSqLiteHelper.insertData(SqliteTable.TABLE_USER, values);
    }

    @Override
    public int update() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID, getDersID());
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi, UtilsDateTime.dateToString(getDevamsizlikTarihi()));
        values.put(DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi, getDevamsizlikSaatSayisi());

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
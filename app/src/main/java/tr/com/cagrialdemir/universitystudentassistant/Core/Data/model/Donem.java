package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;

public class Donem implements BaseModel {

    private String donemAdi;
    private int donemID;

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

        return mSqLiteHelper.insertData(SqliteTable.TABLE_USER, values);
    }

    @Override
    public int update() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_DONEMLER_donemAdi, getDonemAdi());
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
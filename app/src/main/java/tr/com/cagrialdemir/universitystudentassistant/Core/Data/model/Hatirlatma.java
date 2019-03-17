package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import android.content.ContentValues;

import java.util.Date;

import tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite.DatabaseSchema;
import tr.com.cagrialdemir.universitystudentassistant.Core.Utils.UtilsDateTime;

public class Hatirlatma implements BaseModel {

    private String hatirlatmaAciklamasi;
    private String hatirlatmaBasligi;
    private boolean hatirlatmaBildirimDurumu;
    private int hatirlatmaBildirimNeKadarOnceGonderilecek;
    private int hatirlatmaID;
    private Date hatirlatmaTarihi;


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

        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi, getHatirlatmaBasligi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi, getHatirlatmaAciklamasi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi, UtilsDateTime.dateToString(getHatirlatmaTarihi()));
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu, isHatirlatmaBildirimDurumu());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek, getHatirlatmaBildirimNeKadarOnceGonderilecek());

        return mSqLiteHelper.insertData(SqliteTable.TABLE_USER, values);
    }

    @Override
    public int update() {
        ContentValues values = new ContentValues();

        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi, getHatirlatmaBasligi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi, getHatirlatmaAciklamasi());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi, UtilsDateTime.dateToString(getHatirlatmaTarihi()));
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu, isHatirlatmaBildirimDurumu());
        values.put(DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek, getHatirlatmaBildirimNeKadarOnceGonderilecek());

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
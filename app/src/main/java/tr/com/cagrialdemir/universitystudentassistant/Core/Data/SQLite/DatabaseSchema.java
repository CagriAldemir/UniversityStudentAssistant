package tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite;

public class DatabaseSchema {

    static final String CREATE_DONEMLER = "CREATE TABLE '" + DatabaseSchema.TABLE_DONEMLER + "' (\n" +
            " '" + DatabaseSchema.COL_DONEMLER_donemID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_DONEMLER_donemAdi + "' INTEGER NOT NULL\n" +
            ")";


    static final String CREATE_DERSLER = "CREATE TABLE '" + DatabaseSchema.TABLE_DERSLER + "' (\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_DERSLER_donemID + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersAdi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersKodu + "' TEXT,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersKredisi + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersHarfNotu + "' INTEGER,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersDevamsizlikSiniri + "' INTEGER,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersYeri + "' TEXT,\n" +
            " '" + DatabaseSchema.COL_DERSLER_dersGunuSaati + "' TEXT,\n" +
            " FOREIGN KEY('" + DatabaseSchema.COL_DERSLER_donemID + "') REFERENCES '" + DatabaseSchema.TABLE_DONEMLER + "'('" + DatabaseSchema.COL_DONEMLER_donemID + "')\n" +
            ")";


    static final String CREATE_DEVAMSIZLIKLAR = "CREATE TABLE '" + DatabaseSchema.TABLE_DEVAMSIZLIKLAR + "' (\n" +
            " '" + DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikTarihi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi + "' INTEGER NOT NULL,\n" +
            " FOREIGN KEY('" + DatabaseSchema.COL_DEVAMSIZLIKLAR_dersID + "') REFERENCES '" + DatabaseSchema.TABLE_DERSLER + "'('" + DatabaseSchema.COL_DERSLER_dersID + "')\n" +
            ")";


    static final String CREATE_HATIRLATMALAR = "CREATE TABLE '" + DatabaseSchema.TABLE_HATIRLATMALAR + "' (\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBasligi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaAciklamasi + "' TEXT,\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaTarihi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimDurumu + "' INTEGER,\n" +
            " '" + DatabaseSchema.COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek + "' INTEGER\n" +
            ")";


    static final String CREATE_ODEVLER = "CREATE TABLE '" + DatabaseSchema.TABLE_ODEVLER + "' (\n" +
            " '" + DatabaseSchema.COL_ODEVLER_odevID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_ODEVLER_dersID + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_ODEVLER_odevBasligi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_ODEVLER_odevAciklamasi + "' TEXT,\n" +
            " '" + DatabaseSchema.COL_ODEVLER_odevTarihi + "' TEXT,\n" +
            " FOREIGN KEY('" + DatabaseSchema.COL_ODEVLER_dersID + "') REFERENCES '" + DatabaseSchema.TABLE_DERSLER + "'('" + DatabaseSchema.COL_DERSLER_dersID + "')\n" +
            ")";


    static final String CREATE_SINAVLAR = "CREATE TABLE '" + DatabaseSchema.TABLE_SINAVLAR + "' (\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavID + "' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_dersID + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavYeri + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavTarihi + "' TEXT NOT NULL,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavTipi + "' INTEGER NOT NULL,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavNotu + "' INTEGER,\n" +
            " '" + DatabaseSchema.COL_SINAVLAR_sinavYuzdesi + "' INTEGER NOT NULL,\n" +
            " FOREIGN KEY('" + DatabaseSchema.COL_SINAVLAR_dersID + "') REFERENCES '" + DatabaseSchema.TABLE_DERSLER + "'('" + DatabaseSchema.COL_DERSLER_dersID + "')\n" +
            ")";


    //region TABLE DONEMLER
    public static final String TABLE_DONEMLER = "DONEMLER";

    public static final String COL_DONEMLER_donemID = "donemID";
    public static final String COL_DONEMLER_donemAdi = "donemAdi";
    //endregion

    //region TABLE DERSLER
    public static final String TABLE_DERSLER = "DERSLER";

    public static final String COL_DERSLER_dersID = "dersID";
    public static final String COL_DERSLER_donemID = "donemID";
    public static final String COL_DERSLER_dersAdi = "dersAdi";
    public static final String COL_DERSLER_dersKodu = "dersKodu";
    public static final String COL_DERSLER_dersKredisi = "dersKredisi";
    public static final String COL_DERSLER_dersHarfNotu = "dersHarfNotu";
    public static final String COL_DERSLER_dersDevamsizlikSiniri = "dersDevamsizlikSiniri";
    public static final String COL_DERSLER_dersYeri = "dersYeri";
    public static final String COL_DERSLER_dersGunuSaati = "dersGunuSaati";
    //endregion

    //region TABLE DEVAMSIZLIKLAR
    public static final String TABLE_DEVAMSIZLIKLAR = "DEVAMSIZLIKLAR";

    public static final String COL_DEVAMSIZLIKLAR_devamsizlikID = "devamsizlikID";
    public static final String COL_DEVAMSIZLIKLAR_dersID = "dersID";
    public static final String COL_DEVAMSIZLIKLAR_devamsizlikTarihi = "devamsizlikTarihi";
    public static final String COL_DEVAMSIZLIKLAR_devamsizlikSaatSayisi = "devamsizlikSaatSayisi";
    //endregion

    //region TABLE HATIRLATMALAR
    public static final String TABLE_HATIRLATMALAR = "HATIRLATMALAR";

    public static final String COL_HATIRLATMALAR_hatirlatmaID = "hatirlatmaID";
    public static final String COL_HATIRLATMALAR_hatirlatmaBasligi = "hatirlatmaBasligi";
    public static final String COL_HATIRLATMALAR_hatirlatmaAciklamasi = "hatirlatmaAciklamasi";
    public static final String COL_HATIRLATMALAR_hatirlatmaTarihi = "hatirlatmaTarihi";
    public static final String COL_HATIRLATMALAR_hatirlatmaBildirimDurumu = "hatirlatmaBildirimDurumu";
    public static final String COL_HATIRLATMALAR_hatirlatmaBildirimNeKadarOnceGonderilecek = "hatirlatmaBildirimNeKadarOnceGonderilecek";
    //endregion

    //region TABLE ODEVLER
    public static final String TABLE_ODEVLER = "ODEVLER";

    public static final String COL_ODEVLER_odevID = "odevID";
    public static final String COL_ODEVLER_dersID = "dersID";
    public static final String COL_ODEVLER_odevBasligi = "odevBasligi";
    public static final String COL_ODEVLER_odevAciklamasi = "odevAciklamasi";
    public static final String COL_ODEVLER_odevTarihi = "odevTarihi";
    //endregion

    //region TABLE SINAVLAR
    public static final String TABLE_SINAVLAR = "SINAVLAR";

    public static final String COL_SINAVLAR_sinavID = "sinavID";
    public static final String COL_SINAVLAR_dersID = "dersID";
    public static final String COL_SINAVLAR_sinavYeri = "sinavYeri";
    public static final String COL_SINAVLAR_sinavTarihi = "sinavTarihi";
    public static final String COL_SINAVLAR_sinavTipi = "sinavTipi";
    public static final String COL_SINAVLAR_sinavNotu = "sinavNotu";
    public static final String COL_SINAVLAR_sinavYuzdesi = "sinavYuzdesi";
    //endregion
}

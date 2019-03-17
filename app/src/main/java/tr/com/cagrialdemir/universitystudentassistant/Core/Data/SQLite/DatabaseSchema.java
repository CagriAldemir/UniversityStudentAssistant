package tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite;

public class DatabaseSchema {

    static final String CREATE_DONEMLER = "";
    static final String CREATE_DERSLER = "";
    static final String CREATE_DEVAMSIZLIKLAR = "";
    static final String CREATE_HATIRLATMALAR = "";
    static final String CREATE_ODEVLER = "";
    static final String CREATE_SINAVLAR = "";

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

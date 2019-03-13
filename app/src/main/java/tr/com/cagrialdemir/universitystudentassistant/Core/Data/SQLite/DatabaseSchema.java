package tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite;

public class DatabaseSchema {

    public static final String CREATE_DONEMLER = "CREATE TABLE `Donemler` ( `donemID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `donemAdi` INTEGER NOT NULL )";
    public static final String CREATE_DERSLER = "CREATE TABLE `Dersler` ( `dersID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `donemID` INTEGER NOT NULL, `dersAdi` TEXT NOT NULL, `dersKodu` TEXT, `dersKredisi` INTEGER NOT NULL, `dersHarfNotu` INTEGER, `dersDevamsizlikSiniri` INTEGER, `dersYeri` TEXT, `dersGunuSaati` NUMERIC, FOREIGN KEY(`donemID`) REFERENCES `Donemler`(`donemID`) )";
    public static final String CREATE_DEVAMSIZLIKLAR = "CREATE TABLE `Devamsizliklar` ( `devamsizlikID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `dersID` INTEGER NOT NULL, `devamsizlikTarihi` NUMERIC NOT NULL, `devamsizlikSaatSayisi` INTEGER NOT NULL, FOREIGN KEY(`dersID`) REFERENCES `Dersler`(`dersID`) )";
    public static final String CREATE_HATIRLATMALAR = "CREATE TABLE `Hatirlatmalar` ( `hatirlatmaID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `hatirlatmaBasligi` TEXT NOT NULL, `hatirlatmaAciklamasi` TEXT, `hatirlatmaTarihi` NUMERIC NOT NULL, `hatirlatmaBildirimDurumu` INTEGER, `hatirlatmaBildirimNeKadarOnceGonderilecek` INTEGER )";
    public static final String CREATE_ODEVLER = "CREATE TABLE \"Odevler\" ( `odevID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `dersID` INTEGER NOT NULL, `odevBasligi` TEXT NOT NULL, `odevAciklamasi` TEXT, `odevTarihi` NUMERIC, FOREIGN KEY(`dersID`) REFERENCES `Dersler`(`dersID`) )";
    public static final String CREATE_SINAVLAR = "CREATE TABLE \"Sinavlar\" ( `sinavID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `dersID` INTEGER NOT NULL, `sinavYeri` TEXT NOT NULL, `sinavTarihi` NUMERIC NOT NULL, `sinavTipi` INTEGER NOT NULL, `sinavNotu` INTEGER, `sinavYuzdesi` INTEGER NOT NULL, FOREIGN KEY(`dersID`) REFERENCES `Dersler`(`dersID`) )";

}

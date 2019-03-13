package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import java.util.Date;

public class Hatirlatma {

    private String hatirlatmaAciklamasi;
    private String hatirlatmaBasligi;
    private boolean hatirlatmaBildirimDurumu;
    private int hatirlatmaBildirimNeKadarOnceGonderilecek;
    private int hatirlatmaID;
    private Date hatirlatmaTarihi;


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
}
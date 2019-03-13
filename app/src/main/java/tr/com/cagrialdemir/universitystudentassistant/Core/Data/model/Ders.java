package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import java.util.Date;

public class Ders {

    private String dersAdi;
    private int dersDevamsizlikSiniri;
    private Date dersGunuSaati;
    private int dersHarfNotu;
    private int dersID;
    private String dersKodu;
    private int dersKredisi;
    private String dersYeri;
    private int donemID;

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersDevamsizlikSiniri() {
        return dersDevamsizlikSiniri;
    }

    public void setDersDevamsizlikSiniri(int dersDevamsizlikSiniri) {
        this.dersDevamsizlikSiniri = dersDevamsizlikSiniri;
    }

    public Date getDersGunuSaati() {
        return dersGunuSaati;
    }

    public void setDersGunuSaati(Date dersGunuSaati) {
        this.dersGunuSaati = dersGunuSaati;
    }

    public int getDersHarfNotu() {
        return dersHarfNotu;
    }

    public void setDersHarfNotu(int dersHarfNotu) {
        this.dersHarfNotu = dersHarfNotu;
    }

    public int getDersID() {
        return dersID;
    }

    public void setDersID(int dersID) {
        this.dersID = dersID;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public int getDersKredisi() {
        return dersKredisi;
    }

    public void setDersKredisi(int dersKredisi) {
        this.dersKredisi = dersKredisi;
    }

    public String getDersYeri() {
        return dersYeri;
    }

    public void setDersYeri(String dersYeri) {
        this.dersYeri = dersYeri;
    }

    public int getDonemID() {
        return donemID;
    }

    public void setDonemID(int donemID) {
        this.donemID = donemID;
    }
}
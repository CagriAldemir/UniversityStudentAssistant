package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import java.util.Date;

public class Sinav {

    private int dersID;
    private int sinavID;
    private int sinavNotu;
    private Date sinavTarihi;
    private int sinavTipi;
    private String sinavYeri;
    private int sinavYuzdesi;

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
}
package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import java.util.Date;

public class Odev {

    private int dersID;
    private String odevAciklamasi;
    private String odevBasligi;
    private int odevID;
    private Date odevTarihi;

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
}
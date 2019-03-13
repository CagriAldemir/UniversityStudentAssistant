package tr.com.cagrialdemir.universitystudentassistant.Core.Data.model;


import java.util.Date;

public class Devamsizlik {

    private int dersID;
    private int devamsizlikID;
    private int devamsizlikSaatSayisi;
    private Date devamsizlikTarihi;

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
}
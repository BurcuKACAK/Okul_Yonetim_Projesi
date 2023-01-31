package okul_yonetim_platformu;

public class Ogretmen extends Ortak_Bilgiler{

    private String bolum;
    private int sicilNo;



    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(int sicilNo) {
        this.sicilNo = sicilNo;
    }

    @Override
    public String toString() {
        return super.getAdSoyad()+" "+getKimlikNo()+" "+getYas()+" "+getBolum()+" "+getSicilNo();
    }

    public Ogretmen(String adSoyad, int kimlikNo, int yas, String bolum, int sicilNo) {
        super(adSoyad, kimlikNo, yas);
        this.bolum = bolum;
        this.sicilNo = sicilNo;
    }
}





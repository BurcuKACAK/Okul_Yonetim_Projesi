package okul_yonetim_platformu;
//Ogrenci ve Ogretmen icin Ortak Bilgiler
public class Ortak_Bilgiler {

    private String adSoyad;
    private int kimlikNo;
    private int yas;

    public Ortak_Bilgiler(String adSoyad, int kimlikNo, int yas) {
        this.adSoyad = adSoyad;
        this.kimlikNo = kimlikNo;
        this.yas = yas;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(int kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }


}

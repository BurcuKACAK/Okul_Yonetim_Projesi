package okul_yonetim_platformu;

public class Ogrenci extends Ortak_Bilgiler{

    private int numara;
    private String sinifBilgileri;

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getSinifBilgileri() {
        return sinifBilgileri;
    }

    public void setSinifBilgileri(String sinifBilgileri) {
        this.sinifBilgileri = sinifBilgileri;
    }

    @Override
    public String toString() {
        return super.getAdSoyad()+" "+getKimlikNo()+" "+getYas()+" "+getNumara()+" "+getSinifBilgileri();
    }
    public Ogrenci(String adSoyad, int kimlikNo, int yas, int numara, String sinifBilgileri) {
        super(adSoyad, kimlikNo, yas);
        this.numara = numara;
        this.sinifBilgileri = sinifBilgileri;
    }


    }


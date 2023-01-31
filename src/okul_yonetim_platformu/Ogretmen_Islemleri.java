package okul_yonetim_platformu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ogretmen_Islemleri implements Islemler{//Islemler interface'den implement edip implement methodlari override ettik
    Scanner input =new Scanner(System.in);
    List<Ogretmen> ogretmenList =new ArrayList<>();

    public Ogretmen_Islemleri() throws IOException {


        Ogretmen ogretmen1 =new Ogretmen("Ali Can",1234567891,32,"Tarih",123);
        Ogretmen ogretmen2 =new Ogretmen("Veli Han",1296567891,35,"Matematik",345);
        Ogretmen ogretmen3 =new Ogretmen("Ayse Gul",1985267891,30,"Turkce",223);

        this.ogretmenList.add(ogretmen1);
        this.ogretmenList.add(ogretmen2);
        this.ogretmenList.add(ogretmen3);



        FileWriter fileWriter = new FileWriter("src\\Deneme\\Okul_Yonetim_Platformu\\Ogretmen_Listesi");
        fileWriter.write(ogretmenList.toString());
        fileWriter.close();

    }

    @Override
    public void processMenu() {

        int choise = -1;

        while (choise!=0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("1- Ogretmen Ekle");
            System.out.println("2- Ogretmen Ara");
            System.out.println("3- Ogretmenleri Listele");
            System.out.println("4- Ogretmen Sil");
            System.out.println("0- Geri Don");
            System.out.println("Seciminiz");
            choise = input.nextInt();
            switch (choise){
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    remove();
                    break;
                case 0:
                    System.out.println("Ana menuye yonlendiriliyorsunuz");
                    break;
                default:
                    System.out.println("Hatali Giris!!!");
            }
        }

    }
    @Override
    public void add() {
        Scanner input =new Scanner(System.in);
        System.out.println("Adi Soyadi  ");
        String adSoyad =input.nextLine().replaceAll("[\\p{Punct}]", "").replaceAll("[0-9]","").trim();
        System.out.println("Kimlik No  ");
        int kimlikNo = input.nextInt();
        System.out.println("Yas  ");
        int yas = input.nextInt();
        System.out.println("Bolum  ");
        String bolum = input.next();
        System.out.println("Sicil No ");
        int sicil = input.nextInt();

        Ogretmen yeniOgretmen = new Ogretmen(adSoyad,kimlikNo,yas,bolum,sicil);
        this.ogretmenList.add(yeniOgretmen);
    }
//Ogretmen Kimlik Bilgisi Al ve Onunla Listeden Kaldir ve Arama Yap
    @Override
    public void search() {
        boolean isExist = true;
        System.out.println("Aramak Istediginiz Ogretmenin Kimlik Numarasi :");
        int kimlikNo= input.nextInt();
        for (Ogretmen ogretmen : this.ogretmenList){
            if (ogretmen.getKimlikNo()==kimlikNo){
                isExist=true;
                System.out.println("Aramis Oldugunuz \n"+kimlikNo+" kimlik no ile \n"+ogretmen+"\nBilgisi Bulunmustur");
                break;
            }else {
                isExist=false;
            }

        }if (!isExist){
            System.out.println("Bu Kimlik Numarasi ile Ogretmen Bulunamadi");
        }

    }

    @Override
    public void list() {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-15s | %-10s | %-5s | %-10s | %-7s  \n", "Ad Soyad","Kimlik No", "Yas", "Bolum", "Sicil");
        for (Ogretmen ogretmen : this.ogretmenList){
            System.out.printf("%-15s | %-10s | %-5s | %-10s | %-7s  \n",ogretmen.getAdSoyad(),ogretmen.getKimlikNo(),
                    ogretmen.getYas(),ogretmen.getBolum(),ogretmen.getSicilNo());
        }
        System.out.println("---------------------------------------------------------------");

    }

    @Override
    public void remove() {
        boolean isExist = true;
        System.out.println("Silmek Istediginiz Ogretmenin Kimlik Numarasi :");
        int kimlikNo= input.nextInt();
        for (Ogretmen ogretmen : this.ogretmenList){
            if (ogretmen.getKimlikNo()==kimlikNo){
                isExist=true;
                this.ogretmenList.remove(ogretmen);
                System.out.println("Ogretmen Listeden Silindi");
                break;
            }else {
                isExist=false;
            }

        }if (!isExist){
            System.out.println("Bu Kimlik Numarasi ile Ogretmen Bulunamadi");
        }

    }


}

package okul_yonetim_platformu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ogrenci_Islemleri implements Islemler{
    Scanner input =new Scanner(System.in);
    List<Ogrenci> ogrenciList  =new ArrayList<>();

    public Ogrenci_Islemleri() throws IOException {
        Ogrenci ogrenci1 = new Ogrenci("Ayse Yildiz", 1234567891, 12, 896, "1/A");
        Ogrenci ogrenci2 = new Ogrenci("Mehmet Guclu", 1238365291, 11, 131, "2/B");
        Ogrenci ogrenci3 = new Ogrenci("Fatma Demir", 1820442224, 10, 142, "3/C");

        this.ogrenciList.add(ogrenci1);
        this.ogrenciList.add(ogrenci2);
        this.ogrenciList.add(ogrenci3);

        FileWriter fileWriter = new FileWriter("src\\Deneme\\Okul_Yonetim_Platformu\\Ogrenci_Listesi");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        fileWriter.write(ogrenciList.toString());
        fileWriter.close();

    }


    @Override
    public void processMenu() {

        int choise = -1;

        while (choise!=0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("1- Ogrenci Ekle");
            System.out.println("2- Ogrenci Ara");
            System.out.println("3- Ogrencileri Listele");
            System.out.println("4- Ogrenci Sil");
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
        String adSoyad =input.nextLine();

        System.out.println("Kimlik No  ");
        int kimlikNo = input.nextInt();
        System.out.println("Yas  ");
        int yas = input.nextInt();
        System.out.println("Ogrenci No  ");
        int numara = input.nextInt();
        System.out.println("Sinif ");
        input.nextLine();
        String sinif = input.nextLine();

        Ogrenci yeniOgrenci = new Ogrenci(adSoyad,kimlikNo,yas,numara,sinif);
        this.ogrenciList.add(yeniOgrenci);
    }

    @Override
    public void search() {boolean isExist = true;
        System.out.println("Aramak Istediginiz Ogretmenin Kimlik Numarasi :");
        int kimlikNo= input.nextInt();
        for (Ogrenci ogrenci : this.ogrenciList){
            if (ogrenci.getKimlikNo()==kimlikNo){
                isExist=true;
                System.out.println("Aramis Oldugunuz \n"+kimlikNo+" kimlik no ile \n"+ogrenci+"\nBilgisi Bulunmustur");
                break;
            }else {
                isExist=false;
            }

        }if (!isExist){
            System.out.println("Bu Kimlik Numarasi ile Ogrenci Bulunamadi");
        }


    }

    @Override
    public void list() {

            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-15s | %-10s | %-5s | %-7s | %-7s  \n", "Ad Soyad","Kimlik No", "Yas", "Bolum", "Sinif Bilgisi");
            for (Ogrenci ogrenci: this.ogrenciList){
                System.out.printf("%-15s | %-10s | %-5s | %-7s | %-7s  \n",ogrenci.getAdSoyad(),ogrenci.getKimlikNo(),
                        ogrenci.getYas(),ogrenci.getNumara(),ogrenci.getSinifBilgileri());
            }
            System.out.println("---------------------------------------------------------------");

    }

    @Override
    public void remove() {
        boolean isExist = true;
        System.out.println("Silmek Istediginiz Ogrencinin Kimlik Numarasi :");
        int kimlikNo= input.nextInt();
        for (Ogrenci ogrenci : this.ogrenciList){
            if (ogrenci.getKimlikNo()==kimlikNo){
                isExist=true;
                this.ogrenciList.remove(ogrenci);
                System.out.println("Ogrenci Listeden Silindi");
                break;
            }else {
                isExist=false;
            }

        }if (!isExist){
            System.out.println("Bu Kimlik Numarasi ile Ogrenci Bulunamadi");
        }


    }


}

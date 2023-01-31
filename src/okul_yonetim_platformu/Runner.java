package okul_yonetim_platformu;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {


        enter();

    }

    public static void enter() throws IOException {

        Scanner input =new Scanner(System.in);
        System.out.println( "~~~~~~ OGRENCI VE OGRETMEN YONETIM PANELI ~~~~~~");
        int select =-1;
        while (select!=0){
            System.out.println("Ogrenci ve Ogretmen Yonetim Paneline Hosgeldiniz");
            System.out.println("Lutfen Girmek Istediginiz Paneli Seciniz:");
            System.out.println("Ogrenciler Icin  ----> 1");
            System.out.println("Ogretmenler Icin ----> 2");
            System.out.println("Cikis ----> 0");
            System.out.println("Seciminiz : ");
            select = input.nextInt();

            Islemler service = select==1 ? new Ogrenci_Islemleri() : new Ogretmen_Islemleri();

            //select==1 ==>ProductService service1 = new BookService();
            //select==2 ==>ProductService service2 = new NotebookService();

            if (select==1 || select==2){
                service.processMenu();
            }else if (select==0){
                System.out.println("Iyi gunler...");
            }else {
                System.out.println("Hatali Giris");
            }





    }
    }
}

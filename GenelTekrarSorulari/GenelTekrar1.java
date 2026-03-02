package GenelTekrarSorulari;

import java.util.Scanner;

public class GenelTekrar1 {
    public static void main(String[] args) {
        //1 den 100 e kadar olan sayıların toplamını hesaplayan bir uygulama yapın.
        int toplam = 0;
        for (int i = 1; i <= 100; i++) {
            toplam = toplam + i;
        }
        System.out.println("1 den 100 e kadar olan sayıların toplamı : " + toplam);




        //klavyeden girilen bir sayının faktöriyelini bulan uygulama yapın.
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen faktöriyelini hesaplamak istediğiniz sayıyı giriniz :");
        int girilenSayi = input.nextInt();
        int faktoriyel = 1;
        for (int i = girilenSayi; i >= 1; i--) {
            if (girilenSayi == 0 || girilenSayi == 1) {
                System.out.println("Girilen Sayinin Faktöriyeli = 1");

            } else
                faktoriyel = faktoriyel * i;
        }
        System.out.println("Girilen Sayının Faktöriyeli = " + faktoriyel);




        //100 lük sistemde verilen notları harfli sistemde gösteren uygulamayı yazın.
        Scanner input1 = new Scanner(System.in);
        System.out.println("Lütfen Notunuzu Giriniz : ");
        int girilenNot = input1.nextInt();
        if (girilenNot >= 80 && girilenNot <= 100) {
            System.out.println("Harf Notunuz : AA");
        }  else if (girilenNot >= 60 && girilenNot <= 79) {
            System.out.println("Harf Notunuz : BB");
        } else if (girilenNot>50&&girilenNot<=59) {
            System.out.println("Harf Notunuz : CC");
        }else if (girilenNot<50){
            System.out.println("Harf Notunuz : DD");
        }else {
            System.out.println("Geçersiz değer girdiniz");
        }




        //Çarpım Tablosunu oluşturan bir uygulama yazınız 10*X
        Scanner scanner=new Scanner(System.in);
        System.out.println("Lütfen Çarpım Tablosunu İstediğiniz Sayıyı giriniz :");
        int carpim=scanner.nextInt();
        for (int i=0;i<1;i++){
            for (int a=1;a<=carpim;a++){
                System.out.println(a+" * "+carpim+" = "+carpim*a);
            }
        }



    }
}

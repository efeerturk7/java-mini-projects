package GenelTekrarSorulari;

import java.util.Scanner;

public class SicakSogukOyunu {
    public static void main(String[] args) {
        /*Sıcak Soğuk oyunu yapın.Sistem 100 e kadar rastgele bir sayı üretsin.Kullanıcı bu sayıyı
        //tahmin etmeye çalışsın.Kullanıcıdan girdiği değere göre kullanıcıyı arttır veya azalt diye
        //uyaralım.Kullanıcı sayıyı bulana kadar tahmin istemeye devam edelim ve sayıyı bulduğunda
        kaç denemeden sonra bulduğunu belirtelim*
         */
        int rastgeleSayi=(int)(Math.random()*99)+1;
        boolean dogruMu=true;
        while (dogruMu){
            Scanner input3=new Scanner(System.in);
            System.out.println("Lütfen tahmininizi girin (1-100) :");
            int tahminEdilenSayi=input3.nextInt();
            if (tahminEdilenSayi>rastgeleSayi){
                System.out.println("Lütfen Değeri Azaltıp Tekrar Deneyiniz");
            } else if (tahminEdilenSayi<rastgeleSayi) {
                System.out.println("Lütfen Değeri Arttırıp Tekrar Deneyiniz");
            }else if (tahminEdilenSayi==rastgeleSayi){
                System.out.println("Bulundu");
                dogruMu=false;
            }else {
                System.out.println("Geçersiz Karakter Girdiniz");
            }

        }


    }
}

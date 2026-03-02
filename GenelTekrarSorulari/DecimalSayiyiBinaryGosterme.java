package GenelTekrarSorulari;

import java.util.Scanner;

public class DecimalSayiyiBinaryGosterme {
    //Soru 2 : Decimal Sayıları  Binary formatına çeviren java programını yazınız
    public static void main(String[] args) {
        binary();


    }

    public static void binary() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen binary e dönüştürülecek olan decimal sayıyı giriniz :");
        int decimal = input.nextInt();
        int bolen = 2;
        boolean dogruMu=true;
        while (dogruMu) {
            int bolum;
            int kalan;
            int i=0;
            bolum = decimal / bolen;
            kalan = decimal % bolen;
            if (bolum==0){
                System.out.println(kalan);
                dogruMu=false;
            }else {
                System.out.print(kalan);
                decimal = bolum;

            }
        }

    }
}

package GenelTekrarSorulari;

import java.util.Scanner;

public class AsalSayiBulma {
    public static void main(String[] args) {
        //Kullanıcıdan aldığınız integer değerine kadar olan tüm asal sayıları yazdıran program.
        asalSayi();

    }
    public static void asalSayi(){
        Scanner input =new Scanner(System.in);
        System.out.println("Lütfen değeri giriniz : ");
        int girilenDeger=input.nextInt();
        int asallar=0;
        for (int bolme=1;bolme<girilenDeger;bolme++){
            if (girilenDeger/bolme==0 ){

            }


        }
    }
}

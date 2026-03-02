package GenelTekrarSorulari;

import java.util.Scanner;

public class IkiSayininEbobu {
    public static void main(String[] args) {
        //kullanıcıdan alınan iki değerin ebobunu bulan program yazın.
        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen ilk değeri giriniz :");
        int sayi=input.nextInt();
        System.out.println("Lütfen ikinci değeri giriniz :");
        int sayi2=input.nextInt();
        int ebob=1;
        int bolen=2;
        while (bolen<sayi||bolen<sayi2){
            if (sayi2%bolen==0&&sayi%bolen==0){
                ebob=bolen;
                bolen++;
            }else {
                bolen++;
            }
        }
        System.out.println(ebob);

    }


}




package GenelTekrarSorulari;

import java.util.Scanner;

public class PolindromBulma {
    //girilen bir metnin polindrom olup olmadığını bulan bir program yazınız "Kaçak" gibi
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Lütfen Polindrom Olup olmadığını anlamak için kelimeyi girin :");
        String giris=input.nextLine();
        int stringUz=giris.length()-1;
        boolean polindromMu=true;
        int sayma=0;
        while (polindromMu){
            char karakter=giris.charAt(sayma);
            char karakter1=giris.charAt(stringUz-sayma);
            if (karakter==karakter1){
                sayma++;
                if (sayma==stringUz){
                    System.out.println("Polindromdur");
                    polindromMu=false;
                }
            }else {
                System.out.println("Polindrom değildir");
                polindromMu=false;
            }
        }
    }
}

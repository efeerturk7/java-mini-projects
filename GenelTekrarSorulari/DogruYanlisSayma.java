package GenelTekrarSorulari;

import java.util.Arrays;
import java.util.Scanner;

//Kullanıcının girdiği öğrenci sayısı ve kullanıcının girdiği toplam soru sayısına bağlı olarak
//öğrencilerin soruya verdiği cevapları tutan bir matris düzenleyin.Bu değerleri rastgele olarak
//oluşturun.Değerler A,B,C,D,E olmalı.Bir de doğru cevapları tutan tek boyutlu bir dizi olsun.
//Bu da rastgele oluşturulmalı.Sonrasında bu değerleri karşılaştırarak her bir öğrencinin kaç doğru
// ve yanlışı olduğunu gösteren program yazınız.
public class DogruYanlisSayma {
    public static void main(String[] args) {
        dogruYanlis();
    }

    public static void dogruYanlis() {
        char cevaplar[] = {'A', 'B', 'C', 'D', 'E'};
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen Öğrenci Sayısını Giriniz : ");
        int ogrenciSayisi = input.nextInt();
        System.out.println("Lütfen Toplam Soru Sayısını Giriniz :");
        int toplamSoru = input.nextInt();
        char dogruCevaplar[] = new char[toplamSoru];
        for (int i = 0; i < dogruCevaplar.length; i++) {
            int random = (int) (Math.random() * 5);
            dogruCevaplar[i] = cevaplar[random];
        }
        char matris[][] = new char[ogrenciSayisi][toplamSoru];
        for (int satir = 0; satir < ogrenciSayisi; satir++) {
            int dogruSayisi = 0;
            int yanlisSayisi = 0;
            for (int sutun = 0; sutun < toplamSoru; sutun++) {
                int random = (int) (Math.random() * 5);
                matris[satir][sutun] = cevaplar[random];
                if (matris[satir][sutun] == dogruCevaplar[sutun]) {
                    dogruSayisi++;
                } else {
                    yanlisSayisi++;
                }
            }
            System.out.println(satir+1+". öğrenicinin doğru sayısı :"+dogruSayisi+" ve yanlış sayısı :"+yanlisSayisi);
        }

    }

}

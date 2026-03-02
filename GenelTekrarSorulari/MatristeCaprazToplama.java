package GenelTekrarSorulari;

public class MatristeCaprazToplama {
    //Soru 1: 5*5 Matris oluşturun ve bu matrisin elemanları 0-9 arasında rastgele doldurulsun
    //Bu matrisi ekrana yazdıran ve çapraz elemanların toplamını gösteren bir program yazınız
    public static void main(String[] args) {
        matris();

    }

    public static void matris() {
        int toplam1 = 0;
        int toplam = 0;
        int matris[][] = new int[5][5];
        int rakamlar[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int satir = 0; satir < matris.length; satir++) {
            for (int sutun = 0; sutun < matris[satir].length; sutun++) {
                int random = (int) (Math.random() * 10);
                matris[satir][sutun] = random;
                System.out.print(matris[satir][sutun] + "\t");
            }
            System.out.println();
        }
        for (int satir = 0, sutun = matris.length - 1; satir < matris.length && sutun >= 0; satir++, sutun--) {
            toplam1 = toplam1 + matris[satir][sutun];
        }

        for (int satir = 0, sutun = 0; satir < matris.length && sutun < matris.length; satir++, sutun++) {
            toplam = toplam + matris[satir][sutun];
        }
        int orta = (matris.length - 1) / 2;
        System.out.println("Matristeki çapraz olan elemanların toplamı :" + ((toplam + toplam1) - (matris[orta][orta])));
    }
}


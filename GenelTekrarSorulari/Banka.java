package GenelTekrarSorulari;

//Bir banka hesabı için sınıf tasarlayın.Bu sınıfta hesabın kime ait olduğunu
//tutan hesapNo,hesaptakiPara,para yatirma ve para çekme işlemleri olsun.Ayrıca hesaptaki
//tüm parayı,açılan hesap sayısını,yapılan toplam para çekme ve yatırma sayısını gösteren bir ifade olmalı
//ve iki hesabı para değişkenine göre bibiriyle kıyaslayacak metot bulunmalı
public class Banka {
    private static int paraCekmeSayisi = 0;
    private static int paraYatirmaSayisi = 0;
    private int hesapNo;
    private double hesaptakiPara;
    private String isim;

    public Banka(String isim, int hesapNo, double hesaptakiPara) {
        this.hesaptakiPara = hesaptakiPara;
        this.hesapNo = hesapNo;
        this.isim = isim;
    }

    public Banka() {

    }

    public static int getParaCekmeSayisi() {
        return paraCekmeSayisi;
    }

    public static int getParaYatirmaSayisi() {
        return paraYatirmaSayisi;
    }

    public int getHesapNo() {
        return hesapNo;
    }

    public double getHesaptakiPara() {
        return hesaptakiPara;
    }

    public String getIsim() {
        return isim;
    }

    public void paraCekme(double cekilecekTutar) {
        paraCekmeSayisi++;
        if (hesaptakiPara < cekilecekTutar) {
            System.out.println("Yetersiz bakiye!!");
        }
        hesaptakiPara = hesaptakiPara - cekilecekTutar;
        System.out.println("Para çekme işlemi başarılı!!");
        System.out.println("Hesaptaki bakiye :" + hesaptakiPara + " TL");
    }

    public void paraYatirma(double yatirilacakTutar) {
        if (yatirilacakTutar < 0) {
            System.out.println("Yanlış bir değer girdiniz!!");
        }
        paraYatirmaSayisi++;
        hesaptakiPara = hesaptakiPara + yatirilacakTutar;
        System.out.println("Para yatırma işlemi başarılı!!");
        System.out.println("Hesaptaki bakiye :" + hesaptakiPara + " TL");
    }

    public void tumIslemler() {
        System.out.println("Toplam para yatırma işlemi :" + paraYatirmaSayisi);
        System.out.println("Toplam para çekme işlemi :" + paraCekmeSayisi);
    }

    public void kiyaslama(Banka kiyaslanacakHesap) {
        //burada yaptığımız ifade Banka sınıfında kiyaslanacakHesap adında bir nesne oluşturduk bu nesne test sınıfında iki hesabı karşılaştırmak
        //için kullanılacak
        if (hesaptakiPara < kiyaslanacakHesap.getHesaptakiPara()) {
            System.out.println("2. hesapta daha fazla para vardır");
        } else if (hesaptakiPara == kiyaslanacakHesap.getHesaptakiPara()) {
            System.out.println("iki hesapta da aynı miktar para vardır");
        } else {
            System.out.println("Birinci hesapta daha fazla para vardır");
        }
    }
}

class BankTest {
    public static void main(String[] args) {
        Banka hesap1 = new Banka("Bahadır", 548793, 6400.05);
        Banka hesap2 = new Banka("Mücahit", 348032, 1206.09);
        Banka hesaplar = new Banka();
        hesap2.paraCekme(450);
        hesap1.paraYatirma(358.45);
        hesaplar.tumIslemler();
        hesap1.kiyaslama(hesap2);

    }
}

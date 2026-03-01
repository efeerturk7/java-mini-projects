package myProjects;

import java.util.ArrayList;
import java.util.Scanner;

//Bu projede bir Banka Hesap Yönetim Sistemi geliştirilecek. Tüm müşteriler ArrayList yapısında tutulacak ve
// her müşteri için hesap numarası (ID), isim, bakiye ve hesap türü (bireysel, kurumsal) bilgileri saklanacak.
// Kullanıcı sisteme yeni müşteri ekleyebilecek, müşteri silebilecek, bakiye güncelleyebilecek (para yatırma / çekme),
// tüm müşterileri listeleyebilecek ve isim veya hesap numarasına göre müşteri araması yapabilecek.
// Sistemde Bireysel Hesap ve Kurumsal Hesap gibi sınıflar olacak ve bu sınıflar arasında kalıtım (inheritance) ilişkisi olacak.
// Müşteri bilgileri ekrana yazdırılırken Polymorphism prensibi kullanılarak her hesap türü kendine özgü şekilde görüntülenecek,
// bu amaçla toString() metodu override edilecek. Tüm sınıflar Encapsulation prensibine uygun şekilde getter ve setter metodlarıyla tasarlanacak ve işlemler için döngüler
// , koşullar, ArrayList  yapısı kullanılacak.
public class BankaYonetimSistemi {
    public static void main(String[] args) {
        ArrayList<Banka> bankas = new ArrayList<>();
        Banka hesap1 = new BireyselHesap(1241453, "Ali", 23576.09, "Bireysel");
        Banka hesap2 = new BireyselHesap(1989783, "Mehmet", 26.05, "Bireysel");
        Banka hesap3 = new KurumsalHesap(1783, "Apple", 32459346231498.35, "Kurumsal");
        Banka.musteriEkleme(bankas, hesap1);
        Banka.musteriEkleme(bankas, hesap2);
        Banka.musteriEkleme(bankas, hesap3);
        Banka.listele(bankas);
        Banka.paraYatirma(hesap2);
        System.out.println("********************* Hesap2 ye para yatırıldıktan sonra ***********************");
        Banka.listele(bankas);


    }
}

class Banka {
    private int musteriHesapNumarasi;
    private String isim;
    private double bakiye;
    private String hesapTuru;

    public static void listele(ArrayList<Banka> hesaplar) {
        for (int i = 0; i < hesaplar.size(); i++) {
            System.out.println(hesaplar.get(i));
        }
    }

    public static void musteriSilme(ArrayList<Banka> hesaplar, Banka silinecekMusteri) {
        hesaplar.remove(silinecekMusteri);

    }

    public static void musteriEkleme(ArrayList<Banka> hesaplar, Banka eklenecekMusteri) {
        hesaplar.add(eklenecekMusteri);
    }


    public static void paraYatirma(Banka paraYatirilacakHesap) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen yatırılacak para değerini giriniz : ");
        double tutar = input.nextDouble();
        if (tutar < 0) {
            System.out.println("Lütfen geçerli bir değer giriniz");
        }
        paraYatirilacakHesap.bakiye = paraYatirilacakHesap.getBakiye() + tutar;
        System.out.println(tutar + " TL hesaba başarıyla yatırılmıştır");
    }

    public static void paraCekme(Banka paraCekilecekHesap) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen çekmek istediğiniz para tutarını giriniz : ");
        double tutar = input.nextDouble();
        if (tutar < 0 || paraCekilecekHesap.bakiye < tutar) {
            System.out.println("Lütfen geçerli bir para miktarı giriniz");
        } else {
            paraCekilecekHesap.bakiye = -tutar;
            System.out.println(tutar + " TL hesaptan başarıyla çekilmiştir");
        }

    }

    public static void arama(ArrayList<Banka> hesaplar, int aranacakHesapNumarasi, String aranacakIsim) {
        boolean bulunduMu = false;
        for (Banka o : hesaplar) {
            if (o.getMusteriHesapNumarasi() == aranacakHesapNumarasi || o.getIsim().equalsIgnoreCase(aranacakIsim)) {
                System.out.println("Arama sonucu : " + o);
                bulunduMu = true;
            } else {
                System.out.println("Hesap bulunamadı");
            }
        }
    }

    public Banka(int musteriHesapNumarasi, String isim, double bakiye, String hesapTuru) {
        this.musteriHesapNumarasi = musteriHesapNumarasi;
        this.isim = isim;
        this.bakiye = bakiye;
        this.hesapTuru = hesapTuru;
    }

    public int getMusteriHesapNumarasi() {
        return musteriHesapNumarasi;
    }

    public void setMusteriHesapNumarasi(int musteriHesapNumarasi) {
        this.musteriHesapNumarasi = musteriHesapNumarasi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

}

class Hesap extends Banka {

    public Hesap(int musteriHesapNumarasi, String isim, double bakiye, String hesapTuru) {
        super(musteriHesapNumarasi, isim, bakiye, hesapTuru);
    }
}

class BireyselHesap extends Hesap {
    public BireyselHesap(int musteriHesapNumarasi, String isim, double bakiye, String hesapTuru) {
        super(musteriHesapNumarasi, isim, bakiye, hesapTuru);
    }

    @Override
    public String toString() {
        return "Hesap Numarası : " + getMusteriHesapNumarasi() + " / İsmi : " + getIsim() + " / Hesap Türü : " + getHesapTuru() + " / Bakiye :" + getBakiye();
    }
}

class KurumsalHesap extends Hesap {

    public KurumsalHesap(int musteriHesapNumarasi, String isim, double bakiye, String hesapTuru) {
        super(musteriHesapNumarasi, isim, bakiye, hesapTuru);
    }

    public String toString() {
        return "Hesap Numarası : " + getMusteriHesapNumarasi() + " / İsmi : " + getIsim() + " / Hesap Türü : " + getHesapTuru() + " / Bakiye :" + getBakiye();
    }
}

package myProjects;

import java.util.ArrayList;
import java.util.Collections;

public class MarketOtomasyonSistemi {
    public static void main(String[] args) {
        Urunler1 urunler1 = new NormalUrunler1(11264, "Sut", "İçecek", 49.90, 5);
        Urunler1 urunler2 = new NormalUrunler1(11265, "Ekmek", "Yiyecek", 12.90, 5);
        Urunler1 urunler3 = new NormalUrunler1(11266, "Cikolata", "Yiyecek", 24.90, 7);
        Urunler1 urunler4 = new NormalUrunler1(11267, "Yumurta", "Yiyecek", 39.90, 15);
        Urunler1 urunler5 = new NormalUrunler1(11268, "Su", "İçecek", 5.90, 56);
        Urunler1 urunler6 = new NormalUrunler1(11269, "Maydanoz", "Yiyecek", 4.90, 100);
        Urunler1 urunler7 = new NormalUrunler1(11270, "Bulgur", "Yiyecek", 30.90, 56);
        Urunler1 indirimliUrunler1 = new IndirimliUrunler1(757658, "ice tea", "İçecek", 35.50, 0.8, 34);
        Urunler1 indirimliUrunler2 = new IndirimliUrunler1(757659, "Salatalık Turşusu", "Yiyecek", 55.40, 0.9, 34);
        Urunler1 indirimliUrunler3 = new IndirimliUrunler1(757660, "Mısır", "Yiyecek", 30.99, 0.7, 29);
        Urunler1 indirimliUrunler4 = new IndirimliUrunler1(757661, "Peynir", "Yiyecek", 99.90, 0.6, 10);
        Urunler1 indirimliUrunler5 = new IndirimliUrunler1(757662, "Tabak Seti", "Eşya", 835.50, 0.5, 4);
        UrunYonetimi1 urunYonetimi1 = new UrunYonetimi1();
        System.out.println("Ürünler ekleniyor...");
        urunYonetimi1.urunEkleme(urunler1);
        urunYonetimi1.urunEkleme(urunler2);
        urunYonetimi1.urunEkleme(urunler3);
        urunYonetimi1.urunEkleme(urunler4);
        urunYonetimi1.urunEkleme(urunler5);
        urunYonetimi1.urunEkleme(urunler6);
        urunYonetimi1.urunEkleme(urunler7);
        urunYonetimi1.urunEkleme(indirimliUrunler1);
        urunYonetimi1.urunEkleme(indirimliUrunler2);
        urunYonetimi1.urunEkleme(indirimliUrunler3);
        urunYonetimi1.urunEkleme(indirimliUrunler4);
        urunYonetimi1.urunEkleme(indirimliUrunler5);


        System.out.println("Ürünler");
        urunYonetimi1.urunListeleme();
        Siparisler<Urunler1>sepet=new Siparisler<>();
        sepet.sepeteUrunEkleme(indirimliUrunler1);
        sepet.sepeteUrunEkleme(indirimliUrunler2);
        sepet.sepeteUrunEkleme(indirimliUrunler3);
        System.out.println(sepet.toplamSepettekiFiyat);


    }

}

abstract class Urunler1 {
    private int urunId;
    private String urunAdi;
    private String urunKategorisi;
    private double urunFiyati;
    private int urunStokAdeti;

    public Urunler1(int urunId, String urunAdi, String urunKategorisi, double urunFiyati, int urunStokAdeti) {
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.urunKategorisi = urunKategorisi;
        this.urunFiyati = urunFiyati;
        this.urunStokAdeti = urunStokAdeti;
    }

    public Urunler1() {

    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunKategorisi() {
        return urunKategorisi;
    }

    public void setUrunKategorisi(String urunKategorisi) {
        this.urunKategorisi = urunKategorisi;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(double urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public int getUrunStokAdeti() {
        return urunStokAdeti;
    }

    public void setUrunStokAdeti(int urunStokAdeti) {
        this.urunStokAdeti = urunStokAdeti;
    }
}

class IndirimliUrunler1 extends Urunler1 {
    private double indirimOrani;

    public IndirimliUrunler1(int urunId, String urunAdi, String urunKategorisi, double urunFiyati, double indirimOrani, int urunStokAdeti) {
        super(urunId, urunAdi, urunKategorisi, urunFiyati, urunStokAdeti);
        if (indirimOrani <= 0) {
            System.out.println("Yanlış bir indirim oranı girdiniz lütfen tekrar deneyin");
        } else {
            this.indirimOrani = indirimOrani;
        }

    }

    @Override
    public String toString() {
        return "Ürün ID : " + getUrunId() + " / Ürün : " + getUrunAdi() + " / Ürün Kategorisi : " + getUrunKategorisi() + " / Ürünün İndirimli Fiyatı : " + getUrunFiyati() * indirimOrani + " / İndirimli Ürün Stok Adeti : " + getUrunStokAdeti();
    }
}

class NormalUrunler1 extends Urunler1 {

    public NormalUrunler1(int urunId, String urunAdi, String urunKategorisi, double urunFiyati, int urunStokAdeti) {
        super(urunId, urunAdi, urunKategorisi, urunFiyati, urunStokAdeti);
    }

    @Override
    public String toString() {
        return "Ürün ID : " + getUrunId() + " / Ürün : " + getUrunAdi() + " / Ürün Kategorisi : " + getUrunKategorisi() + " / Ürünün Fiyatı : " + getUrunFiyati() + " / Ürün Stok Adeti : " + getUrunStokAdeti();
    }
}

interface UrunIslemleri1 {
    void urunEkleme(Urunler1 eklenecekUrun);

    void urunKaldirma(Urunler1 kaldirilacakUrun);

    void urunListeleme();

    void urunArama(String ad);

}

class UrunYonetimi1 extends Urunler1 implements Comparable<Urunler1>, UrunIslemleri1 {
   private ArrayList<Urunler1> urunler = new ArrayList<>();

    public ArrayList<Urunler1> getUrunler() {
        return urunler;
    }

    public UrunYonetimi1(int urunId, String urunAdi, String urunKategorisi, double urunFiyati, int urunStokAdeti) {
        super(urunId, urunAdi, urunKategorisi, urunFiyati, urunStokAdeti);
    }

    public UrunYonetimi1() {
        super();

    }

    @Override
    public int compareTo(Urunler1 o1) {
        if (getUrunAdi().compareTo(String.valueOf(o1)) < 0) {
            return -1;
        } else if (getUrunAdi().compareTo(String.valueOf(o1)) > 0) {
            return 1;
        } else
            return 0;
    }

    @Override
    public void urunEkleme(Urunler1 eklenecekUrun) {
        if (eklenecekUrun instanceof Urunler1 == false) {
            System.out.println("Geçersiz ürün eklemeye çalıştınız");
        } else {
            urunler.add(eklenecekUrun);
            System.out.println(eklenecekUrun.getUrunAdi() + " Başarıyla sisteme eklenmiştir");
            int eklenecekUrunStokAdeti = eklenecekUrun.getUrunStokAdeti() + 1;
            eklenecekUrun.setUrunStokAdeti(eklenecekUrunStokAdeti);
        }

    }

    @Override
    public void urunKaldirma(Urunler1 kaldirilacakUrun) {
        if (urunler.contains(kaldirilacakUrun) == false) {
            System.out.println(kaldirilacakUrun.getUrunAdi() + " Sistemde bulunamadığı için kaldırılamamıştır");
        } else {
            urunler.remove(kaldirilacakUrun);
            System.out.println(kaldirilacakUrun.getUrunAdi() + " Başarıyla sistemden kaldırılmıştır");
            int kaldirilacakUrunStokAdeti = kaldirilacakUrun.getUrunStokAdeti() - 1;
            kaldirilacakUrun.setUrunStokAdeti(kaldirilacakUrunStokAdeti);
        }

    }

    @Override
    public void urunListeleme() {
        for (Urunler1 urunler1 : urunler) {
            System.out.println(urunler1);
        }

    }

    @Override
    public void urunArama(String ad) {
        boolean bulunduMu = false;
        for (Urunler1 urunler1 : urunler) {
            if (urunler1.getUrunAdi().equalsIgnoreCase(ad) == true) {
                System.out.println("Arama sonucu : " + urunler1);
                bulunduMu = true;
            }
        }
        if (!bulunduMu) {
            System.out.println("Aradığınız ürün sistemde bulunmamaktadır");
        }
    }

}

class Siparisler<SiparisVeriTuru extends Urunler1>extends UrunYonetimi1 {
    ArrayList<SiparisVeriTuru> sepet = new ArrayList<>();
    double toplamSepettekiFiyat = 0;

    public  void sepeteUrunEkleme(SiparisVeriTuru  sepeteEklenecekUrun) {
        if (sepeteEklenecekUrun.getUrunStokAdeti() <= 0) {
            System.out.println("Maximum Sepete Ekleme Sınırıda Olduğunuz İçin Daha Fazla Ekleme Yapamazsınız");
        } else {
            if (getUrunler().contains(sepeteEklenecekUrun) == false) {
                System.out.println("Eklemeye Çalıştığınız Ürün sistemde bulunmamaktadır");
            } else {
                sepet.add(sepeteEklenecekUrun);
                System.out.println(sepeteEklenecekUrun.getUrunAdi() + " Başarıyla Sepete Eklenmiştir");
                sepeteEklenecekUrun.setUrunStokAdeti(sepeteEklenecekUrun.getUrunStokAdeti() - 1);
            }
        }

    }

    public <SiparisVeriTuru extends Urunler1> void sepettenUrunSilme(SiparisVeriTuru sepettenKaldirilacakUrun) {

        System.out.println("Maximum Sepete Ekleme Sınırıda Olduğunuz İçin Daha Fazla Ekleme Yapamazsınız");
        if (sepet.contains(sepettenKaldirilacakUrun) == false) {
            System.out.println("Kaldırmaya Çalıştığınız Ürün zaten sepette bulunmamaktadır");
        } else {
            sepet.remove(sepettenKaldirilacakUrun);
            System.out.println(sepettenKaldirilacakUrun.getUrunAdi() + " Başarıyla Sepetten Kaldırılmıştır");
            sepettenKaldirilacakUrun.setUrunStokAdeti(sepettenKaldirilacakUrun.getUrunStokAdeti() + 1);
        }
    }

    public void satinAlmaIslemi() {
        for (SiparisVeriTuru gecici : sepet) {
            toplamSepettekiFiyat = toplamSepettekiFiyat + gecici.getUrunFiyati();
            System.out.println(gecici.getUrunAdi() + " Başarıyla Satın Alınmıştır" + " Fiyatı : " + gecici.getUrunFiyati());
        }
        System.out.println("Sepetteki Toplam Tutar : " + toplamSepettekiFiyat);

    }

}

package myProjects;
//Bu projede bir Online Sipariş ve Sepet Sistemi geliştirilecek. Tüm ürünler ve müşterinin sepeti ArrayList yapısında tutulacak.
// Her ürün için ürün ID, ürün adı, fiyat, kategori (elektronik, giyim vb.) ve stok durumu bilgileri saklanacak.
// Kullanıcı sistemde yeni ürün ekleyebilecek, ürün silebilecek, ürünleri listeleyebilecek ve ürün araması (isim ya da ID) yapabilecek.
// Ayrıca kullanıcı ürünleri sepete ekleyip çıkarabilecek, sepeti görüntüleyebilecek ve sepet toplam fiyatını görebilecek.
// Ürünler Normal Ürün veya İndirimli Ürün olacak; bu sınıflar arasında kalıtım (inheritance) ilişkisi olacak ve
// Polymorphism kullanılarak her ürün kendine özgü şekilde yazdırılacak (örneğin indirimli ürün toString() override ile fiyatı indirimli gösterir).
// Tüm sınıflar Encapsulation prensibine uygun getter ve setter metotlarıyla tasarlanacak ve işlemler için döngüler, koşullar, ArrayList kullanılacak.

import java.util.ArrayList;

public class SepetSistemi {
    public static void main(String[] args) {
        ArrayList<OnlineSiparis> musterininSepeti = new ArrayList<>();
        ArrayList<OnlineSiparis> musterininSepeti1 = new ArrayList<>();
        OnlineSiparis urun = new IndirimliUrunler(true, 1241213, 450.7, "Aksesuar", "Telefon Kılıfı");
        OnlineSiparis urun1 = new IndirimliUrunler(true, 128757953, 1200.0, "Giyim", "gömlek");
        OnlineSiparis urun2 = new IndirimliUrunler(true, 1221342353, 750.0, "Giyim", "T-shirt");
        OnlineSiparis urun3 = new NormalUrunler(true, 1274343, 40000.0, "Elektronik", "İphone 14");
        OnlineSiparis urun4 = new NormalUrunler(true, 196433, 60000.0, "Elektronik", "İphone 16");
        OnlineSiparis urun5 = new NormalUrunler(true, 18855, 3000.0, "Elektronik", "Mouse");
        System.out.println("***************** 1. müşterinin sepeti *****************");
        OnlineSiparis.urunEkleme(musterininSepeti, urun);
        OnlineSiparis.urunEkleme(musterininSepeti, urun1);
        OnlineSiparis.sepetGoruntule(musterininSepeti);
        System.out.println("****************** 2. müşterinin sepeti ****************");
        OnlineSiparis.urunEkleme(musterininSepeti1, urun2);
        OnlineSiparis.urunEkleme(musterininSepeti1, urun5);
        OnlineSiparis.urunEkleme(musterininSepeti1, urun1);
        OnlineSiparis.sepetGoruntule(musterininSepeti1);


    }
}

class OnlineSiparis {
    private boolean stoktaMi = false;
    private int urunId;
    private double fiyat;
    private String kategori;
    private String urunAdi;

    public static void urunEkleme(ArrayList<OnlineSiparis> sepet, OnlineSiparis eklenecekUrun) {
        double eklenecekUrununFiyati = eklenecekUrun.getFiyat();
        if (eklenecekUrun instanceof IndirimliUrunler) {
            if (eklenecekUrun.stoktaMi == false) {
                System.out.println("Ürün stokta bulunmamaktadır");
            } else {
                sepet.add(eklenecekUrun);
                System.out.println(eklenecekUrun.urunAdi + " sepete başarıyla eklenmiştir ");
                eklenecekUrununFiyati = eklenecekUrununFiyati * ((IndirimliUrunler) eklenecekUrun).getYuzdeIndirim();
            }
        } else {
            if (eklenecekUrun.stoktaMi == false) {
                System.out.println("Ürün stokta bulunmamaktadır");
            } else {
                sepet.add(eklenecekUrun);
                System.out.println(eklenecekUrun.urunAdi + " sepete başarıyla eklenmiştir ");
            }
        }

    }

    public static void sepetGoruntule(ArrayList<OnlineSiparis> siparisler) {
        double toplamFiyat = 0;
        for (int i = 0; i < siparisler.size(); i++) {
            System.out.println(siparisler.get(i));
            if (siparisler.get(i) instanceof IndirimliUrunler) {
                toplamFiyat = toplamFiyat + ((IndirimliUrunler) siparisler.get(i)).getFiyat() * ((IndirimliUrunler) siparisler.get(i)).getYuzdeIndirim();
            } else {
                toplamFiyat = toplamFiyat + siparisler.get(i).getFiyat();
            }
        }
        System.out.println("Sepette bulunan ürünlerin toplam fiyatı : " + toplamFiyat + " TL");
    }


    public static void urunCikarma(ArrayList<OnlineSiparis> urun, OnlineSiparis kaldirilacakUrun) {
        urun.remove(kaldirilacakUrun);
        System.out.println(kaldirilacakUrun.urunAdi + " sepetten kaldırıldı");
    }

    public OnlineSiparis(boolean stoktaMi, int urunId, double fiyat, String kategori, String urunAdi) {
        this.stoktaMi = stoktaMi;
        this.urunId = urunId;
        this.fiyat = fiyat;
        this.kategori = kategori;
        this.urunAdi = urunAdi;
    }

    public boolean isStoktaMi() {
        return stoktaMi;
    }

    public void setStoktaMi(boolean stoktaMi) {
        this.stoktaMi = stoktaMi;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
}

class Urunler extends OnlineSiparis {

    public Urunler(boolean stoktaMi, int urunId, double fiyat, String kategori, String urunAdi) {
        super(stoktaMi, urunId, fiyat, kategori, urunAdi);
    }
}

class NormalUrunler extends Urunler {

    public NormalUrunler(boolean stoktaMi, int urunId, double fiyat, String kategori, String urunAdi) {
        super(stoktaMi, urunId, fiyat, kategori, urunAdi);
    }

    @Override
    public String toString() {
        return "Ürün Id :" + getUrunId() + " / Ürün : " + getUrunAdi() + " / Ürünün Fiyatı : " + getFiyat() + " / Ürünün Kategorisi : " + getKategori() + " / Ürünün Stok Durumu : " + isStoktaMi();
    }
}

class IndirimliUrunler extends Urunler {
    private double yuzdeIndirim;

    public double getYuzdeIndirim() {
        return yuzdeIndirim;
    }

    public void setYuzdeIndirim(double yuzdeIndirim) {
        this.yuzdeIndirim = yuzdeIndirim;
    }

    public IndirimliUrunler(boolean stoktaMi, int urunId, double fiyat, String kategori, String urunAdi) {
        super(stoktaMi, urunId, fiyat, kategori, urunAdi);
        yuzdeIndirim = 0.20;
    }

    @Override
    public String toString() {
        return "Ürün Id :" + getUrunId() + " / Ürün : " + getUrunAdi() + " / Ürünün İndirimli Fiyatı : " + getFiyat() * yuzdeIndirim + " / Ürünün Kategorisi : " + getKategori() + " / Ürünün Stok Durumu : " + isStoktaMi();
    }
}

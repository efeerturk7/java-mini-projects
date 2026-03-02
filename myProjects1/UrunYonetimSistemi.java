package myProjects1;

import java.util.*;

//Bu projede bir Ürün Yönetim Sistemi geliştirilecek. Ürünler ArrayList içerisinde tutulacak. Her ürün için ürün ID, adı, fiyat, kategori ve stok durumu
// bilgileri saklanacak. Ürünler Normal Ürün ve İndirimli Ürün olarak iki sınıfa ayrılacak,
// bu sınıflar abstract bir base class’tan türetilecek.
// Ürün bilgileri ekrana yazdırılırken Polymorphism ve Override edilmiş toString() metotları kullanılacak.
// Ürünler isimlerine veya fiyatlarına göre sıralanabilecek ve bu işlem için Comparable arayüzü kullanılacak. İ
// ihtiyaç halinde Interface kullanılarak ürün yönetimi işlemleri (ekle, sil, listele) soyutlanacak.
// Tüm sınıflar Encapsulation prensibine uygun yazılacak, ArrayList kullanılarak CRUD(create,read,update,delete) işlemleri yapılacak.
public class UrunYonetimSistemi {
    public static void main(String[] args) {
        ArrayList<Urunler4> urunler4s = new ArrayList<>();
        Urunler4 urunler4 = new Urunler4();
        Urunler4 urun1 = new IndirimliUrunler4(1625643, "Cikolata", 15.50, "Yiyecek", true);
        Urunler4 urun2 = new NormalUrunler4(103408, "Telefon", 75000.999, "Elektronik", true);
        Urunler4 urun3 = new NormalUrunler4(103, "Telefon Kılıfı", 750.999, "Aksesuar", true);
        Urunler4 urun4 = new IndirimliUrunler4(1643, "Makarna", 30.50, "Yiyecek", false);
        Urunler4 urun5 = new IndirimliUrunler4(346737, "Gömlek", 530.99, "Giyim", true);
        urunler4.urunEkleme(urunler4s, urun1);
        urunler4.urunEkleme(urunler4s, urun2);
        urunler4.urunEkleme(urunler4s, urun3);
        urunler4.urunEkleme(urunler4s, urun4);
        urunler4.urunEkleme(urunler4s, urun5);
        urunler4.urunleriListele(urunler4s);
        urunler4.urunSilme(urunler4s, urun4);
        System.out.println("***********************");
        Collections.sort(urunler4s);
        urunler4.urunleriListele(urunler4s);


    }
}

interface UrunYonetimi4 {
    void urunSilme(ArrayList<Urunler4> urunler, Urunler4 silinecekUrun);

    void urunEkleme(ArrayList<Urunler4> urunler4, Urunler4 eklenecekUrun);

    void urunleriListele(ArrayList<Urunler4> urunler4);
}

class Urunler4 implements UrunYonetimi4, Comparable<Urunler4> {
    private int urunId;
    private String urununAdi;
    private double urununFiyati;
    private String urununKategorisi;
    private boolean stoktaMi = false;

    public Urunler4() {

    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrununAdi() {
        return urununAdi;
    }

    public void setUrununAdi(String urununAdi) {
        this.urununAdi = urununAdi;
    }

    public double getUrununFiyati() {
        return urununFiyati;
    }

    public void setUrununFiyati(double urununFiyati) {
        this.urununFiyati = urununFiyati;
    }

    public String getUrununKategorisi() {
        return urununKategorisi;
    }

    public void setUrununKategorisi(String urununKategorisi) {
        this.urununKategorisi = urununKategorisi;
    }

    public boolean isStoktaMi() {
        return stoktaMi;
    }

    public void setStoktaMi(boolean stoktaMi) {
        this.stoktaMi = stoktaMi;
    }

    public Urunler4(int urunId, String urununAdi, double urununFiyati, String urununKategorisi, boolean stoktaMi) {
        this.urunId = urunId;
        this.urununAdi = urununAdi;
        this.urununFiyati = urununFiyati;
        this.urununKategorisi = urununKategorisi;
        this.stoktaMi = stoktaMi;
    }

    @Override
    public void urunSilme(ArrayList<Urunler4> urunler, Urunler4 silinecekUrun) {
        if (urunler.contains(silinecekUrun) == true && silinecekUrun.isStoktaMi() == true) {
            urunler.remove(silinecekUrun);
            System.out.println(silinecekUrun.getUrununAdi() + " Başarıyla kaldırılmıştır ");
        } else {
            System.out.println(" Ürün sistemde bulunmadığı için kaldırılamadı ");
        }
    }

    @Override
    public void urunEkleme(ArrayList<Urunler4> urunler4, Urunler4 eklenecekUrun) {
        urunler4.add(eklenecekUrun);
        System.out.println(eklenecekUrun.getUrununAdi() + " Başarıyla eklenmiştir ");
    }

    @Override
    public void urunleriListele(ArrayList<Urunler4> urunler4) {
        for (int i = 0; i < urunler4.size(); i++) {
            System.out.println(urunler4.get(i));
        }

    }

    @Override
    public int compareTo(Urunler4 o) {
            if (this.urununAdi.compareTo(o.urununAdi) < 0) {
                return -1;
            } else if (this.urununAdi.compareTo(o.urununAdi) > 0) {
                return 1;
            } else {
                return 0;
            }
    }
}

class NormalUrunler4 extends Urunler4 {

    public NormalUrunler4(int urunId, String urununAdi, double urununFiyati, String urununKategorisi, boolean stoktaMi) {
        super(urunId, urununAdi, urununFiyati, urununKategorisi, stoktaMi);
    }

    @Override
    public String toString() {
        return "ID :" + getUrunId() + " /  Ürünün Adı : " + getUrununAdi() + " /  Ürünün Kategorisi : " + getUrununKategorisi() + " /  İndirimli Ürünün Fiyatı : " + getUrununFiyati() + " TL  /  Ürünün Stok Durumu : " + isStoktaMi();
    }

}

class IndirimliUrunler4 extends Urunler4 {
    private double indirimYuzdesi = 0.70;

    public double getIndirimYuzdesi() {
        return indirimYuzdesi;
    }

    public void setIndirimYuzdesi(double indirimYuzdesi) {
        this.indirimYuzdesi = indirimYuzdesi;
    }

    public IndirimliUrunler4(int urunId, String urununAdi, double urununFiyati, String urununKategorisi, boolean stoktaMi) {
        super(urunId, urununAdi, urununFiyati, urununKategorisi, stoktaMi);
    }

    @Override
    public String toString() {
        return "ID :" + getUrunId() + " /  Ürünün Adı : " + getUrununAdi() + " /  Ürünün Kategorisi : " + getUrununKategorisi() + " /  İndirimli Ürünün Fiyatı : " + getUrununFiyati() * getIndirimYuzdesi() + " TL  /  Ürünün Stok Durumu : " + isStoktaMi();
    }
}
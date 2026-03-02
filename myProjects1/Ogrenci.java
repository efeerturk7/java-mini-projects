package myProjects1;
//tüm öğrenciler ArrayList yapısında tutulacak. Öğrenciler için ID, isim, soyisim, not bilgileri saklanacak,
// burslu öğrencilerde ayrıca burs miktarı bilgisi olacak. Kullanıcı; öğrenci ekleyebilecek, silebilecek, güncelleyebilecek,
//  ve isim veya ID’ye göre arama yapabilecek.  Encapsulation (getter/setter),
// Inheritance (kalıtım) ve Polymorphism (toString override) kullanılacak.

import java.util.ArrayList;

public class Ogrenci {
    private int id;
    private int not;
    private String ad;
    private String soyad;

    public Ogrenci(int id, int not, String ad, String soyad) {
        this.id = id;
        this.not = not;
        this.ad = ad;
        this.soyad = soyad;
    }

    public static void ogrenciEkleme(ArrayList<Ogrenci> ogrenciler, Ogrenci ekleneceOgrenci) {
        ogrenciler.add(ekleneceOgrenci);
    }

    public static void arama(ArrayList<Ogrenci> ogrenciler, int id, String ad) {
        boolean bulunduMu = false;
        for (Ogrenci o : ogrenciler) {
            if (o.getId() == id || o.getAd().equalsIgnoreCase(ad)) {
                System.out.println("Arama sonucu : " + o);
                bulunduMu = true;
            }
        }
        if (!bulunduMu) {
            System.out.println("Aradığınız öğrenci sistemde kayıtlı değil");
        }

    }

    public static void ogrenciSilme(ArrayList<Ogrenci> ogrenciler, Ogrenci silinecekOgrenci) {
        ogrenciler.remove(silinecekOgrenci);

    }

    public static void listele(ArrayList<Ogrenci> ogrenciler) {
        for (int i = 0; i < ogrenciler.size(); i++) {
            System.out.println(i + 1 + ". öğrencinin bilgileri : " + ogrenciler.get(i));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNot() {
        return not;
    }

    public void setNot(int not) {
        this.not = not;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
}

class NormalOgrenci extends Ogrenci {
    public NormalOgrenci(int id, int not, String ad, String soyad) {
        super(id, not, ad, soyad);
    }

    @Override
    public String toString() {
        return "Id :" + getId() + " / Ad : " + getAd() + " / Soyad :  " + getSoyad() + " / burs miktarı : bursu yok" + " / aldığı not : " + getNot();
    }
}

class BursluOgrenci extends Ogrenci {
    private String bursMiktari;

    public BursluOgrenci(int id, int not, String ad, String soyad, String bursMiktari) {
        super(id, not, ad, soyad);
        this.bursMiktari = bursMiktari;
    }

    @Override
    public String toString() {
        return "Id :" + getId() + " / Ad : " + getAd() + " / Soyad :  " + getSoyad() + " / burs miktarı : " + bursMiktari + "/ aldığı not : " + getNot();
    }
}

class ConsoleApp {
    public static void main(String[] args) {
        ArrayList<Ogrenci> ogrenciler1 = new ArrayList<>();
        Ogrenci ogrenci = new BursluOgrenci(1421352, 87, "Bahadır Efe", "Ertürk", "yüzde 50");
        Ogrenci ogrenci4 = new BursluOgrenci(36226432, 54, "Ali", "AĞA", "yüzde 17");
        Ogrenci ogrenci1 = new NormalOgrenci(1135, 67, "Ahmet", "Soylu");
        Ogrenci ogrenci2 = new NormalOgrenci(1135, 67, "Halil", "Boğazköy");
        Ogrenci ogrenci3 = new NormalOgrenci(1135, 67, "Salih", "Erdoğdu");
        Ogrenci.ogrenciEkleme(ogrenciler1, ogrenci);
        Ogrenci.ogrenciEkleme(ogrenciler1, ogrenci1);
        Ogrenci.ogrenciEkleme(ogrenciler1, ogrenci4);
        Ogrenci.ogrenciEkleme(ogrenciler1, ogrenci3);
        Ogrenci.ogrenciEkleme(ogrenciler1, ogrenci2);
        Ogrenci.listele(ogrenciler1);
        System.out.println("**************************** Silindikten Sonra ******************");
        Ogrenci.ogrenciSilme(ogrenciler1, ogrenci4);
        Ogrenci.listele(ogrenciler1);
        Ogrenci.arama(ogrenciler1, 1135, "ahmet");
    }
}


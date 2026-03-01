package myProjects;
//Her giriş-çıkış loglanır.
//Giriş geçmişi isme veya saate göre listelenebilir.
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;


public class AkilliGirisSistemYonetimi {
    public static void main(String[] args) {
        Calisan yonetici = new Yonetici("Ali", "KOÇ", 12);
        Calisan memur = new Memur("Mehmet", "Ersoy", 8);
        Calisan personel = new TeknikPersonel("Ali Rıza", "Ertürk", 8);
        Ziyaretci ziyaretci = new Ziyaretci("Salih", "Mandıra", "MüdürYardımcısı", 13);
        Ziyaretci ziyaretci2 = new Ziyaretci("Mehmet", "Mandıra", "Maliye", 12);
        Ziyaretci ziyaretci3 = new Ziyaretci("İsmail", "Mandıra", "Sekreterlik", 18);
        GuvenlikGorevlisi guvenlik = new GuvenlikGorevlisi("Mustafa", "Ağa", 7);
        guvenlik.personelGirisi(yonetici);
        guvenlik.personelGirisi(memur);
        guvenlik.personelGirisi(personel);
        guvenlik.ziyaretciGirisi(ziyaretci);
        guvenlik.ziyaretciGirisi(ziyaretci2);
        guvenlik.ziyaretciGirisi(ziyaretci3);
        guvenlik.personelGirisGecmisiniListele();
        guvenlik.personelCikisi(yonetici);
        guvenlik.personelGirisGecmisiniListele();


    }
}

abstract class Calisan {
    private String isim;
    private String soyisim;
    private int girisSaati;

    public int getGirisSaati() {
        return girisSaati;
    }

    abstract void personelKarti();

    public Calisan(String isim, String soyisim, int girisSaati) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.girisSaati = girisSaati;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    @Override
    public String toString() {
        return "İsim : " + getIsim() + " / Soyisim : " + getSoyisim() + "\n Giriş Saati : " + getGirisSaati();
    }
}

class Yonetici extends Calisan {
    @Override
    void personelKarti() {
        System.out.println("Yönetici Kartı ile geçiş yapılıyor");
    }

    public Yonetici(String isim, String soyisim, int girisSaati) {
        super(isim, soyisim, girisSaati);
    }

    @Override
    public String toString() {
        return "****************\n" + super.toString() + "\nAlanı : YÖNETİCİ " + "\n****************";
    }
}

class Memur extends Calisan {

    @Override
    void personelKarti() {
        System.out.println("Memur Karti ile geçiş yapılıyor...");
    }

    public Memur(String isim, String soyisim, int girisSaati) {
        super(isim, soyisim, girisSaati);
    }

    @Override
    public String toString() {
        return super.toString() + "\nAlanı : Memur ";
    }
}

class TeknikPersonel extends Calisan {

    @Override
    void personelKarti() {
        System.out.println("Teknik Personel Karti ile geçiş yapılıyor...");
    }

    public TeknikPersonel(String isim, String soyisim, int girisSaati) {
        super(isim, soyisim, girisSaati);
    }

    @Override
    public String toString() {
        return "****************\n" + super.toString() + "\nAlanı : Teknik Personel " + "\n****************";
    }
}

class Ziyaretci {
    private String ziyaretciAdi;
    private String ziyaretciSoyAdi;
    private String bolge;
    private int saat;

    public String getBolge() {
        return bolge;
    }

    public int getSaat() {
        return saat;
    }

    public Ziyaretci(String ziyaretciAdi, String ziyaretciSoyAdi, String bolge, int saat) {
        this.ziyaretciAdi = ziyaretciAdi;
        this.ziyaretciSoyAdi = ziyaretciSoyAdi;
        this.saat = saat;
        this.bolge = bolge;

    }

    public String getZiyaretciAdi() {
        return ziyaretciAdi;
    }

    public String getZiyaretciSoyAdi() {
        return ziyaretciSoyAdi;
    }

    @Override
    public String toString() {
        return "****************\n" + "Ziyaretçi Ad : " + getZiyaretciAdi() + " Soyad : " + getZiyaretciSoyAdi() + "\n****************";
    }
}

class GuvenlikGorevlisi extends Calisan {
    private ArrayList<Integer> girisSaatleri;
    private ArrayList<String> girisBolgeleri;
    private ArrayList<Ziyaretci> ziyaretciler;
    private ArrayList<Calisan> girisGecmisi;
    boolean bolgeUygun = false;
    boolean saatUygun = false;


    public ArrayList<Calisan> getGirisGecmisi() {
        return girisGecmisi;
    }

    public ArrayList<Integer> getGirisSaatleri() {
        return girisSaatleri;
    }

    public ArrayList<String> getGirisBolgeleri() {
        return girisBolgeleri;
    }


    public ArrayList<Ziyaretci> getZiyaretciler() {
        return ziyaretciler;
    }

    @Override
    void personelKarti() {
        System.out.println("Guvenlik Personel Karti ile geçiş yapılıyorr");
    }

    public GuvenlikGorevlisi(String isim, String soyisim, int girisSaati) {
        super(isim, soyisim, girisSaati);
        ziyaretciler = new ArrayList<>();
        girisGecmisi = new ArrayList<>();
        girisSaatleri = new ArrayList<>();
        girisBolgeleri = new ArrayList<>();
        girisGecmisi = new ArrayList<>();

    }

    public void ziyaretciGirisi(Ziyaretci eklenecekZiyaretci) {
        dosyaOlusturma();
        gecisIzinKontrol(eklenecekZiyaretci);
        if (bolgeUygun == true && saatUygun == true) {
            ziyaretciler.add(eklenecekZiyaretci);
        } else {
            System.out.println(eklenecekZiyaretci.getZiyaretciAdi() + " sisteme eklenemedi");
        }
    }

    public void ziyaretciCikisi(Ziyaretci cikacakZiyaretci) {
        if (ziyaretciler.contains(cikacakZiyaretci) != true) {
            System.out.println("Bu ziyaretçinin şirkette giriş geçmişi yoktur");
        } else {
            System.out.println(cikacakZiyaretci.getZiyaretciAdi() + " sistemden başarıyla çıkmıştır");
        }
    }

    private void dosyaOlusturma() {
        this.girisSaatleri.add(13);
        this.girisSaatleri.add(15);
        this.girisSaatleri.add(17);
        this.girisSaatleri.add(18);
        this.girisBolgeleri.add("MüdürYardımcısı");
        this.girisBolgeleri.add("Maliye");
        this.girisBolgeleri.add("Sekreterlik");
        this.girisBolgeleri.add("Danışmanlık");


    }

    private void gecisIzinKontrol(Ziyaretci eklenecekZiyaretci) {


        // Bölge kontrolü
        for (String izinliBolge : girisBolgeleri) {
            if (eklenecekZiyaretci.getBolge().equalsIgnoreCase(izinliBolge)) {
                bolgeUygun = true;
                break;
            }
        }

        // Saat kontrolü
        for (int izinliSaat : girisSaatleri) {
            if (eklenecekZiyaretci.getSaat() == izinliSaat) {
                saatUygun = true;
                break;
            }
        }

        // Sonuç
        if (bolgeUygun && saatUygun) {
            System.out.println("✅ Giriş izni verildi.");
        } else {
            System.out.println("❌ Giriş reddedildi. ");
            if (!bolgeUygun)
                System.out.println("→ Bu bölgeye giriş izniniz yok.");
            if (!saatUygun)
                System.out.println("→ Bu saat aralığında giriş izniniz yok.");
        }


    }

    public void personelGirisi(Calisan girisYapanPersonel) {
        if (girisYapanPersonel instanceof Calisan) {
            girisYapanPersonel.personelKarti();
            girisGecmisi.add(girisYapanPersonel);
            System.out.println(" Şirketimize Hoşgeldiniz : " + girisYapanPersonel.getIsim() + " Giriş Saati : " + girisYapanPersonel.getGirisSaati());
        } else {
            System.out.println("Bu kişi personel değildir ya da yanlış bir giriş yaptınız");
        }

    }

    public void personelCikisi(Calisan cikisYapanPersonel) {
        cikisYapanPersonel.personelKarti();
        System.out.println(" Tekrardan Bekleriz : " + cikisYapanPersonel.getIsim());
    }

    public void personelGirisGecmisiniListele() {
        for (Calisan calisan : girisGecmisi) {
            System.out.println(calisan);
        }

    }

    @Override
    public String toString() {
        return "****************\n" + super.toString() + " \nAlanı : Güvenlik Görevlisi " + "\n****************";
    }

}

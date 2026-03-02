package myProjects1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class UdemyPlayer {
    public static void main(String[] args) {
        Ogrenci1 ogrenci = new Ogrenci1("Bahadır", "bahadirefeerturk");
        Egitmen1 egitmen1 = new Egitmen1("Emre", "emr43");
        Egitmen1 egitmen2 = new Egitmen1("Aslı", "aslicelik");
        Ders1 ders1 = new Ders1(1, "Giriş", 3.5);
        Ders1 ders2 = new Ders1(2, "Java Nedir", 6.5);
        Ders1 ders3 = new Ders1(3, "Primitive tipler", 23.5);
        Ders1 ders4 = new Ders1(4, "diziler", 13.5);
        Kurs1 javakursu = new Kurs1("Java Kursu", egitmen1);
        javakursu.kursaDersEkle(ders1);
        javakursu.kursaDersEkle(ders2);
        javakursu.kursaDersEkle(ders3);
        javakursu.kursaDersEkle(ders4);
        javakursu.kursaEgitmenEkle(egitmen2);
        ogrenci.kursaKatil(javakursu);
    }

    public static void listeyiOynat(LinkedList<Ders1> izlenecekDersler) {
        Scanner scanner = new Scanner(System.in);
        boolean cikis = false;
        boolean ileriDogruHareket = true;
        ListIterator<Ders1> listIterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0) {
            System.out.println("henüz bir ders eklenmedi");
        } else {
            Ders1 ilkDers = listIterator.next();
            System.out.println("Şuan izlenen ders : " + ilkDers.getDersBasligi() + " Süre : " + ilkDers.getDersSuresi());
        }
        menuGoster();
        while (!cikis) {
            System.out.println("Seçiminiz : ");
            int kullaniciSecimi = scanner.nextInt();
            switch (kullaniciSecimi) {
                case 0:
                    System.out.println("uygulamadan çıkılıyor...");
                    cikis = true;
                    break;
                case 9:
                    menuGoster();
                    break;
                case 3:
                    izlenencekDersleriListele(izlenecekDersler);
                    break;
                case 1:
                    if (ileriDogruHareket) {
                        ileriDogruHareket = true;
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    }
                    if (listIterator.hasNext()) {
                        Ders1 ilkDers = listIterator.next();
                        System.out.println("*******************************************************");
                        System.out.println("Şuan OYNATILAN Ders no : " + ilkDers.getDersNo() + " başlık :" + ilkDers.getDersBasligi() + " Süre : " + ilkDers.getDersSuresi());
                        System.out.println("*******************************************************");
                    } else {
                        System.out.println("listenin sonuna geldiniz");
                    }
                    break;
                case 2:
                    if (ileriDogruHareket) {
                        ileriDogruHareket = false;
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    }
                    if (listIterator.hasPrevious()) {
                        Ders1 ilkDers = listIterator.previous();
                        System.out.println("******************************************************");
                        System.out.println("Şuan OYNATILAN Ders no : " + ilkDers.getDersNo() + " başlık :" + ilkDers.getDersBasligi() + " Süre : " + ilkDers.getDersSuresi());
                        System.out.println("*******************************************************");

                    } else {
                        System.out.println("listenin başına geldiniz");
                    }
                    break;
            }
        }

    }

    private static void izlenencekDersleriListele(LinkedList<Ders1> izlenecekDersler) {
        ListIterator<Ders1> listIterator = izlenecekDersler.listIterator();
        if (izlenecekDersler.size() == 0) {
            System.out.println("henüz bir ders eklenmedi");
            return;
        } else {
            while (listIterator.hasNext()) {
                Ders1 ilkDers = listIterator.next();
                System.out.println("Ders no : " + ilkDers.getDersNo() + " başlık :" + ilkDers.getDersBasligi() + " Süre : " + ilkDers.getDersSuresi());
            }
        }
    }

    private static void menuGoster() {
        System.out.println("*************** MENÜ **************");
        System.out.println(" 0-Çıkış \n" + "9-Menü\n" + "1-Bir sonraki derse geç\n" + "2-bir önceki derse git" + "3-tümlisteyigöster");
    }
}

abstract class Kisi1 {
    private String isim;
    private String kullaniciAdi;

    public Kisi1(String isim, String kullaniciAdi) {
        this.isim = isim;
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getIsim() {
        return isim;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                '}';
    }
}

class Ogrenci1 extends Kisi1 {
    private ArrayList<Kurs1> katildigimKurslar;
    private LinkedList<Ders1> izlenecekDersListesi;

    public Ogrenci1(String isim, String kullaniciAdi) {
        super(isim, kullaniciAdi);
        this.katildigimKurslar = new ArrayList<>();
        this.izlenecekDersListesi = new LinkedList<>();
    }

    public ArrayList<Kurs1> getKatildigimKurslar() {
        return katildigimKurslar;
    }

    public LinkedList<Ders1> getIzlenecekDersListesi() {
        return izlenecekDersListesi;
    }

    @Override
    public String toString() {
        return super.toString() + " Ogrenci1{" +
                " katildigimKurslar =" + katildigimKurslar +
                '}';
    }

    public void kursaKatil(Kurs1 kursaKatilma) {
        //this ifadesi mainde bu metodu çağıran nesne anlamına gelir
        if (kursaKatilma.kursYayindaKontrol()) {
            //kursaKatilma.getKursOgrencileri().add(ka);
            katildigimKurslar.add(kursaKatilma);
            System.out.println(this.getIsim() + " kullanıcısı " + kursaKatilma.getKursAdi() + " isimli  kursuna katıldı");
        } else {
            System.out.println(kursaKatilma.getKursAdi() + " isimli kurs yayında değil");
        }
    }

    public void izlenecekDersEkle(Ders1 izlenecekDers) {
        boolean dersBulundu = false;
        if (katildigimKurslar.size() >= 0) {
            for (Kurs1 gecici : katildigimKurslar) {
                if (gecici.getKurstakiDersler().contains(izlenecekDers)) {
                    System.out.println("İzlenecekler Listesine " + gecici.getKursAdi() + " isimli kursunda bulunan" + izlenecekDers.getDersBasligi() + " dersi eklendi");
                    izlenecekDersListesi.add(izlenecekDers);
                    dersBulundu = true;
                    break;
                }
            }
            if (!dersBulundu) {
                System.out.println("yetkisiz erişim");
            }
        }
    }
}

class Egitmen1 extends Ogrenci1 {

    public Egitmen1(String isim, String kullaniciAdi) {
        super(isim, kullaniciAdi);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Ders1 {
    private int dersNo;
    private String dersBasligi;
    private double dersSuresi;

    public Ders1(int dersNo, String dersBasligi, double dersSuresi) {
        this.dersNo = dersNo;
        this.dersBasligi = dersBasligi;
        this.dersSuresi = dersSuresi;
    }

    @Override
    public String toString() {
        return "Ders1{" +
                "dersNo=" + dersNo +
                ", dersBasligi='" + dersBasligi + '\'' +
                ", kursSuresi=" + dersSuresi +
                '}';
    }

    public int getDersNo() {
        return dersNo;
    }

    public String getDersBasligi() {
        return dersBasligi;
    }

    public double getDersSuresi() {
        return dersSuresi;
    }
}

class Kurs1 {
    private String kursAdi;
    private ArrayList<Ders1> kurstakiDersler;
    private ArrayList<Egitmen1> egitmenler;
    private boolean yayinda;
    private ArrayList<Ogrenci> kursOgrencileri;

    public String getKursAdi() {
        return kursAdi;
    }

    public ArrayList<Ders1> getKurstakiDersler() {
        return kurstakiDersler;
    }

    public ArrayList<Egitmen1> getEgitmenler() {
        return egitmenler;
    }

    public boolean isYayinda() {
        return yayinda;
    }

    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    public Kurs1(String kursAdi, Egitmen1 basEgitmen) {
        this.kursAdi = kursAdi;
        this.egitmenler = new ArrayList<>();
        this.kurstakiDersler = new ArrayList<>();
        this.egitmenler.add(0, basEgitmen);
        this.yayinda = false;
        this.kursOgrencileri = new ArrayList<>();
    }

    public void kursaEgitmenEkle(Egitmen1 eklenecekEgitmen1) {
        if (egitmenler.contains(eklenecekEgitmen1)) {
            egitmenler.add(eklenecekEgitmen1);
            System.out.println(eklenecekEgitmen1.getIsim() + " kursa eğitmen olarak eklendi");
        } else {
            System.out.println(eklenecekEgitmen1.getIsim() + " zaten kursta tanımlı bir eğitmendir");
        }

    }

    public void kursaEgitmenSilme(Egitmen1 silinecekEgitmen1) {
        if (silinecekEgitmen1.getIsim().equals(egitmenler.get(0))) {
            System.out.println("Baş Eğitmen Silinemez");
        } else {
            egitmenler.remove(silinecekEgitmen1);
            System.out.println(silinecekEgitmen1.getIsim() + " kurs eğitmenliğinden çıkarıldı");
        }

    }

    public void kursaDersEkle(Ders1 eklenecekDers1) {
        kurstakiDersler.add(eklenecekDers1);

    }

    public int kurstakiDersSayisi() {
        return kurstakiDersler.size();
    }

    private double kurstakiToplamDersinDakikaSuresi() {
        double toplamSure = 0.0;
        for (Ders1 gecici : kurstakiDersler) {
            toplamSure = +gecici.getDersSuresi();
        }
        return toplamSure;
    }

    public boolean kursYayindaKontrol() {
        if (kurstakiDersler.size() >= 5 && kurstakiToplamDersinDakikaSuresi() >= 60.0) {
            yayinda = true;
        } else {
            yayinda = false;
        }
        return yayinda;
    }
}

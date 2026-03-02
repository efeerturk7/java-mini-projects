package myProjects1;

import java.util.ArrayList;

public class KutuphaneTakipSistemi {
    public static void main(String[] args) {
        ArrayList<Kitap> kitaps = new ArrayList<>();
        Kitap kitap = new OduncKitap(2683, "Alsancak 1", "BABA", "ROMAN");
        Kitap kitap1 = new OduncKitap(2684, "Alsancak 2", "BABA", "ROMAN");
        Kitap kitap2 = new OduncKitap(2685, "Alsancak 3", "BABA", "ROMAN");
        Kitap kitap3 = new NormalKitap(2686, "Alsancak 4", "BABA", "ROMAN");
        Kitap kitap4 = new NormalKitap(267965, "Firariler ", "Ali İstan", "ROMAN");
        Kitap kitap5 = new NormalKitap(2125, "Kopuklar", "Yasin Çınar", "ROMAN");
        Kitap.kitapEkleme(kitaps, kitap1);
        Kitap.kitapEkleme(kitaps, kitap2);
        Kitap.kitapEkleme(kitaps, kitap3);
        Kitap.kitapEkleme(kitaps, kitap4);
        Kitap.kitapEkleme(kitaps, kitap5);
        Kitap.iadeAlma(kitaps, kitap1);
        Kitap.kitaplariListele(kitaps);
        System.out.println("***************************** Odunc aldıktan sonra *******************");
        Kitap.oduncAlma(kitaps, kitap2);
        Kitap.kitaplariListele(kitaps);


    }
}

class Kutuphane {
    private int id;
    private String kitapAdi;
    private String yazar;
    private String tur;
    private static int kitapSayisi = 0;
    private boolean oduncMu = true;

    public boolean isOduncMu() {
        return oduncMu;
    }

    public void setOduncMu(boolean oduncMu) {
        this.oduncMu = oduncMu;
    }

    public static void iadeAlma(ArrayList<Kitap> kitaplar, Kitap iadeAlinacakKitap) {
        kitaplar.addLast(iadeAlinacakKitap);
        kitapSayisi++;

    }

    public static void oduncAlma(ArrayList<Kitap> kitaplar, Kitap oduncVerilecekKitap) {
        if (!oduncVerilecekKitap.isOduncMu()) {
            oduncVerilecekKitap.setOduncMu(true);
            System.out.println("Kitap ödünç verildi.");
        } else {
            System.out.println("Zaten ödünçte.");
        }
    }

    public static void kitapEkleme(ArrayList<Kitap> kitaplar, Kitap eklenecekKitap) {
        kitaplar.add(eklenecekKitap);
        kitapSayisi++;

    }

    public static void kitapSilme(ArrayList<Kitap> kitaplar, Kitap silinecekKitap) {
        kitaplar.remove(silinecekKitap);
        if (kitapSayisi == 0) {
            System.out.println("Kütüphanede Kitap Bulunmuyor Lütfen Önce Kitap Ekleyin!!");
        } else {
            kitapSayisi--;
        }
    }

    public static void kitaplariListele(ArrayList<Kitap> kitaplar) {
        for (int i = 0; i < kitaplar.size(); i++) {
            System.out.println(i + 1 + " . kitabın bilgileri : " + kitaplar.get(i));
        }
    }

    public Kutuphane(int id, String kitapAdi, String yazar, String tur) {
        this.id = id;
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this.tur = tur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
}

class Kitap extends Kutuphane {


    public Kitap(int id, String kitapAdi, String yazar, String tur) {
        super(id, kitapAdi, yazar, tur);


    }
}

class OduncKitap extends Kitap {

    public OduncKitap(int id, String kitapAdi, String yazar, String tur) {
        super(id, kitapAdi, yazar, tur);


    }

    public String toString() {
        return " Kitap Adı : " + getKitapAdi() + " / Yazar : " + getYazar() + " / Kitabın Türü : " + getTur() + " / Ödünçtür";
    }
}

class NormalKitap extends Kitap {

    public NormalKitap(int id, String kitapAdi, String yazar, String tur) {
        super(id, kitapAdi, yazar, tur);

    }

    @Override
    public String toString() {
        return " / Kitap Adı : " + getKitapAdi() + " / Yazar : " + getYazar() + " / Kitabın Türü : " + getTur() + " / Kütüphanededir";
    }
}

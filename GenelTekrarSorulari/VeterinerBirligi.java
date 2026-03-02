package GenelTekrarSorulari;

import java.util.ArrayList;

public class VeterinerBirligi {
    public static void main(String[] args) {

    }

    private static void ilkNesneleriOlustur() {

    }
}

abstract class Hayvan {
    private String dogumTarihi;
    private boolean kayitLiMi;

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public boolean isKayitLiMi() {
        return kayitLiMi;
    }

    public void setKayitLiMi(boolean kayitLiMi) {
        this.kayitLiMi = kayitLiMi;
    }

    public Hayvan(String dogumTarihi, boolean kayitLiMi) {
        this.dogumTarihi = dogumTarihi;
        this.kayitLiMi = kayitLiMi;
    }

    abstract void bilgileriGoster();

    @Override
    public String toString() {
        return "Hayvan{" +
                "dogumTarihi='" + dogumTarihi + '\'' +
                ", kayitLiMi=" + kayitLiMi +
                '}';
    }
}

class Kedi extends Hayvan {
    private String tur;
    private String cins;

    public Kedi(String dogumTarihi, boolean kayitLiMi, String cins) {
        super(dogumTarihi, kayitLiMi);
        this.tur = "Kedi";
        this.cins = cins;
    }

    @Override
    void bilgileriGoster() {
        System.out.println(toString() + "Kayıtlı mı : " + isKayitLiMi() + " doğum tarihi : " + getDogumTarihi());
    }

    @Override
    public String toString() {
        return "Kedi{" +
                "tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                '}';
    }
}

class Kopek extends Hayvan {
    private int asiSayisi;
    private String tur;
    private String cins;

    public Kopek(String dogumTarihi, boolean kayitLiMi, int asiSayisi, String cins) {
        super(dogumTarihi, kayitLiMi);
        this.asiSayisi = asiSayisi;
        this.tur = "Köpek";
        this.cins = cins;
    }

    @Override
    void bilgileriGoster() {
        System.out.println(toString() + "  " + super.toString());

    }

    @Override
    public String toString() {
        return "Kopek{" +
                "asiSayisi=" + asiSayisi +
                ", tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                '}';
    }
}

abstract class Kisi {
    private String isim;
    private String tcKimlik;

    public Kisi(String isim, String tcKimlik) {
        this.isim = isim;
        this.tcKimlik = tcKimlik;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    abstract void kendiniTanit();

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tcKimlik='" + tcKimlik + '\'' +
                '}';
    }
}

class Musteri extends Kisi {
    private String adres;
    private ArrayList<Hayvan> musteriHayvanlari;

    public Musteri(String isim, String tcKimlik, String adres) {
        super(isim, tcKimlik);
        this.adres = adres;
        musteriHayvanlari = new ArrayList<>();
    }

    public void musteriHayvanlariniListele() {
        for (Hayvan hayvan : musteriHayvanlari) {
            System.out.println(hayvan);
        }
    }

    public void musteriyeHayvanEkle(Hayvan eklenecekHayvan) {
        musteriHayvanlari.add(eklenecekHayvan);
        System.out.println(getIsim() + "müsterisine eklendi");
    }

    @Override
    void kendiniTanit() {
        System.out.println(this.toString() + " ben bir musteriyim");

    }

    @Override
    public String toString() {
        return super.toString() + " Musteri{" +
                "adres='" + adres + '\'' +
                '}';
    }
}

class Veteriner extends Kisi {
    private ArrayList<Musteri> veterinerMusteriler;
    private String mezunOlduguOkul;
    private int calismaSuresi;
    private int musteriSayisi;

    public Veteriner(String isim, String tcKimlik, String mezunOlduguOkul, int calismaSuresi) {
        super(isim, tcKimlik);
        this.calismaSuresi = calismaSuresi;
        this.mezunOlduguOkul = mezunOlduguOkul;
        veterinerMusteriler = new ArrayList<>();
        musteriSayisi = 0;
    }


    public void musterileriListele() {
        for (Musteri musteri : veterinerMusteriler) {
            musteri.kendiniTanit();
        }
    }

    public void musteriEkle(Musteri eklencekMuster) {
        veterinerMusteriler.add(eklencekMuster);
        musteriSayisi++;
    }

    @Override
    void kendiniTanit() {
        System.out.println(toString() + " ben bir veterinerim");
    }

    @Override
    public String toString() {
        return super.toString() + " Veteriner{" +
                "mezunOlduguOkul='" + mezunOlduguOkul + '\'' +
                ", calismaSuresi=" + calismaSuresi +
                '}';
    }
}

class SehirVeterinerlikleri {
    private String sehir;
    private ArrayList<Veteriner> sehirdekiVeterinerler;
    private int sehirdekiVeterinerSayisi;

    public SehirVeterinerlikleri(String sehir) {
        this.sehir = sehir;
        sehirdekiVeterinerler = new ArrayList<>();
        sehirdekiVeterinerSayisi = 0;
    }

    public void sehireVeterinerEkle(Veteriner eklenecekSehirVeterineri) {
        sehirdekiVeterinerler.add(eklenecekSehirVeterineri);
        sehirdekiVeterinerSayisi++;
    }

    public void setSehirdekiVeterinerSayisiniBul() {
        System.out.println("Toplam sehirdeki veteriner sayisi : " + sehirdekiVeterinerler.size());
    }
}

class YonetimPaneli<T> {
    public void bilgileriGoster(T nesne) {
        System.out.println(nesne);
    }

    public <T extends Musteri> void sahipOlduguHayvanlariGoster(T musteri) {
        musteri.musteriHayvanlariniListele();
    }
}


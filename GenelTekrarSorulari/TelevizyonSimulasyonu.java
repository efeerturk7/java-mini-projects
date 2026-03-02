package GenelTekrarSorulari;

import java.util.ArrayList;
import java.util.Scanner;

public class TelevizyonSimulasyonu {
    static Scanner tara = new Scanner(System.in);
    static Televizyon televizyon;

    public static void main(String[] args) {
        menuGoster();
        boolean cikis = false;
        while (cikis == false) {
            System.out.println("Seçiniz : (Menüyü Görmek İçin 8 i tuşlayınız)");
            int secim = tara.nextInt();
            switch (secim) {
                case 5:
                    kanalDegistir();
                    break;
                case 4:
                    sesAzalt();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 7:
                    tvKapat();
                    break;
                case 2:
                    tvAc();
                    break;
                case 1:
                    tvKurVeKanallariOlustur();
                    break;
                case 8:
                    menuGoster();
                    break;
                case 0:
                    System.out.println("Menüden Çıkılıyor");
                    cikis = true;
                default:
                    System.out.println("0 ile 8 arasında bir değer giriniz");
                    break;
            }
        }

    }

    private static void kanalDegistir() {
        if (televizyon != null) {
            televizyon.kanalDegistir(2);
        } else {
            System.out.println("Once kanalları kurun");
        }
    }


    private static void sesAzalt() {
        if (televizyon != null) {
            televizyon.sesAzalt();
        } else {
            System.out.println("Once tvyi kurun");
        }
    }

    private static void sesArttir() {
        if (televizyon != null) {
            televizyon.sesArttir();

        } else {
            System.out.println("Önce tvyi kurun ");
        }
    }

    private static void tvKapat() {
        if (televizyon != null) {
            televizyon.tvKapat();
        } else {
            System.out.println("TV yi kurun ve kanalları oluşturun");
        }

    }

    private static void tvAc() {
        if (televizyon != null) {
            televizyon.tvAc();
        } else {
            System.out.println("TV yi kurun ve kanalları oluşturun");
        }
    }

    private static void tvKurVeKanallariOlustur() {
        if (televizyon == null) {
            tara.nextLine();
            System.out.println("Televizyonun markasını giriniz :");
            String marka = tara.nextLine();
            System.out.println("Televizyonun Boyutunu Giriniz :");
            String boyut = tara.nextLine();
            televizyon = new Televizyon(marka, boyut);
            System.out.println(televizyon);
        } else {
            System.out.println(televizyon);
        }


    }

    public static void menuGoster() {
        System.out.println("***************Menü**************");
        System.out.println(" 0 --> Çıkış\n" + " 1 --> Televizyonu Kur\n" + " 2 --> Televizyon Aç\n" + " 3 --> Sesi Arttır\n" + " 4 --> Sesi Azalt\n" +
                " 5 --> Kanalı Değiştir\n" + " 6 --> Kanal Bilgisini Göster\n" + " 7 --> Televizyonu kapat \n" + " 8 --> Menüye dön");

    }

}

class Televizyon {
    private int aktifKanal;
    private int ses;
    private String marka;
    private String boyut;
    private ArrayList<Kanal> kanallar;
    private boolean acik;

    public void kanalDegistir(int acilmasiIstenlilenKanal) {
        if (acik) {
            if (acilmasiIstenlilenKanal != aktifKanal) {
                if (acilmasiIstenlilenKanal <= kanallar.size() && acilmasiIstenlilenKanal >= 0) {
                    aktifKanal = acilmasiIstenlilenKanal;
                    System.out.println("Kanal :" + acilmasiIstenlilenKanal + " bilgi :" + kanallar.get(acilmasiIstenlilenKanal - 1).kanalBilgisiniGoster());

                } else {
                    System.out.println("Geçerli bir kanal numarası giriniz");
                }

            } else {
                System.out.println("Zaten aynı kanaldasınız " + aktifKanal);
            }

        } else {
            System.out.println("Lütfen televizyonu açın");
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public Televizyon(String marka, String boyut) {
        kanallar = new ArrayList<>();
        ses = 20;
        this.acik = false;
        this.marka = marka;
        this.boyut = boyut;
        kanallariOlustur();
        aktifKanal = 1;
    }

    public void sesArttir() {
        if (ses <= 20 && acik == true) {
            ses++;
            System.out.println("Ses seviyesi arttırıldı :" + ses);
        } else {
            System.out.println("Ses max seviyede");
        }
    }

    public void sesAzalt() {
        if (ses > 0 && acik) {
            ses--;
            System.out.println("Ses seviyesi azaldı :" + ses);
        } else {
            System.out.println("Ses min düzeyde");
        }
    }

    public void tvAc() {
        if (acik == false) {
            acik = true;
            System.out.println("TV AÇILDI");
        } else {
            System.out.println("TV ZATEN AÇIK");
        }
    }

    public void tvKapat() {
        if (acik == true) {
            acik = false;
            System.out.println("TV KAPANIYOR");
        } else {
            System.out.println("TV ZATEN KAPALI");
        }
    }

    private void kanallariOlustur() {
        HaberKanali cnn = new HaberKanali("CNN", 1, "Genel Haber");
        kanallar.add(cnn);
        HaberKanali trt = new HaberKanali("TRT SPOR", 3, "Spor Haber");
        kanallar.add(trt);
        MuzikKanali dreamTurk = new MuzikKanali("Dream Türk", 2, "Yerli");
        kanallar.add(dreamTurk);

    }

    @Override
    public String toString() {
        return "Televizyon{" +
                "marka='" + marka +
                ", boyut='" + boyut +
                '}';
    }
}

class HaberKanali extends Kanal {
    private String haberTur;

    public HaberKanali(String adi, int kanalNo, String haberTur) {
        super(adi, kanalNo);
        this.haberTur = haberTur;
    }
}

class MuzikKanali extends Kanal {
    private String muzikTuru;

    public MuzikKanali(String adi, int kanalNo, String muzikTuru) {
        super(adi, kanalNo);
        this.muzikTuru = muzikTuru;
    }
}

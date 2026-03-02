package GenelTekrarSorulari;

// Hesap makinesi sınıfı oluşturun.Bu sınıfta 4 işlem yapabilmek için metotlar oluşturunuz
//Bu metotlara istenilen sayıda parametre geçilebilmeli.Bölme işlemi için 0 değerini için gerekli kontrolü yazın.
public class HesapMakinesi {
    public void carpma(int... sayilar) {
        int carpma = 1;
        for (int oankiSayi : sayilar) {
            carpma = carpma * oankiSayi;
        }
        System.out.println("çarpma sonucu : " + carpma);
    }

    public void toplama(int... sayilar) {
        int toplama = 0;
        for (int oankiSayi : sayilar) {
            toplama = toplama + oankiSayi;
        }
        System.out.println("toplama sonucu : " + toplama);
    }

    public void cikarma(int... sayilar) {
        int cikarma = 0;
        for (int oankiSayi : sayilar) {
            cikarma = -cikarma - oankiSayi;
        }
        System.out.println("Çıkarma işleminin sonucu : " + cikarma);
    }

    public void bolme(double... sayilar) {
        double bolum=sayilar[0];
        for (double i=1.0;i<sayilar.length;i++){
            if (sayilar[(int) i]!=0.0){
                bolum=bolum/sayilar[(int) i];
                System.out.println("Bölüm işleminin sonucu :"+bolum);
            }else{
                System.out.println("0 a bölme hatası");
            }
        }
    }
}

class HesapMakinesiTest {
    public static void main(String[] args) {
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
        hesapMakinesi.carpma(5, 3);
        hesapMakinesi.cikarma(10, 5);
        hesapMakinesi.toplama(105,38);
        hesapMakinesi.bolme(10.0,5.0);
    }
}

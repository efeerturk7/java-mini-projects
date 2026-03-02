package GenelTekrarSorulari;

public class RasyonelSayi {
    private int pay;
    private int payda;

    public RasyonelSayi() {
        pay = 0;
        payda = 1;
    }

    public RasyonelSayi topla(RasyonelSayi toplanacakSayi) {
        int yeniPay = (this.pay * toplanacakSayi.payda) + (toplanacakSayi.pay * this.payda);
        int yeniPayda = payda * toplanacakSayi.payda;
        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    public RasyonelSayi cikar(RasyonelSayi cikarilacakSayi) {
        int yeniPay = (this.pay * cikarilacakSayi.payda) - (cikarilacakSayi.pay * this.payda);
        int yeniPayda = payda * cikarilacakSayi.payda;
        RasyonelSayi sonuc = new RasyonelSayi(yeniPay, yeniPayda);
        return sonuc;
    }

    public RasyonelSayi carp(RasyonelSayi carpilacakSayi) {
        int yeniPay = this.pay * carpilacakSayi.pay;
        int yeniPayda = this.payda * carpilacakSayi.payda;
        RasyonelSayi sonuc=new RasyonelSayi(yeniPay,yeniPayda);
        return sonuc;
    }
    public RasyonelSayi bolme(RasyonelSayi bolunecekSayi) {
        int yeniPay = this.pay * bolunecekSayi.payda;
        int yeniPayda = this.payda * bolunecekSayi.pay;
        RasyonelSayi sonuc=new RasyonelSayi(yeniPay,yeniPayda);
        return sonuc;
    }

    public RasyonelSayi(int pay, int payda) {
        int ebob = ebobBul(pay, payda);
        this.pay = ((payda > 0)) ? 1 : -1 * (pay / ebob);
        this.payda = payda / ebob;
    }

    private int ebobBul(int pay, int payda) {
        int payMutlakDeger = Math.abs(pay);
        int paydaMutlakDeger = Math.abs(payda);
        int ebob = 1;
        for (int i = 1; i < paydaMutlakDeger && i <= paydaMutlakDeger; i++) {
            if (payMutlakDeger % i == 0 && paydaMutlakDeger % i == 0) {
                ebob = i;

            }
        }
        return ebob;
    }

    @Override
    public String toString() {
        if (payda == 1) {
            return pay + " ";
        } else {
            return pay + " / " + payda;
        }
    }
}

class RasyonelSayiTest {
    public static void main(String[] args) {

    }
}

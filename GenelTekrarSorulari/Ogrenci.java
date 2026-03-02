package GenelTekrarSorulari;

//Ogrenci isimli bir sınıf oluşturun.Bu sınıfta ogrencinin id si ve not değeri tutulmalı
//100 elemanlı bir dizide id ve not değerlerini rastgele oluşturarak bu ogrencileri saklayın
//ve bu ogrencileri aldıkları nota göre azalan sırada yazdıran bir metot yazın
public class Ogrenci {
    private int id;
    private int not;


    public Ogrenci(int not, int id) {
        this.not = not;
        this.id = id;
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

    public void ogrenciDetaylari() {
        System.out.println(id + " numaralı id ye sahip öğrencinin notu :" + not);
    }

        }
class OgrenciTest {
    public static void main(String[] args) {
        Ogrenci ogrenciler[] = new Ogrenci[100];
        for (int i = 0; i < ogrenciler.length; i++) {
            int randomNot = (int) (Math.random() * 100) + 1;
            int randomId = (int) (Math.random() * 1000) + 1;
            Ogrenci ogrenci = new Ogrenci(randomNot, randomId);
            ogrenciler[i] = ogrenci;
            ogrenci.ogrenciDetaylari();

        }


    }
}



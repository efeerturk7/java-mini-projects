package GenelTekrarSorulari;

//Ekok(s1,s2) = (s2*s1) / Ebob(s1,s2)
public class IkiSayininEkoku {
    public static void main(String[] args) {
        System.out.println("İki Sayının Ekoku :"+ekok(13,7)/ebob(13,7));


    }
    public static int ebob(int i, int j) {
        int ebob = 1;
        for (int bolen = 1; bolen <= i && bolen <= j; bolen++) {
            if (i % bolen == 0 && j % bolen == 0) {
                ebob = bolen;
            } else {
                System.out.print("");
            }
        }
        return ebob;
    }
    public static int ekok(int i,int j){
        return i*j;
    }
}

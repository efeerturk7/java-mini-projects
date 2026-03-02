package GenelTekrarSorulari;

import java.util.ArrayList;

class StackTest {
    public static void main(String[] args) {
        ArrayList<Object> stacks = new ArrayList<>();
        Stack stack = new Stack();
        stacks.add(5);
        stacks.add("Ali");
        stacks.add(5.7);
        stacks.add(1054);
        stacks.add('A');
        stack.bosMu(stacks);
        stack.elemanVar(stacks);
        stack.push(stacks,"Bahadır");
        stack.pop(stacks);


    }
}

class Stack {
    //Yığın, içindeki verileri son giren ilk çıkar mantığıyla saklayan bir veri türü yapısıdır
    // Üst üste dizilmiş tabaklara benzetebilirsiniz. Sadece en üstteki veri dışarıya verilebilir
    //Sınıfı oluştururken elemanları tutacak bir ArrayList kullanabilirsiniz. Ayrıca sınıfta şu metotlar olmalı
    //bosMu() : boolean --> eğer hiç eleman yoksa true değeri döndürülmeli
    //kacElemanVar() : int --> eleman sayısını döndürür
    //pop() : Object --> En üstteki elemanı verir ve listeden çıkartır
    // push() : Object --> Yığının en üstüne eleman ekle
    // elemanAl() : Object --> En üstteki elemanı gösterir ama yığından çıkarmaz
    public void pop(ArrayList<Object> arrayList) {
        System.out.println("Yığındaki son eleman : " + arrayList.getLast());
        arrayList.remove(arrayList.getLast());
    }

    public void push(ArrayList<Object> arrayList, Object eklenecekEleman) {
        arrayList.addLast(eklenecekEleman);
        System.out.println("Sona eleman eklendi");
    }

    public void elemanAl(ArrayList<Object> arrayList) {
        System.out.println(arrayList.getLast());
    }

    public void bosMu(ArrayList<Object> arrayList) {
        if (arrayList.size() == 0) {
            System.out.println("Yığın boştur");
        } else {
            System.out.println("Yığın boş değildir");
        }
    }

    public void elemanVar(ArrayList<Object> arrayList) {
        System.out.println("Yığında bulunan eleman sayısı : " + arrayList.size());


    }


}

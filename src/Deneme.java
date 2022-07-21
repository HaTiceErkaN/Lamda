import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Deneme {
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15,23,-43,18,0,-6));
        enKucukElemanBul1(sayi);
        enKucukElemanBul2(sayi);
        enKucukElemanBul3(sayi);
        enKucukElemanBul4(sayi);
        bestenKucuTek(sayi);
        ciftElemanKareKucuktenBuyuge(sayi);
        tekElemanlarininKareleri(sayi);
    }
    public static void enKucukElemanBul1( List<Integer> sayi){
        //1. yontem Method Reference --> Integer class
        System.out.println("1.Yontem Integer Class: "+(sayi.stream().reduce(Integer::min)));
    }
    public static void enKucukElemanBul2(List<Integer> sayi){
        //2. yontem Method Reference --> Math class

        System.out.println("2.Yontem Math Class: "+(sayi.stream().reduce(Math::min)));
    }

    public static void enKucukElemanBul3(List <Integer> sayi){
        //3. yontem Lambda Expression

        System.out.println("3.Yontem Lambda Exp: "+(sayi.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b)));
    }
    public static void enKucukElemanBul4(List<Integer>sayi){
        //4. yontem Method Reference --> Haluk class

        System.out.println("4.Yontem HalukClass: "+(sayi.stream().reduce(Lambda02::byHalukMin)));
    }

    public static void bestenKucuTek(List<Integer>sayi){
        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
        System.out.println("5ten buyuk en kucuk tek : "+(sayi.stream().filter(t -> t > 5 && t%2==1).reduce(Math::min)));
    }
    public static void ciftElemanKareKucuktenBuyuge(List<Integer>sayi){
        // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
        sayi.stream().filter(t-> t%2==0).map(t-> t*t).sorted().forEach(Lambda01::yazdir);
    }
    public static void tekElemanlarininKareleri(List<Integer>sayi){
        // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
        sayi.stream().filter(t-> t%2==1).map(t-> t*t).sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir);

    }

}

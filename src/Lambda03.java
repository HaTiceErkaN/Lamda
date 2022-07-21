import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {

        List<String > menu=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havucDilim","buryan",
                "yaglama","kokareç","arabAşı","güveç","trileçe","trileçe","waffle","trileçe"));

        alfabetikBuyukHarfTekrarsiz(menu);
        System.out.println("\n  ***   ");
        karakterSayisiTersSirali(menu);
        System.out.println("\n  ***   ");
        karakterSayisiKucuktenBuyuge(menu);
        System.out.println("\n  ***   ");
        sonHarfeGoreTersSirali(menu);
        System.out.println("\n  ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n  ***   ");
        elemanYedidenAzMi(menu);
        System.out.println("\n  ***   ");
        wIleBaslayanElemanKontrolEt(menu);
        System.out.println("\n  ***   ");
        xIleBitenElemanVarMi(menu);
        System.out.println("\n  ***   ");
        karakterSayisiEnBuyukEleman(menu);
        System.out.println("\n  ***   ");
        sonHarfeGoreSiralaIlkElemanHaric(menu);
    }
    public static void alfabetikBuyukHarfTekrarsiz(List<String>yemek){
        yemek.
                stream().
             //   map(t->t.toUpperCase()).  //Jamb ex.
                map(String::toUpperCase).
                sorted(). //Alfabetik sira  //Method ref.
                distinct().  //Benzersiz tekrarsiz hale getirdi
                forEach(t-> System.out.print(t+" "));

    }
    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    public static void karakterSayisiTersSirali(List<String> yemek){
        // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
        yemek.
                stream().
              //  map(t-> t.length()).
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
               // forEach(t-> System.out.print(t+" "));
                forEach(Lambda01::yazdir);

    }
    public static void karakterSayisiKucuktenBuyuge(List<String >yemek){
        // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

        yemek.
                stream().
                sorted(Comparator.comparing(String::length)).
                distinct().
                forEach(t-> System.out.print(t+" "));
    }
    public static void sonHarfeGoreTersSirali(List<String>yemek){
        // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
        yemek.
                stream().
                sorted(Comparator.comparing(t-> t.toString().charAt(t.toString().length()-1)).
                        reversed()).
                forEach(t-> System.out.print(t+" "));

        // to.String ifadeyi string'e cevirir ve sonra string methodlari kullanilir.
    }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
public static void  charKaresiCiftElSirala(List<String > menu){
        menu.
                stream().
                map(t-> t.length()*t.length()).
                filter(Lambda01::ciftBul).  //Normalde bu satiri bir ustsatirda kullansaydik olmuyordu cünkü string'e ciftbul yapmaz
                // ama map'de string'deki karakterin length'inin karesini alinca artik o int oldu ve fitlereleme yapti
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::yazdir);
}
public static void elemanYedidenAzMi(List<String >menu){
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
/*
        boolean kontrol=menu.stream().allMatch(t-> t.length()<=7 );
        if (kontrol){
            System.out.println("List elemanlari 7 harfte buyuk degil");
        }else {
            System.out.println("List elemanlari 7 harfte buyuk degil");
        }
    System.out.println(kontrol);

 */
    System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 harfte buyuk degil" : "List elemanlari 7 harfte buyuk degil");
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }

    public static void wIleBaslayanElemanKontrolEt(List<String>menu){
        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemegin menude ne isi var" : " agam hic w li yemahh olur mi");
    }
    public static void xIleBitenElemanVarMi(List<String>yemek){
        // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

        System.out.println(yemek.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten eleman vardir" : " x ile biten eleman yoktur");

    }

    public static void karakterSayisiEnBuyukEleman(List<String >menu){
        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        System.out.println(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst());// yaptigimiz siralamadaki ilk elemani döndürür
        // limit(1) de kullanilabilirdi

        // Limit(1) sinirlandirma demek, Bu akişin elemanlarindan olusan, uzunlugu maxSize'den buyuk olmayacak sekilde
        //kesimiş bir akis return eder
    }
    public static void sonHarfeGoreSiralaIlkElemanHaric(List<String >menu){
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
        menu.
                stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).
                skip(1).  //ilk eleman atlandi.
                forEach(t-> System.out.print(t+" "));
    }


}

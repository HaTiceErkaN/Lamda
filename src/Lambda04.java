import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
     /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
     public static void main(String[] args) {
         Universite u01 = new Universite("bogazici", "matematik", 571, 93);
         Universite u02 = new Universite("istanbul teknik", "matematik", 622, 81);
         Universite u03 = new Universite("istanbul", "hukuk", 1453, 71);
         Universite u04 = new Universite("marmara", "bilgisayar muh", 1071, 77);
         Universite u05 = new Universite("yıldız teknik", "gemi", 333, 74);
         List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

         System.out.println("Not ort. 74'ten buyuk mu? "+notOrt74tenBuyukUnv(unv));
         System.out.println("**********");
         System.out.println("ogrenci sayisi 110'dan fazla mi? "+ogrenciSayisi100denAzMi(unv));
         System.out.println("**********");
         System.out.println("herhangi birinde mat bolumu var mi? "+matVatMi(unv));
         System.out.println("**********");
         ogrenciSayisiBuyuktenKucuge(unv);
         System.out.println("**********");
         System.out.println("Not ort göre ilk 3 uni siralamasi: "+notOrtGoreSirala(unv));
         System.out.println("**********");
         System.out.println(ogrenciSayisiEnAzOlanIkinci(unv));
         System.out.println("**********");
         System.out.println(notOrt63tenBuyukOgrenciSayisi(unv));
         System.out.println("**********");
         System.out.println("Not ort 333'den buyuk :"+ogrenciSayisi333denBuyukNotOrt(unv));
         System.out.println("**********");
         System.out.println("Task9 :" +matBolumlerininSayisi(unv));


     }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
public static boolean notOrt74tenBuyukUnv(List<Universite>unv){

       return   unv.stream().anyMatch(t-> t.getNotOrt()>74);
}
//task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrenciSayisi100denAzMi(List<Universite>unv){
        return unv.stream().anyMatch(t-> t.getOgrcSayisi()>110);

    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matVatMi(List<Universite>unv){
         unv.stream().anyMatch(t-> t.getBolum().contains("matematik"));
         return  unv.stream().anyMatch(t-> t.getBolum().contains("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
  public static void ogrenciSayisiBuyuktenKucuge(List<Universite>unv){
      System.out.println(unv.stream().sorted(Comparator.comparing(Universite::getOgrcSayisi).reversed()).collect(Collectors.toList()));
  }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.

    public static List<Universite> notOrtGoreSirala(List<Universite>unv){
      return unv.
                stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).collect(Collectors.toList());
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrenciSayisiEnAzOlanIkinci (List<Universite>unv){
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrcSayisi)).limit(2).skip(1).collect(Collectors.toList());
    }



        //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notOrt63tenBuyukOgrenciSayisi (List<Universite>unv){
         return unv.
                 stream().
                 filter(t-> t.getNotOrt()>65).
                 mapToInt(t-> t.getOgrcSayisi()).sum();
         //reduce(Integer::sum) da olabilridi   //Optional olur ama return type
        // reduce(Math::addExact) de olabilirdi  //Optional olur ama return type
    }


        //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrenciSayisi333denBuyukNotOrt(List<Universite>unv) {
       return unv.stream().filter(t -> t.getOgrcSayisi()>333).mapToDouble(t-> t.getNotOrt()).average();

       //33'den buyuk bi deger belki yok. O yüzden null cikacak ama return yype'a double dersen double null deger almaz
        //o yüzden OptionalDpuble olur.
        /*
        mapToDouble() methodu akistaki elemanlarin data type'ini parametresindeki degere gore double data type'a update eder
         */
    }

        //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumlerininSayisi (List<Universite>unv){
       return (int) unv.
               stream().
               filter(t-> t.getBolum().contains("mat")).
               count();  //akistaki eleman sayisini return eder
    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
        return unv.
                stream().//akıs
                        filter(t -> t.getOgrcSayisi() > 571).//unv obj akısı fittrelendi
                        mapToInt(t -> t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                        max();   //akısın en byk degerini return eder

    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
        return   unv.
                stream().
                filter(t->t.getOgrcSayisi()<1071).mapToInt(t-> t.getNotOrt()).min();

    }
}

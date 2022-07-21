import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        Path haluk= Path.of("src/halk.txt");  // src haluk dosyasini sürekli kullanacağimiz için bir tane variable'a atadik
        Stream<String> akis= Files.lines(haluk);  //Bu da haluk.txt datalari akis stream'ine atandi.

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        //1.yol:
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.
                lines(haluk).
                forEach(System.out::println);
        //2. yol
        akis.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/halk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        //1.yol limit()
        Files.lines(Paths.get("src/halk.txt")).
                limit(1).
                map(String::toLowerCase).
                forEach(System.out::println);
        //2.yol findFirst()
        System.out.println(Files.lines(haluk).
                findFirst().
                map(String::toLowerCase));
        //FindFirst terminal islemi olduğu icin sonrasinda forEach kullanamayiz


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(haluk).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        //1.yol distinct()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).  //satirlardaki kelimeleri array'e atadik.
                flatMap(Arrays::stream).  //kelimeler tek eleman olarak akisa alindi. (basari gayrete asiktir) DEGİL!! (basari) (gayrete) seklinde oldu
                distinct(). //benzersiz yapildi (farkli kelimeleri yazdircaz)
                collect(Collectors.toList()));   //akistaki tekrarsiz elemanlar list'e atandi

        //2.Yol  toset()
        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).collect(Collectors.toSet()));
        //distinct yapmadik çünkü set zaten benzersiz yapar
                /*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

 */
        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t-> t.split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equalsIgnoreCase("basari")).
                count());


        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
         System.out.println(Files.lines(haluk).
                 map(t -> t.split(" ")).
                 flatMap(Arrays::stream).
                 filter(t -> t.contains("a")).  // burda a harfi gecen kelime saysisin buluyor
                 // map(t->t.contains("a"))   burda a harfinin sayisini buluyor
                 count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
       Files.lines(haluk).
               map(t -> t.split(" ")).
               flatMap(Arrays::stream).
               filter(t -> t.contains("a")).
               collect(Collectors.toList()).forEach(System.out::println);


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").replaceAll("\\d", "").split("")).
                flatMap(Arrays::stream).distinct().count());


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\d","").split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());
        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\n*** haluk.txt dosyasinda  farkli kelimeleri print ediniz.  -->  ");
   Files.lines(haluk).
           map(t -> t.split(" ")).
           flatMap(Arrays::stream).
           distinct().
           collect(Collectors.toList()).
           forEach(t-> System.out.print(t+" "));


    }
}

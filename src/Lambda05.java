import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args){
        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create edini

        System.out.println("TASK 01 amele topla-->"+toplaAmele(10));
        System.out.println("TASK 01 cincix topla-->"+toplaCincix(10));
        System.out.println("   ***   ");

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
        System.out.println("TASK 02 cift topla-->"+toplaCift(10));
        System.out.println("   ***   ");

        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
        System.out.println("TASK 03 ilk cift topla-->"+ toplaİlkCiftSayi(10));
        System.out.println("   ***   ");

        //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
        System.out.println("TASK 04 ilk tek topla-->"+ toplaİlkTekSayi(10));
        System.out.println("   ***   ");

        //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
        System.out.print("2'nin ilk x kuvveti --> "); ikininIlkXKuvvetPrint(10);
        System.out.println("");
        System.out.println("   ***   ");

        //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
        System.out.print("istenen sayinin x kuvveti --> "); istenenSayiIlkXkuvvetPrint(18,6);
        System.out.println("");
        System.out.println("   ***   ");
        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
        System.out.println("istenen sayinin xfaktoriyeli --> "+istenenSayiFaktoriyel(5));
        System.out.println("   ***   ");

        //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
        System.out.println("istenen sayinin x. kuvveti --> "+istenenSayininXKuvveti(5,4));
        System.out.println("   ***   ");
    }
    //Structured(AMELE) Programming
    public static int toplaAmele(int x){
        int toplam=0;
        for (int i = 1; i <=x ; i++) {
            toplam+=i;
        }return toplam;
    }

    //Functional(cincix Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1).// baslangic dahil, bitis dahil degil degerler alindi(o yüzden x+1)
                        sum();//akısdakş int degerler toplandı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x){
        return IntStream.
                rangeClosed(1,x).  // baslangic ve bitis dahil degerler alindi.
                filter(Lambda01::ciftBul).
                sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaİlkCiftSayi(int x){
        return IntStream.
               iterate(2, t-> t+2).  //2'den sonsuza kadar her t degerini 2 artirarak (cift sayarak) akisa alir.
                limit(x).
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaİlkTekSayi(int x){
        return IntStream.
                iterate(1, t-> t+2).  //1'den sonsuza kadar her t degerini 2 artirarak (cift sayarak) akisa alir.
                        limit(x).
                sum();
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvvetPrint(int x){
        IntStream.
                iterate(2, t-> t*2).
                limit(x).
                forEach(Lambda01::yazdir);

    }

    public static void istenenSayiIlkXkuvvetPrint(int istenenSayi, int x){
        IntStream.
                iterate(istenenSayi,t->istenenSayi*t).
                limit(x).
                forEach(t->System.out.print(t + " "));

        /*
        IntStream.
        range(input1,input+1).
        forEach(t -> System.out.print(Math.pow(input1, t)+" ")
         */

        /*
            IntStream.iterate(istenenSayi,t->t*istenenSayi).
            limit(x).
            forEach(Lambda01::yazdir);
         */
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFaktoriyel(int x){
        return IntStream.
                rangeClosed(1,x).
               // reduce(Math::multiplyExact)
                reduce(1, (t,u)-> t*u);
    }
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenSayininXKuvveti(int istenenSayi , int x){
      //  return Math.pow(istenenSayi,x);
        return IntStream.iterate(istenenSayi, t-> t*istenenSayi).limit(x).reduce(1, (t,u)-> u);
    }
        }

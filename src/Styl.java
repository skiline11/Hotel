import java.util.Random;

public class Styl
{
    public enum Styl
    {
        orientalny, morski, nowoczesny, rustykalny, secesyjny;
    }

    private Random rand = new Random();

    public Styl losuj_styl()
    {
        int wynik_losowania = rand.nextInt(5);
        switch(wynik_losowania)
        {
            case(0) :
                return Styl.orientalny;
            case(1) :
                return Styl.morski;
            case(2) :
                return Styl.nowoczesny;
            case(3) :
                return Styl.rustykalny;
            case(4) :
                return Styl.secesyjny;
        }
        return Styl.secesyjny; // żeby kompilator się nie pluł że nic nie zwracam
    }
}

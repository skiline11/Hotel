import java.util.Random;

public class Kolorystyka
{
    public enum Kolorystyka
    {
        szary, stalowy, purpurowy, morski, seledynowy, jasnozielony;
    }

    private Random rand = new Random();

    public Kolorystyka losuj_kolorystyke()
    {
        int wynik_losowania = rand.nextInt(6);
        switch(wynik_losowania)
        {
            case(0) :
                return Kolorystyka.szary;
            case(1) :
                return Kolorystyka.stalowy;
            case(2) :
                return Kolorystyka.purpurowy;
            case(3) :
                return Kolorystyka.morski;
            case(4) :
                return Kolorystyka.seledynowy;
            case(5) :
                return Kolorystyka.jasnozielony;
        }
        return Kolorystyka.jasnozielony; // żeby kompilator się nie pluł że nic nie zwracam
    }

}

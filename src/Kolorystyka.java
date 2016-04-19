import java.util.Random;

public enum Kolorystyka
{
    szary, stalowy, purpurowy, morski, seledynowy, jasnozielony;

    private Random rand = new Random();

    public Kolorystyka losuj_kolorystyke()
    {
        int wynik_losowania = rand.nextInt(6);
        switch(wynik_losowania)
        {
            case(0) :
                return this.szary;
            case(1) :
                return this.stalowy;
            case(2) :
                return this.purpurowy;
            case(3) :
                return this.morski;
            case(4) :
                return this.seledynowy;
            case(5) :
                return this.jasnozielony;
        }
        return this.jasnozielony; // żeby kompilator się nie pluł że nic nie zwracam
    }

    public Kolorystyka ustaw_kolorystyke(String jaka_kolorystyka)
    {
        if(jaka_kolorystyka.equals("szary")) return this.szary;
        else if(jaka_kolorystyka.equals("stalowy")) return this.stalowy;
        else if(jaka_kolorystyka.equals("purpurowy")) return this.purpurowy;
        else if(jaka_kolorystyka.equals("morski")) return this.morski;
        else if(jaka_kolorystyka.equals("seledynowy")) return this.seledynowy;
        else if(jaka_kolorystyka.equals("jasnozielony")) return this.jasnozielony;
        else return this.jasnozielony;
    }

}
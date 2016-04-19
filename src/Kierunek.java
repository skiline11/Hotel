import java.util.Random;

public enum Kierunek
{
    północ, południe, wschód, zachód;

    private Random rand = new Random();
    public Kierunek losuj_kierunek()
    {

        int wynik_losowania = rand.nextInt(4);
        switch(wynik_losowania)
        {
            case(0) :
                return this.północ;
            case(1) :
                return this.południe;
            case(2) :
                return this.wschód;
            case(3) :
                return this.zachód;
        }
        return this.zachód; // żeby kompilator się nie pluł że nic nie zwracam
    }

    public Kierunek ustaw_kierunek(String jaki_kierunek)
    {
        if(jaki_kierunek.equals("północ")) return this.północ;
        else if(jaki_kierunek.equals("południe")) return this.południe;
        else if(jaki_kierunek.equals("wschód")) return this.wschód;
        else if(jaki_kierunek.equals("zachód")) return this.zachód;
        else return this.zachód;
    }
}

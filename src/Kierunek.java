public class Kierunek
{
    public enum Kierunek
    {
        północ, południe, wschód, zachód;
    }

    private Random rand = new Random();

    public Kierunek losuj_kierunek()
    {
        int wynik_losowania = rand.nextInt(4);
        switch(wynik_losowania)
        {
            case(0) :
                return Kierunek.północ;
            case(1) :
                return Kierunek.południe;
            case(2) :
                return Kierunek.wschód;
            case(3) :
                return Kierunek.zachód;
        }
        return Kierunek.zachód; // żeby kompilator się nie pluł że nic nie zwracam
    }
}

import java.util.Random;

public class Pokoj
{
    int numer, ilu_osobowy, cena;
    boolean dostęp_do_internetu;
    Styl jaki_styl;
    Kolorystyka jaka_kolorystyka;
    Kierunek jaki_kierunek;

    private static final int min_numer = 100;
    private static final int max_numer = 999;
    private static final int min_osob = 3;
    private static final int max_osob = 10;
    private static final int min_cena = 50;
    private static final int max_cena = 500;

    public Random rand = new Random();

    public int losuj(int min, int max)
    {
        return min + rand.nextInt(max + 1 - min);
    }

    public boolean losuj_dostęp_do_internetu()
    {
        if(rand.nextInt(2) < 1) return false;
        else return true;
    }

    public Pokoj()
    {
/*        Styl s = new Styl();
        Kolorystyka kol = new Kolorystyka();
        Kierunek kier = new Kierunek();
*/        this.numer = losuj(min_numer, max_numer);
        this.ilu_osobowy = losuj(min_osob, max_osob);
        this.cena = losuj(min_cena, max_cena);
        this.jaki_styl = losuj_styl();
        this.jaka_kolorystyka = losuj_kolorystyke();
        this.jaki_kierunek = losuj_kierunek();
        this.dostęp_do_internetu = losuj_dostęp_do_internetu();
    }
}

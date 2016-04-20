import java.util.Calendar;
import java.util.LinkedList;

public class Pokoj
{
    int numer, ilu_osobowy, cena;
    boolean dostęp_do_internetu;
    Styl jaki_styl;
    Kolorystyka jaka_kolorystyka;
    Kierunek jaki_kierunek;
    LinkedList<Przedzial_czasowy> zajete_terminy = new LinkedList<Przedzial_czasowy>();

    public Pokoj(int numer, int ilu_osobowy, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek, LinkedList<Przedzial_czasowy> zajete_terminy)
    {
        this.numer = numer;
        this.ilu_osobowy = ilu_osobowy;
        this.cena = cena;
        this.dostęp_do_internetu = dostęp_do_internetu;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
        this.zajete_terminy = zajete_terminy;
    }
}
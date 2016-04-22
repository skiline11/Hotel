import java.util.Calendar;
import java.util.LinkedList;

public class Pokoj
{
    private int numer, ilu_osobowy, cena;
    private boolean dostęp_do_internetu;
    private Styl jaki_styl;
    private Kolorystyka jaka_kolorystyka;
    private Kierunek jaki_kierunek;
    private LinkedList<Przedzial_czasowy> zajete_terminy = new LinkedList<Przedzial_czasowy>();

    public Pokoj(int numer, int ilu_osobowy, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek)
    {
        this.numer = numer;
        this.ilu_osobowy = ilu_osobowy;
        this.cena = cena;
        this.dostęp_do_internetu = dostęp_do_internetu;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
    }

    @Override
    public String toString() {
        return "Pokoj{" +
                "numer=" + numer +
                ", ilu_osobowy=" + ilu_osobowy +
                ", cena=" + cena +
                ", dostęp_do_internetu=" + dostęp_do_internetu +
                ", jaki_styl=" + jaki_styl +
                ", jaka_kolorystyka=" + jaka_kolorystyka +
                ", jaki_kierunek=" + jaki_kierunek +
                '}';
    }
}
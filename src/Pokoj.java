import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Iterator;

public class Pokoj
{
    public int numer, ilu_osobowy;
    public int cena;
    public boolean dostęp_do_internetu;
    public Styl jaki_styl;
    public Kolorystyka jaka_kolorystyka;
    public Kierunek jaki_kierunek;
    public ArrayDeque<Przedzial_czasowy> zajete_terminy;

    public Pokoj(int numer, int ilu_osobowy, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek)
    {
        this.numer = numer;
        this.ilu_osobowy = ilu_osobowy;
        this.cena = cena;
        this.dostęp_do_internetu = dostęp_do_internetu;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
        this.zajete_terminy = new ArrayDeque<>();
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

    public boolean czy_da_sie_zarezerwowac(Zamowienie rozpatrywane_zamowienie)
    {
        boolean da_sie = true;
        Iterator<Przedzial_czasowy> iterator_zajetych_terminow = zajete_terminy.iterator();
        while(iterator_zajetych_terminow.hasNext() && da_sie == true)
        {
            Przedzial_czasowy termin = iterator_zajetych_terminow.next();
            da_sie = rozpatrywane_zamowienie.czy_da_sie_zarezerwowac(termin);
        }
        return da_sie;
    }
}
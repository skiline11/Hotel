/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
import java.util.ArrayDeque;
import java.util.Iterator;

public class Pokoj
{
    public int numer, ilu_osobowy;
    public int cena;
    public Styl jaki_styl;
    public Kolorystyka jaka_kolorystyka;
    public Kierunek jaki_kierunek;
    public boolean dostep_do_internetu;
    private ArrayDeque<Przedzial_czasowy> zajete_terminy;

    public Pokoj(int numer, int ilu_osobowy, int cena, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek, boolean dostep_do_internetu)
    {
        this.numer = numer;
        this.ilu_osobowy = ilu_osobowy;
        this.cena = cena;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
        this.dostep_do_internetu = dostep_do_internetu;
        this.zajete_terminy = new ArrayDeque<>();
    }

    @Override
    public String toString() {
        return "Proponowany pokoj: " +
                " ilu_osobowy=" + ilu_osobowy +
                ", cena=" + cena +
                ", jaki_styl=" + jaki_styl +
                ", jaka_kolorystyka=" + jaka_kolorystyka +
                ", jaki_kierunek=" + jaki_kierunek +
                ", dostęp_do_internetu=" + dostep_do_internetu +".";
    }

    public boolean czy_da_sie_zarezerwowac(Zamowienie rozpatrywane_zamowienie)
    {
        boolean da_sie = true;
        Iterator<Przedzial_czasowy> iterator_zajetych_terminow = this.zajete_terminy.iterator();
        while(iterator_zajetych_terminow.hasNext() && da_sie == true)
        {
            Przedzial_czasowy termin = iterator_zajetych_terminow.next();
            da_sie = rozpatrywane_zamowienie.czy_da_sie_zarezerwowac(termin);
        }
        return da_sie;
    }
    public void rezerwuj(Ankieta ankieta)
    {
        Przedzial_czasowy nowy_przedzial = new Przedzial_czasowy(ankieta.data_przyjazdu, ankieta.data_wyjazdu);
        this.zajete_terminy.add(nowy_przedzial);
    }
}
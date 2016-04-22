/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
import java.util.Calendar;

public class Ankieta
{
    public Calendar data_przyjazdu, data_wyjazdu;
    public int ile_osob, cena;
    public boolean dostęp_do_internetu;
    public Styl jaki_styl;
    public Kolorystyka jaka_kolorystyka;
    public Kierunek jaki_kierunek;

    public Ankieta(int rok, int miesiac, int dzien, int ile_dni_pobytu, int ile_osob, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek)
    {
        this.data_przyjazdu = Calendar.getInstance();
        this.data_wyjazdu = Calendar.getInstance();
        this.data_przyjazdu.set(rok, miesiac, dzien);
        this.data_wyjazdu.set(rok, miesiac, dzien);
        this.data_wyjazdu.add(Calendar.DAY_OF_MONTH, ile_dni_pobytu - 1);
        this.ile_osob = ile_osob;
        this.cena = cena;
        this.dostęp_do_internetu = dostęp_do_internetu;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
    }

    boolean czy_da_sie_zarezerwowac(Przedzial_czasowy termin)
    {
        return (termin.pierwszy_dzien_pobytu.after(this.data_wyjazdu) ||  termin.ostatni_dzien_pobytu.before(this.data_przyjazdu));
    }

    public String zwroc_czas(Calendar time)
    {
        return time.get(Calendar.DAY_OF_MONTH) + "/" + time.get(Calendar.MONTH) + "/" + time.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return "Zamowienie: " +
                "data_przyjazdu=" + zwroc_czas(data_przyjazdu) + "rok" +
                ", data_wyjazdu=" + zwroc_czas(data_wyjazdu) + "rok" +
                ", ile_osob=" + ile_osob +
                ", cena=" + cena +
                ", dostęp_do_internetu=" + dostęp_do_internetu +
                ", jaki_styl=" + jaki_styl.toString() +
                ", jaka_kolorystyka=" + jaka_kolorystyka.toString() +
                ", jaki_kierunek=" + jaki_kierunek.toString() + ".";
    }
}
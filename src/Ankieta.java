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
        this.data_przyjazdu.set(rok, miesiac - 1, dzien);
        this.data_wyjazdu.set(rok, miesiac - 1, dzien);
        this.data_wyjazdu.add(data_przyjazdu.DATE, ile_dni_pobytu - 1);
        this.ile_osob = ile_osob;
        this.cena = cena;
        this.dostęp_do_internetu = dostęp_do_internetu;
        this.jaki_styl = jaki_styl;
        this.jaka_kolorystyka = jaka_kolorystyka;
        this.jaki_kierunek = jaki_kierunek;
    }
}
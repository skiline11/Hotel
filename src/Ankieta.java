import java.util.Calendar;

public class Ankieta
{
    Calendar data_przyjazdu, data_wyjazdu;
    int dzien, miesiac, rok, ile_dni_pobytu;
    int ile_osob, cena;
    boolean dostęp_do_internetu;
    Styl jaki_styl;
    Kolorystyka jaka_kolorystyka;
    Kierunek jaki_kierunek;

    public Ankieta(int dzien, int miesiac, int rok, int ile_dni_pobytu, int ile_osob, int cena, boolean dostep_do_internetu, String jaki_styl, String jaka_kolorystyka, String jaki_kierunek)
    {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
        this.ile_dni_pobytu = ile_dni_pobytu;
        this.ile_osob = ile_osob;
        this.cena = cena;
        this.dostęp_do_internetu = dostep_do_internetu;
        this.jaki_styl.ustaw_styl(jaki_styl);
        this.jaka_kolorystyka.ustaw_kolorystyke(jaka_kolorystyka);
        this.jaki_kierunek.ustaw_kierunek(jaki_kierunek);
    }
}
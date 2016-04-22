public class RecepcjonistaPerfekcjonista extends Recepcjonista{
    public RecepcjonistaPerfekcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        return (super.toString() + ", perfekcjonistyczna.");
    }

    public Pokoj wybierz_pokoj(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje)
    {
        int najlepszy_pokoj = -1;
        int spelnionych_wymagan;
        int iterator = 0;
        while(iterator < pokoje.length)
        {
            if(pokoje[iterator].czy_da_sie_zarezerwowac(rozpatrywane_zamowienie))
            {
                Ankieta ankieta = rozpatrywane_zamowienie.ankieta;
                spelnionych_wymagan = 0;
                if(pokoje[iterator].ilu_osobowy == ankieta.ile_osob) spelnionych_wymagan++;
                if(pokoje[iterator].cena == ankieta.cena) spelnionych_wymagan++;
                if(pokoje[iterator].dostęp_do_internetu == ankieta.dostęp_do_internetu) spelnionych_wymagan++;
                if(pokoje[iterator].jaki_styl == ankieta.jaki_styl) spelnionych_wymagan++;
                if(pokoje[iterator].jaka_kolorystyka == ankieta.jaka_kolorystyka) spelnionych_wymagan++;
                if(pokoje[iterator].jaki_kierunek == ankieta.jaki_kierunek) spelnionych_wymagan++;
                if(spelnionych_wymagan == 6)
                {
                    if(najlepszy_pokoj < 0) najlepszy_pokoj = iterator;
                    else if(pokoje[iterator].numer < pokoje[najlepszy_pokoj].numer) najlepszy_pokoj = iterator;
                }
            }
            iterator++;
        }
        if(najlepszy_pokoj == -1) return null;
        else return pokoje[najlepszy_pokoj];
    }
}

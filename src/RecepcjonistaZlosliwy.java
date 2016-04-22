public class RecepcjonistaZlosliwy extends Recepcjonista{
    public RecepcjonistaZlosliwy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", zlosliwa";
        return nazwa;
    }

    public Pokoj wybierz_pokoj(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje)
    {
        int najgorszy_pokoj = -1;
        int spelnionych_wymagan = 0;
        int min_spelnionych_wymagan = 7;
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
                if(najgorszy_pokoj < 0)
                {
                    najgorszy_pokoj = iterator;
                    min_spelnionych_wymagan = spelnionych_wymagan;
                }
                else
                {
                    if(spelnionych_wymagan < min_spelnionych_wymagan) najgorszy_pokoj = iterator;
                    else if(spelnionych_wymagan == min_spelnionych_wymagan)
                    {
                        if(pokoje[iterator].cena > pokoje[najgorszy_pokoj].cena) najgorszy_pokoj = iterator;
                        else if(pokoje[iterator].cena == pokoje[najgorszy_pokoj].cena)
                        {
                            if(pokoje[iterator].numer > pokoje[najgorszy_pokoj].numer) najgorszy_pokoj = iterator;
                        }
                    }
                }
            }
            iterator++;
        }
        return pokoje[najgorszy_pokoj];
    }
}

/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
public class KlientPolowiczny extends Klient{
    public KlientPolowiczny(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        return (super.toString() + ", polowiczna.");
    }

    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        int min_wymagan = 3;
        int spelnionych_wymagan = 0;
        if(pokoj.ilu_osobowy == ankieta.ile_osob) spelnionych_wymagan++;
        if(pokoj.cena == ankieta.cena) spelnionych_wymagan++;
        if(pokoj.dostep_do_internetu == ankieta.dostep_do_internetu) spelnionych_wymagan++;
        if(pokoj.jaki_styl == ankieta.jaki_styl) spelnionych_wymagan++;
        if(pokoj.jaka_kolorystyka == ankieta.jaka_kolorystyka) spelnionych_wymagan++;
        if(pokoj.jaki_kierunek == ankieta.jaki_kierunek) spelnionych_wymagan++;
        return(spelnionych_wymagan >= min_wymagan);
    }
}

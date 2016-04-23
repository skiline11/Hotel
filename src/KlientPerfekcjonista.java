/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
public class KlientPerfekcjonista extends Klient{
    public KlientPerfekcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        return (super.toString() + ", perfekcjonistyczna.");
    }
    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        if(
                pokoj.ilu_osobowy >= ankieta.ile_osob &&
                pokoj.cena <= ankieta.cena &&
                pokoj.dostep_do_internetu == ankieta.dostep_do_internetu &&
                pokoj.jaki_styl == ankieta.jaki_styl &&
                pokoj.jaka_kolorystyka == ankieta.jaka_kolorystyka &&
                pokoj.jaki_kierunek == ankieta.jaki_kierunek
                )
        {
            return true;
        }
        else return false;
    }
}

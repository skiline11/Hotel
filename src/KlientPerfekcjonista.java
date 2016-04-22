public class KlientPerfekcjonista extends Klient{
    public KlientPerfekcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", perfekcjonistyczna";
        return nazwa;
    }
    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        if(
                pokoj.ilu_osobowy == ankieta.ile_osob &&
                pokoj.cena == ankieta.cena &&
                pokoj.dostęp_do_internetu == ankieta.dostęp_do_internetu &&
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

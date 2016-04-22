public class Zamowienie
{
    private Klient klient;
    public Ankieta ankieta;
    private int licznik_rozpatrywań;

    public Zamowienie(Klient klient, Ankieta ankieta)
    {
        this.klient = klient;
        this.ankieta = ankieta;
        this.licznik_rozpatrywań = 0;
    }

    private void zwieksz_licznik()
    {
        this.licznik_rozpatrywań += 1;
    }

    private boolean czy_osiagnieto_limit_rozpatrywan()
    {
        return(this.licznik_rozpatrywań == 3);
    }

    public boolean czy_da_sie_zarezerwowac(Przedzial_czasowy termin)
    {
        return this.ankieta.czy_da_sie_zarezerwowac(termin);
    }

    public boolean czy_klient_akceptuje_pokoj(Pokoj pokoj)
    {
        return this.klient.czy_akceptuje_pokoj(pokoj, this.ankieta);
    }

}

public class Zamowienie
{
    private Klient klient;
    private Ankieta ankieta;
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

}

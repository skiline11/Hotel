/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
public class Zamowienie
{
    public Klient klient;
    public Ankieta ankieta;
    public int licznik_rozpatrywan;

    public Zamowienie(Klient klient, Ankieta ankieta)
    {
        this.klient = klient;
        this.ankieta = ankieta;
        this.licznik_rozpatrywan = 0;
    }

    public void zwieksz_licznik()
    {
        this.licznik_rozpatrywan += 1;
    }

    public boolean czy_osiagnieto_limit_rozpatrywan()
    {
        return(this.licznik_rozpatrywan == 3);
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

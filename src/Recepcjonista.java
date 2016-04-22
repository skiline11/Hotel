public abstract class Recepcjonista extends Osoba
{
    public Recepcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        String nazwa = "Klient: " + super.toString();
        return nazwa;
    }

    public abstract Pokoj wybierz_pokoj(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje);
}

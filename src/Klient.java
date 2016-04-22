public abstract class Klient extends Osoba
{
    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        return ("Klient: " + super.toString());
    }

    public abstract boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta);
}

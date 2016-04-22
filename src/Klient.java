public abstract class Klient extends Osoba
{
    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = "Klient: " + super.toString();
        return nazwa;
    }

    public abstract boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta);
}

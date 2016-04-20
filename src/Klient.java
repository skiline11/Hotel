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
}

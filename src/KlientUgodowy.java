public class KlientUgodowy extends Klient{
    public KlientUgodowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        String nazwa = super.toString() + ", ugodowa";
        return nazwa;
    }

    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        return true;
    }
}

public class KlientUgodowy extends Klient{
    public KlientUgodowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        String nazwa = super.toString() + ", ugodowa";
        return nazwa;
    }
}

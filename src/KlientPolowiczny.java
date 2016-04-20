public class KlientPolowiczny extends Klient{
    public KlientPolowiczny(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        String nazwa = super.toString() + ", polowiczna";
        return nazwa;
    }
}

public class KlientPerfekcjonista extends Klient{
    public KlientPerfekcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", perfekcjonistyczna";
        return nazwa;
    }
}
}
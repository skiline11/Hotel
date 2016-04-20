public class RecepcjonistaAproksymacyjny extends Recepcjonista {
    public RecepcjonistaAproksymacyjny(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", aproksymacyjna";
        return nazwa;
    }
}

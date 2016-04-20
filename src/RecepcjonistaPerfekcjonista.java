public class RecepcjonistaPerfekcjonista extends Recepcjonista{
    public RecepcjonistaPerfekcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", perfekcjonistyczna";
        return nazwa;
    }
}

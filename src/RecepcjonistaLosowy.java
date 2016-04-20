public class RecepcjonistaLosowy extends Recepcjonista{
    public RecepcjonistaLosowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", losowa";
        return nazwa;
    }
}

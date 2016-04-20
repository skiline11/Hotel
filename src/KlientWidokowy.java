public class KlientWidokowy extends Klient{
    public KlientWidokowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", widokowa";
        return nazwa;
    }
}

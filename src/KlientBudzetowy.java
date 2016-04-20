public class KlientBudzetowy extends Klient{
    public KlientBudzetowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", budzetowa";
        return nazwa;
    }
}

public class KlientWidokowy extends Klient{
    public KlientWidokowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", widokowa";
        return nazwa;
    }

    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        return(pokoj.jaki_kierunek == ankieta.jaki_kierunek);
    }
}

public class KlientWidokowy extends Klient{
    public KlientWidokowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        return (super.toString() + ", widokowa.");
    }

    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        return(pokoj.jaki_kierunek == ankieta.jaki_kierunek);
    }
}

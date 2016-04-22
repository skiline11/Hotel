/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
public class KlientBudzetowy extends Klient{
    public KlientBudzetowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        return (super.toString() + ", budzetowa.");
    }

    public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta)
    {
        return (pokoj.cena <= ankieta.cena);
    }
}

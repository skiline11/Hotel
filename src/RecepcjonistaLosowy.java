import java.util.Random;

public class RecepcjonistaLosowy extends Recepcjonista{
    public RecepcjonistaLosowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        return (super.toString() + ", losowa.");
    }

    @Override
    public Pokoj wybierz_pokoj(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje)
    {
        Random rand = new Random();
        int iterator = rand.nextInt(pokoje.length);
        while(pokoje[iterator].czy_da_sie_zarezerwowac(rozpatrywane_zamowienie) == false)
        {
            iterator = rand.nextInt(pokoje.length);
        }
        return pokoje[iterator];

    }
}

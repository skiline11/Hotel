import java.util.ArrayDeque;
import java.util.Queue;

public class Main
{
    public static final int ilosc_pokoi = 10;
    public static final int ilosc_recepcjonistow = 4;

    public void main(String[] args)
    {
        stworz_liste_pokoi();
        stworz_liste_recepcjonistow();
        stworz_hotel();
    }

    private void stworz_liste_pokoi()
    {
        Pokoj[] pokoje = new Pokoj[ilosc_pokoi];
    }

    private void stworz_liste_recepcjonistow()
    {
        Recepcjonista[] recepcjonisci = new Recepcjonista[ilosc_recepcjonistow];
    }

    private void stworz_hotel()
    {
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
    }

}

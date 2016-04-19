import java.util.ArrayDeque;
import java.util.Queue;

public class Main
{
    public static final int ilosc_pokoi = 10;
    public static final int ilosc_recepcjonistow = 4;
    public Pokoj[] pokoje;
    public Recepcjonista[] recepcjonisci;
    public Hotel hotel;
    public Zamowienie[] zamowienia;
    public void main(String[] args)
    {
        stworz_liste_pokoi();
        stworz_liste_recepcjonistow();
        stworz_hotel();
        stworz_liste_zamowien();
    }

    private void stworz_liste_pokoi()
    {
        pokoje = new Pokoj[ilosc_pokoi];
    }

    private void stworz_liste_recepcjonistow()
    {
        recepcjonisci = new Recepcjonista[ilosc_recepcjonistow];
    }

    private void stworz_hotel()
    {
        hotel = new Hotel(pokoje, recepcjonisci);
    }

    private void stworz_liste_zamowien()
    {
        zamowienia = new Pokoj[];
    }

}

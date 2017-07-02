import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args)
    {
        Pokoj[] pokoje = new Pokoj[13];
        Recepcjonista[] recepcjonisci = new Recepcjonista[3];
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
        ArrayDeque<Zamowienie> zamowienia = new ArrayDeque<>();
        hotel.stworz_liste_zamowien(zamowienia);
        hotel.akceptuj(zamowienia, pokoje, recepcjonisci);
    }
}

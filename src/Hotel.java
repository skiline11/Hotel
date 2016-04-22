import java.util.ArrayDeque;

public class Hotel
{
    private Pokoj[] pokoje;
    private Recepcjonista[] recepcjonisci;
    private ArrayDeque<Zamowienie> zamowienia;

    private static Zamowienie przyjmijZamowienie(Klient klient, Ankieta ankieta)
    {
        return new Zamowienie(klient, ankieta);
    }

    private static void stworz_liste_zamowien(ArrayDeque<Zamowienie> zamowienia)
    {
        Klient pan1 = new KlientBudzetowy("Imie1", "Nazwisko1");
        Ankieta ankieta1 = new Ankieta(1, 1, 1, 100, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.południe);
        zamowienia.add( przyjmijZamowienie(pan1, ankieta1) );

        Klient pan2 = new KlientPerfekcjonista("Imie2", "Nazwisko2");
        Ankieta ankieta2 = new Ankieta(1, 2, 3, 100, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.północ);
        zamowienia.add( przyjmijZamowienie(pan2, ankieta2) );

        Klient pan3 = new KlientPolowiczny("Imie3", "Nazwisko3");
        Ankieta ankieta3 = new Ankieta(1, 2, 20, 50, 3, 75, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschód);
        zamowienia.add( przyjmijZamowienie(pan3, ankieta3) );

        Klient pan4 = new KlientUgodowy("Imie4", "Nazwisko4");
        Ankieta ankieta4 = new Ankieta(1, 6, 5, 100, 5, 200, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachód);
        zamowienia.add( przyjmijZamowienie(pan4, ankieta4) );
    }

    private Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        pokoje[0] = new Pokoj(0, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.południe);
        pokoje[1] = new Pokoj(1, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.północ);
        pokoje[2] = new Pokoj(2, 3, 130, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschód);
        pokoje[3] = new Pokoj(3, 4, 150, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachód);
        pokoje[4] = new Pokoj(4, 5, 200, true, Styl.secesyjny, Kolorystyka.stalowy, Kierunek.południe);

        recepcjonisci[0] = new RecepcjonistaAproksymacyjny("Jan", "Nowak");
        recepcjonisci[1] = new RecepcjonistaLosowy("Tomasz", "Kowalski");
        recepcjonisci[2] = new RecepcjonistaPerfekcjonista("Albert", "Einstein");
        recepcjonisci[3] = new RecepcjonistaZlosliwy("Adolf", "Hitler");
    }

    public void akceptuj(ArrayDeque<Zamowienie> zamowienia, Pokoj[] pokoj, Recepcjonista[] recepcjonisci)
    {

    }

    private static void wypisz_pokoje(Pokoj[] pokoje)
    {
        for (int iterator = 0;iterator < pokoje.length; iterator++)
        {
            System.out.println(pokoje[iterator].toString());
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        Pokoj[] pokoje = new Pokoj[5];
        Recepcjonista[] recepcjonisci = new Recepcjonista[4];
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
        ArrayDeque<Zamowienie> zamowienia = new ArrayDeque<Zamowienie>();
        stworz_liste_zamowien(zamowienia);
        wypisz_pokoje(pokoje);
    }
}

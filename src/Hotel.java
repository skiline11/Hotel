import java.util.ArrayDeque;

public class Hotel
{
    private static final int ilosc_pokoi = 5;
    private static final int ilosc_recepcjonistow = 4;
    private static Pokoj[] pokoje;
    private static Recepcjonista[] recepcjonisci;
    private static ArrayDeque<Zamowienie> zamowienia;

    private void stworz_liste_pokoi()
    {
        Pokoj[] pokoje = new Pokoj[ilosc_pokoi];
    }

    private void stworz_liste_recepcjonistow()
    {
        recepcjonisci = new Recepcjonista[ilosc_recepcjonistow];
    }

    private void stworz_hotel()
    {
        hotel = new Hotel(pokoje, recepcjonisci);
    }

    public Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        dodaj_do_pokoi(pokoje[0], 0, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.południe);
        dodaj_do_pokoi(pokoje[1], 1, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.północ);
        dodaj_do_pokoi(pokoje[2], 2, 3, 130, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschód);
        dodaj_do_pokoi(pokoje[3], 3, 4, 150, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachód);
        dodaj_do_pokoi(pokoje[4], 4, 5, 200, true, Styl.secesyjny, Kolorystyka.stalowy, Kierunek.południe);

        recepcjonisci[0] = new RecepcjonistaAproksymacyjny("Jan", "Nowak");
        recepcjonisci[1] = new RecepcjonistaLosowy("Tomasz", "Kowalski");
        recepcjonisci[2] = new RecepcjonistaPerfekcjonista("Albert", "Einstein");
        recepcjonisci[3] = new RecepcjonistaZlosliwy("Adolf", "Hitler");
    }

    private void dodaj_do_pokoi(Pokoj pokoj, int numer, int ilu_osobowy, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek)
    {
        pokoj = new Pokoj(numer, ilu_osobowy, cena, dostęp_do_internetu, jaki_styl, jaka_kolorystyka, jaki_kierunek);
    }

    public void akceptuj(ArrayDeque<Zamowienie> zamowienia, Pokoj[] pokoj, Recepcjonista[] recepcjonisci)
    {

    }

    public Zamowienie przyjmijZamowienie(Klient klient, Ankieta ankieta)
    {
        return new Zamowienie(klient, ankieta);
    }

    private void stworz_liste_zamowien()
    {
        zamowienia = new ArrayDeque<Zamowienie>();

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

    private void wypisz_pokoje()
    {
        for(int iterator = 0; iterator < ilosc_pokoi; iterator++)
        {
            System.out.println(pokoje[iterator].toString());
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        this.stworz_liste_pokoi();
        hotel.stworz_liste_recepcjonistow();
        hotel.stworz_hotel();
        hotel.stworz_liste_zamowien();
        hotel.wypisz_pokoje();
    }
}

public class Hotel
{
    public static final int ilosc_pokoi = 10;
    public static final int ilosc_recepcjonistow = 4;
    public static final int ilosc_klientow = 10;
    public Pokoj[] pokoje;
    public Recepcjonista[] recepcjonisci;
    public Hotel hotel;

    public void main(String[] args)
    {
        stworz_liste_pokoi();
        stworz_liste_recepcjonistow();
        stworz_hotel();
        recepcjonisci[0].wypiszWizytowke();
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

    public Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        dodaj_do_pokoi(pokoje[0], 0, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.południe);
        dodaj_do_pokoi(pokoje[1], 1, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.północ);
        dodaj_do_pokoi(pokoje[2], 2, 3, 130, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschód);
        dodaj_do_pokoi(pokoje[3], 3, 4, 150, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachód);
        dodaj_do_pokoi(pokoje[4], 4, 5, 200, true, Styl.secesyjny, Kolorystyka.stalowy, Kierunek.południe);

        dodaj_do_recepcjonistow("Jan", "Nowak", "perfekcjonistyczna", recepcjonisci, 0);
        dodaj_do_recepcjonistow("Tomasz", "Kowalski", "losowa", recepcjonisci, 1);
        dodaj_do_recepcjonistow("Kacper", "Dob", "złośliwa", recepcjonisci, 2);
        dodaj_do_recepcjonistow("Adam", "Pierwszy", "aproksymacyjna", recepcjonisci, 3);
    }

    private void dodaj_do_pokoi(Pokoj pokoj, int numer, int ilu_osobowy, int cena, boolean dostęp_do_internetu, Styl jaki_styl, Kolorystyka jaka_kolorystyka, Kierunek jaki_kierunek)
    {
        pokoj = new Pokoj(numer, ilu_osobowy, cena, dostęp_do_internetu, jaki_styl, jaka_kolorystyka, jaki_kierunek);
    }

    private void dodaj_do_recepcjonistow(String imie, String nazwisko, String strategia, Recepcjonista[] recepcjonisci, int numer)
    {
        recepcjonisci[numer] = new Recepcjonista(imie, nazwisko, strategia);
    }

    public void akceptuj(Zamowienie[] zamowienia, Pokoj[] pokoj, Recepcjonista[] recepcjonisci)
    {

    }

    public Zamowienie przyjmijZamowienie(Klient klient, Ankieta ankieta)
    {
        Zamowienie zamowienie = new Zamowienie(klient, ankieta);
        return zamowienie;
    }
}

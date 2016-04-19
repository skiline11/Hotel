public class Hotel extends Main
{
    public Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        for(int iterator = 0; iterator < ilosc_pokoi; iterator++)
        {
            pokoje[iterator] = new Pokoj();
        }
        dodaj_do_recepcjonistow("Jan", "Nowak", "perfekcjonistyczna", recepcjonisci, 0);
        dodaj_do_recepcjonistow("Tomasz", "Kowalski", "losowa", recepcjonisci, 1);
        dodaj_do_recepcjonistow("Kacper", "Dob", "złośliwa", recepcjonisci, 2);
        dodaj_do_recepcjonistow("Adam", "Pierwszy", "aproksymacyjna", recepcjonisci, 3);
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

    }

    public static void main(String[] args)
    {

    }
}

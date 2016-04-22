/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
import java.util.ArrayDeque;
import java.util.Iterator;

public class Hotel
{
    //private Pokoj[] pokoje;
    //private Recepcjonista[] recepcjonisci;
    //private ArrayDeque<Zamowienie> zamowienia;

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

    private boolean czy_da_sie_zarezerwować_pokoj_w_podanym_przedziale_czasowym(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje)
    {
        boolean da_sie = false;
        int iterator_pokoi = 0;
        while(da_sie == false && iterator_pokoi < pokoje.length)
        {
            da_sie = pokoje[iterator_pokoi].czy_da_sie_zarezerwowac(rozpatrywane_zamowienie);
            iterator_pokoi++;
        }
        return da_sie;
    }

    private void akceptuj(ArrayDeque<Zamowienie> zamowienia, Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {

        Iterator<Zamowienie> iterator_zamowien = zamowienia.iterator();
        int iterator_recepcjonistow = 0;
        while(! zamowienia.isEmpty())
        {
            if(iterator_zamowien.hasNext() == false) iterator_zamowien = zamowienia.iterator();
            Zamowienie rozpatrywane_zamowienie = iterator_zamowien.next();
            if(this.czy_da_sie_zarezerwować_pokoj_w_podanym_przedziale_czasowym(rozpatrywane_zamowienie, pokoje))
            {
                if(iterator_recepcjonistow >= recepcjonisci.length) iterator_recepcjonistow = 0;
                Pokoj wybrany_pokoj_przez_recepcjoniste = recepcjonisci[iterator_recepcjonistow].wybierz_pokoj(rozpatrywane_zamowienie, pokoje);
                if (rozpatrywane_zamowienie.czy_klient_akceptuje_pokoj(wybrany_pokoj_przez_recepcjoniste) == true)
                {
                    wybrany_pokoj_przez_recepcjoniste.rezerwuj(rozpatrywane_zamowienie.ankieta);
                    System.out.println(recepcjonisci[iterator_recepcjonistow].toString());
                    System.out.println(rozpatrywane_zamowienie.ankieta.toString());
                    System.out.println(wybrany_pokoj_przez_recepcjoniste.toString());
                    System.out.println(rozpatrywane_zamowienie.klient.toString());
                    System.out.println("tak/nie\n");
                }
                else
                {
                    rozpatrywane_zamowienie.zwiększ_licznik();
                    if(rozpatrywane_zamowienie.czy_osiagnieto_limit_rozpatrywan() == false) zamowienia.add(rozpatrywane_zamowienie);
                }
            }
            iterator_zamowien.remove();
        }
    }

    private void stworz_liste_zamowien(ArrayDeque<Zamowienie> zamowienia)
    {
        Klient pan1 = new KlientBudzetowy("Imie1", "Nazwisko1");
        Ankieta ankieta1 = new Ankieta(1, 1, 1, 100, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.południe);
        zamowienia.add( new Zamowienie(pan1, ankieta1) );

        Klient pan2 = new KlientPerfekcjonista("Imie2", "Nazwisko2");
        Ankieta ankieta2 = new Ankieta(1, 2, 3, 100, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.północ);
        zamowienia.add( new Zamowienie(pan2, ankieta2) );

        Klient pan3 = new KlientPolowiczny("Imie3", "Nazwisko3");
        Ankieta ankieta3 = new Ankieta(1, 2, 20, 50, 3, 75, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschód);
        zamowienia.add( new Zamowienie(pan3, ankieta3) );

        Klient pan4 = new KlientUgodowy("Imie4", "Nazwisko4");
        Ankieta ankieta4 = new Ankieta(1, 6, 5, 100, 5, 200, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachód);
        zamowienia.add( new Zamowienie(pan4, ankieta4) );
    }

    public static void main(String[] args)
    {
        Pokoj[] pokoje = new Pokoj[5];
        Recepcjonista[] recepcjonisci = new Recepcjonista[4];
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
        ArrayDeque<Zamowienie> zamowienia = new ArrayDeque<>();
        hotel.stworz_liste_zamowien(zamowienia);
        hotel.akceptuj(zamowienia, pokoje, recepcjonisci);
    }
}

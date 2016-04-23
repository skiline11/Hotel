/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
import java.util.ArrayDeque;
import java.util.Iterator;

public class Hotel
{
    private Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        pokoje[0] = new Pokoj(0, 2, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.poludnie);
        pokoje[1] = new Pokoj(1, 3, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.polnoc);
        pokoje[2] = new Pokoj(3, 5, 130, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschod);
        pokoje[3] = new Pokoj(4, 7, 150, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachod);
        pokoje[4] = new Pokoj(5, 9, 200, true, Styl.secesyjny, Kolorystyka.szary, Kierunek.poludnie);
        pokoje[5] = new Pokoj(6, 11, 100, true, Styl.morski, Kolorystyka.seledynowy, Kierunek.zachod);
        pokoje[6] = new Pokoj(7, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.polnoc);
        pokoje[7] = new Pokoj(8, 30, 130, false, Styl.orientalny, Kolorystyka.stalowy, Kierunek.wschod);
        pokoje[8] = new Pokoj(9, 40, 150, true, Styl.rustykalny, Kolorystyka.szary, Kierunek.zachod);
        pokoje[9] = new Pokoj(10, 45, 200, false, Styl.secesyjny, Kolorystyka.purpurowy, Kierunek.poludnie);
        pokoje[10] = new Pokoj(11, 11, 100, false, Styl.morski, Kolorystyka.morski, Kierunek.wschod);
        pokoje[11] = new Pokoj(12, 21, 50, false, Styl.nowoczesny, Kolorystyka.jasnozielony, Kierunek.polnoc);
        pokoje[12] = new Pokoj(13, 3, 75, false, Styl.orientalny, Kolorystyka.jasnozielony, Kierunek.polnoc);

        recepcjonisci[0] = new RecepcjonistaLosowy("Krecik", "Grzebcio");
        recepcjonisci[1] = new RecepcjonistaPerfekcjonista("Smok", "Tabaluga");
        recepcjonisci[2] = new RecepcjonistaAproksymacyjny("Pingwin", "Jakub");
        recepcjonisci[3] = new RecepcjonistaZlosliwy("Bałwan", "Arktos");
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

        Iterator<Zamowienie> iterator_zamowien;
        int iterator_recepcjonistow = 0;
        while(! zamowienia.isEmpty())
        {
            iterator_zamowien = zamowienia.iterator();
            zamowienia.add(iterator_zamowien.next()); /* kopiuję element z początku listy, na jej koniec */
            iterator_zamowien = zamowienia.iterator();
            iterator_zamowien.next();
            iterator_zamowien.remove(); /* usuwam początkowy element listy */

            Zamowienie rozpatrywane_zamowienie = zamowienia.getLast(); /* od tej pory pracuję ostatnim elementcie, jeśli będzie taka potrzeba to po prostu go usunę, a jak nie to zostawię */
            if(czy_da_sie_zarezerwować_pokoj_w_podanym_przedziale_czasowym(rozpatrywane_zamowienie, pokoje))
            {
                if(iterator_recepcjonistow >= recepcjonisci.length) iterator_recepcjonistow = 0;
                Pokoj wybrany_pokoj_przez_recepcjoniste = recepcjonisci[iterator_recepcjonistow].wybierz_pokoj(rozpatrywane_zamowienie, pokoje);
                if(wybrany_pokoj_przez_recepcjoniste == null)
                {
                    rozpatrywane_zamowienie.zwieksz_licznik();
                    if(rozpatrywane_zamowienie.czy_osiagnieto_limit_rozpatrywan() == true)
                    {
                        zamowienia.removeLast();
                    }
                }
                else if (rozpatrywane_zamowienie.czy_klient_akceptuje_pokoj(wybrany_pokoj_przez_recepcjoniste) == true)
                {
                    wybrany_pokoj_przez_recepcjoniste.rezerwuj(rozpatrywane_zamowienie.ankieta);
                    System.out.println(recepcjonisci[iterator_recepcjonistow].toString());
                    System.out.println(rozpatrywane_zamowienie.ankieta.toString());
                    System.out.println(wybrany_pokoj_przez_recepcjoniste.toString());
                    System.out.println(rozpatrywane_zamowienie.klient.toString());
                    System.out.println("tak/nie\n");
                    zamowienia.removeLast();
                }
                else
                {
                    rozpatrywane_zamowienie.zwieksz_licznik();
                    if(rozpatrywane_zamowienie.czy_osiagnieto_limit_rozpatrywan() == true)
                    {
                        zamowienia.removeLast();
                    }
                }
            }
            iterator_recepcjonistow++;
        }
    }

    private void stworz_liste_zamowien(ArrayDeque<Zamowienie> zamowienia)
    {
        Klient pan1 = new KlientBudzetowy("Oszczedny", "Felek");
        Ankieta ankieta1 = new Ankieta(1, 1, 1, 10, 1, 100, true, Styl.morski, Kolorystyka.jasnozielony, Kierunek.poludnie);
        zamowienia.add( new Zamowienie(pan1, ankieta1) );

        Klient pan2 = new KlientPerfekcjonista("Mateusz", "Perfekt");
        Ankieta ankieta2 = new Ankieta(1, 1, 5, 10, 2, 50, true, Styl.nowoczesny, Kolorystyka.morski, Kierunek.polnoc);
        zamowienia.add( new Zamowienie(pan2, ankieta2) );

        Klient pan3 = new KlientPolowiczny("Robert", "Przepolowiony");
        Ankieta ankieta3 = new Ankieta(1, 1, 10, 10, 3, 75, true, Styl.orientalny, Kolorystyka.purpurowy, Kierunek.wschod);
        zamowienia.add( new Zamowienie(pan3, ankieta3) );

        Klient pan4 = new KlientUgodowy("Jan", "Baranowski");
        Ankieta ankieta4 = new Ankieta(1, 1, 15, 10, 5, 200, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.zachod);
        zamowienia.add( new Zamowienie(pan4, ankieta4) );

        Klient pan5 = new KlientWidokowy("Hilary", "Patrzygała");
        Ankieta ankieta5 = new Ankieta(1, 1, 20, 10, 15, 120, false, Styl.nowoczesny, Kolorystyka.szary, Kierunek.polnoc);
        zamowienia.add( new Zamowienie(pan5, ankieta5) );

        Klient pan6 = new KlientBudzetowy("Pan", "Pieniazek");
        Ankieta ankieta6 = new Ankieta(1, 1, 25, 10, 25, 100, true, Styl.morski, Kolorystyka.morski, Kierunek.poludnie);
        zamowienia.add( new Zamowienie(pan6, ankieta6));

        Klient pan7 = new KlientPerfekcjonista("Marian", "Idealny");
        Ankieta ankieta7 = new Ankieta(1, 1, 30, 10, 21, 50, false, Styl.nowoczesny, Kolorystyka.jasnozielony, Kierunek.polnoc);
        zamowienia.add( new Zamowienie(pan7, ankieta7));

        Klient pan8 = new KlientPerfekcjonista("Ferdynand", "Pierwszy");
        Ankieta ankieta8 = new Ankieta(1, 2, 5, 10, 21, 50, false, Styl.nowoczesny, Kolorystyka.jasnozielony, Kierunek.polnoc);
        zamowienia.add( new Zamowienie(pan8, ankieta8));

        Klient pan9 = new KlientPolowiczny("Antek", "Dzielnikowy");
        Ankieta ankieta9 = new Ankieta(1, 2, 10, 10, 12, 75, true, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.wschod);
        zamowienia.add( new Zamowienie(pan9, ankieta9));
    }

    public static void main(String[] args)
    {
        Pokoj[] pokoje = new Pokoj[13];
        Recepcjonista[] recepcjonisci = new Recepcjonista[4];
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
        ArrayDeque<Zamowienie> zamowienia = new ArrayDeque<>();
        hotel.stworz_liste_zamowien(zamowienia);
        hotel.akceptuj(zamowienia, pokoje, recepcjonisci);
    }
}

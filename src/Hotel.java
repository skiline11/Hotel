/* Michał Radecki nr 371591
   Zadanie lab.nr1 : Hotel
 */
import java.util.ArrayDeque;
import java.util.Iterator;

public class Hotel
{
    private Hotel(Pokoj[] pokoje, Recepcjonista[] recepcjonisci)
    {
        pokoje[0] = new Pokoj(1, 4, 50, Styl.nowoczesny, Kolorystyka.morski, Kierunek.polnoc, false); // Dla testów aproksymacyjnych
        pokoje[1] = new Pokoj(2, 8, 150, Styl.morski, Kolorystyka.jasnozielony, Kierunek.polnoc, true); // Dla testów aproksymacyjnych
        pokoje[2] = new Pokoj(3, 10, 40, Styl.nowoczesny, Kolorystyka.purpurowy, Kierunek.polnoc, true); // Dla testów aproksymacyjnych
        pokoje[3] = new Pokoj(4, 1, 250, Styl.orientalny, Kolorystyka.seledynowy, Kierunek.polnoc, true);
        pokoje[4] = new Pokoj(5, 3, 10, Styl.rustykalny, Kolorystyka.stalowy, Kierunek.polnoc, true); // Dla testów perfekcjonisty
        pokoje[5] = new Pokoj(6, 3, 8, Styl.rustykalny, Kolorystyka.stalowy,  Kierunek.polnoc, true); // Dla testów perfekcjonisty
        pokoje[6] = new Pokoj(7, 4, 300, Styl.nowoczesny, Kolorystyka.szary, Kierunek.poludnie, true); // Dla testów złośliwych
        pokoje[7] = new Pokoj(8, 4, 300, Styl.morski, Kolorystyka.szary, Kierunek.wschod, true); // Dla testów złośliwych i widokowych
        pokoje[8] = new Pokoj(9, 6, 260, Styl.orientalny, Kolorystyka.seledynowy,  Kierunek.wschod, false); // Dla testów widokowych
        pokoje[9] = new Pokoj(10, 2, 30, Styl.nowoczesny, Kolorystyka.szary, Kierunek.wschod, true); // Dla testów widokowych

        recepcjonisci[0] = new RecepcjonistaPerfekcjonista("Marek", "Idealista");
        recepcjonisci[1] = new RecepcjonistaZlosliwy("Adam", "Podły");
        recepcjonisci[2] = new RecepcjonistaAproksymacyjny("Olaf", "Uczynny");
        recepcjonisci[3] = new RecepcjonistaLosowy("Zuzanna", "Enigma");
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
                    System.out.println("tak\n");
                    zamowienia.removeLast();
                }
                else
                {
                    System.out.println(recepcjonisci[iterator_recepcjonistow].toString());
                    System.out.println(rozpatrywane_zamowienie.ankieta.toString());
                    System.out.println(wybrany_pokoj_przez_recepcjoniste.toString());
                    System.out.println(rozpatrywane_zamowienie.klient.toString());
                    System.out.println("nie\n");
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
        Klient klientPerfekcjonista = new KlientPerfekcjonista("Jan", "Dokładny");
        Klient klientUgodowy = new KlientUgodowy("Wojtek", "Obojętny");
        Klient klientBudzetowy = new KlientBudzetowy("Michał", "Skąpigrosz");
        Klient klientWidokowy = new KlientWidokowy("Ola", "Marzyciel");
        Klient klientPołowiczny = new KlientPolowiczny("Andrzej", "Niepewny");

        Ankieta ankieta = new Ankieta(2017, 12, 31, 5, 3, 10, Styl.rustykalny, Kolorystyka.stalowy, Kierunek.polnoc, true);
        zamowienia.add( new Zamowienie(klientPerfekcjonista, ankieta) );

        ankieta = new Ankieta(2018, 10, 31, 2, 5, 250, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.polnoc,false);
        zamowienia.add( new Zamowienie(klientUgodowy, ankieta) );

        ankieta = new Ankieta(2019, 11, 27, 5, 6, 50, Styl.nowoczesny, Kolorystyka.purpurowy, Kierunek.polnoc, true);
        zamowienia.add( new Zamowienie(klientBudzetowy, ankieta) );

        ankieta = new Ankieta(2020, 12, 31, 60, 3, 100, Styl.secesyjny, Kolorystyka.jasnozielony, Kierunek.wschod, true);
        zamowienia.add( new Zamowienie(klientWidokowy, ankieta) );

        ankieta = new Ankieta(2018, 1, 5, 5, 3, 10, Styl.rustykalny, Kolorystyka.stalowy, Kierunek.polnoc, true);
        zamowienia.add( new Zamowienie(klientPerfekcjonista, ankieta) );

        ankieta = new Ankieta(2021, 9, 30, 30, 1, 78, Styl.nowoczesny, Kolorystyka.morski, Kierunek.zachod, true);
        zamowienia.add( new Zamowienie(klientPołowiczny, ankieta));

        ankieta = new Ankieta(2017, 5, 23, 5, 5, 1, Styl.rustykalny, Kolorystyka.stalowy, Kierunek.zachod, true);
        zamowienia.add( new Zamowienie(klientBudzetowy, ankieta));

        ankieta = new Ankieta(2016, 10, 23, 2200, 5, 250, Styl.rustykalny, Kolorystyka.seledynowy, Kierunek.polnoc,false);
        zamowienia.add( new Zamowienie(klientUgodowy, ankieta));

        ankieta = new Ankieta(2018, 1, 9, 5, 3, 10, Styl.rustykalny, Kolorystyka.stalowy, Kierunek.polnoc, true);
        zamowienia.add( new Zamowienie(klientPerfekcjonista, ankieta));
    }

    public static void main(String[] args)
    {
        Pokoj[] pokoje = new Pokoj[10];
        Recepcjonista[] recepcjonisci = new Recepcjonista[4];
        Hotel hotel = new Hotel(pokoje, recepcjonisci);
        ArrayDeque<Zamowienie> zamowienia = new ArrayDeque<>();
        hotel.stworz_liste_zamowien(zamowienia);
        hotel.akceptuj(zamowienia, pokoje, recepcjonisci);
    }
}

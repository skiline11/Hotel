public class RecepcjonistaLosowy extends Recepcjonista{
    public RecepcjonistaLosowy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", losowa";
        return nazwa;
    }

    @Override
    public Pokoj wybierz_pokoj(Zamowienie rozpatrywane_zamowienie, Pokoj[] pokoje) {
        if(sprawdz_czy_jest_pokoj_o_zgodnej_dacie)

    }
}

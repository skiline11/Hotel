public abstract class Recepcjonista extends Osoba
{
    public Recepcjonista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public String toString()
    {
        String nazwa = "Klient: " + this.imie_i_nazwisko;
        return nazwa;
    }
}

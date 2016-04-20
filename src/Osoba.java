public class Osoba {

    private String imie, nazwisko;
    public Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public String toString() {
        String imie_i_nazwisko = this.imie + " " + this.nazwisko;
        return imie_i_nazwisko;
    }
}

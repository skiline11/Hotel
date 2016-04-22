public class Osoba {

    private String imie, nazwisko;
    public Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public String toString() {
        return (this.imie + " " + this.nazwisko);
    }
}

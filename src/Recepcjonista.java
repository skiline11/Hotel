public class Recepcjonista
{
    private String imie, nazwisko, strategia_wyboru;

    public Recepcjonista(String imie, String nazwisko, String strategia_wyboru)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.strategia_wyboru = strategia_wyboru;
    }

    public void wypiszWizytowke()
    {
        System.out.println("Recepcjonista: " + this.imie + " " + this.nazwisko + ", " + this.strategia_wyboru + ".");
    }
}

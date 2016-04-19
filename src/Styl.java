import java.util.Random;

public enum Styl
{
    orientalny, morski, nowoczesny, rustykalny, secesyjny;

    public Random rand = new Random();
    public Styl losuj_styl()
    {
        int wynik_losowania = rand.nextInt(5);
        switch(wynik_losowania)
        {
            case (0):
                return this.orientalny;
            case (1):
                return this.morski;
            case (2):
                return this.nowoczesny;
            case (3):
                return this.rustykalny;
            case (4):
                return this.secesyjny;
        }
        return this.secesyjny; // żeby kompilator się nie pluł że nic nie zwracam
    }

    public Styl ustaw_styl(String jaki_styl)
    {
        if(jaki_styl.equals("orientalny")) return this.orientalny;
        else if(jaki_styl.equals("morski")) return this.morski;
        else if(jaki_styl.equals("nowoczesny")) return this.nowoczesny;
        else if(jaki_styl.equals("rustykalny")) return this.rustykalny;
        else if(jaki_styl.equals("secesyjny")) return this.secesyjny;
        else return this.secesyjny;
    }
}



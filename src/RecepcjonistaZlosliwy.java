public class RecepcjonistaZlosliwy extends Recepcjonista{
    public RecepcjonistaZlosliwy(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    public String toString()
    {
        String nazwa = super.toString() + ", zlosliwa";
        return nazwa;
    }
}

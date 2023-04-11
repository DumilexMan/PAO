package obiecte;

public class Arma extends Obiect{
    private int daune;

    public Arma(int daune) {
        this.daune = daune;
    }

    public void setDaune(int daune) {
        this.daune = daune;
    }

    public int getDaune() {
        return daune;
    }
}

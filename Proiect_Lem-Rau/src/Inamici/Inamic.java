package Inamici;
import Jucator.Jucator;
public class Inamic {
    protected int viata;
    protected int daune;
    protected int rezistenta;

    public void setViata(int viata) {
        this.viata = viata;
    }

    public void setDaune(int daune) {
        this.daune = daune;
    }

    public void setRezistenta(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    public Inamic(int viata, int daune, int rezistenta) {
        this.viata = viata;
        this.daune = daune;
        this.rezistenta = rezistenta;
    }

    protected int getViata() {
        return viata;
    }

    protected int getDaune() {
        return daune;
    }

    public int getRezistenta() {
        return rezistenta;
    }

    public void provoaca_daune(Jucator jucator) {
        jucator.setViata(jucator.getViata() - (getDaune() - jucator.getRezistenta()));
    }


    // -Daunele se calculează astfel: Daunele primite - Rezistența = Daunele asupra vieții.  v = v - (x-y)
    public void calculeaza_daune(int daune) {
        int x = daune;
        int y = getRezistenta();
        int v = getViata();
        x = x - y;
        if (x < 0)
            x = 0;
        v = v - x;
        if (v < 0)
            v = 0;
        setViata(v);
    }

    @Override
    public String toString() {
        return "Inamic{" +
                "viata=" + viata +
                ", daune=" + daune +
                ", rezistenta=" + rezistenta +
                '}';
    }
}

package inamici;
import jucator.Jucator;
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
        int rezistenta = getRezistenta();
        int viata = getViata();
        daune = daune - rezistenta;
        if (daune < 0)
            daune = 0;
        viata = viata - daune;
        if (viata < 0)
            viata = 0;
        setViata(viata);
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

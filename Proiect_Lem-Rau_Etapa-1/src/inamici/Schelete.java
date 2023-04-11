package inamici;

import Constants.Constante;
import jucator.Jucator;

public class Schelete extends Inamic {


    //5 viata
//2 daune
//1 rezistenta
    public Schelete() {
        super(5, 2, 1);
    }

    public Schelete(int viata, int daune, int rezistenta) {
        super(viata, daune, rezistenta);
    }

    @Override
    public void setViata(int viata) {
        this.viata = viata;
    }

    @Override
    public void setDaune(int daune) {
        this.daune = daune;
    }

    @Override
    public void setRezistenta(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    @Override
    public int getViata() {
        return viata;
    }

    @Override
    public int getDaune() {
        return daune;
    }

    @Override
    public int getRezistenta() {
        return rezistenta;
    }



    @Override
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
        System.out.println(Constante.SCH_DMG_1 + daune + Constante.DMG);
    }

    @Override
    public void provoaca_daune(Jucator jucator) {
        int daune = getDaune();
        jucator.calculeaza_daune(daune);
    }

    @Override
    public String toString() {
        return "Schelete{" +
                "viata=" + viata +
                ", daune=" + daune +
                ", rezistenta=" + rezistenta +
                '}';
    }
}

package Inamici;

import Constants.Constante;
import Jucator.Jucator;

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
        System.out.println(Constante.SCH_DMG_1 + x + Constante.DMG);
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

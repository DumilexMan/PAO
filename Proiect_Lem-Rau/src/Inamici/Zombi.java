package Inamici;

import Constants.Constante;

public class Zombi extends Inamic {


//5 viata
//1 daune
//2 rezistenta

    public Zombi() {
        super(5, 1, 2);
    }

    public Zombi(int viata, int daune, int rezistenta) {
        super(viata, daune, rezistenta);
    }


    @Override
    public int getViata() {
        return super.getViata();
    }

    @Override
    public int getDaune() {
        return super.getDaune();
    }

    @Override
    public int getRezistenta() {
        return super.getRezistenta();
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
        System.out.println(Constante.ZMB_DMG_1 + x + Constante.DMG);
    }

    @Override
    public String toString() {
        return "Zombi{" +
                "viata=" + viata +
                ", daune=" + daune +
                ", rezistenta=" + rezistenta +
                '}';
    }
}

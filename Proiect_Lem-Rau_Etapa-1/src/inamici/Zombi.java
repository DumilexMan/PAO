package inamici;

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
        int rezistenta = getRezistenta();
        int viata = getViata();
        daune = daune - rezistenta;
        if (daune < 0)
            daune = 0;
        viata = viata - daune;
        if (viata < 0)
            viata = 0;
        setViata(viata);
        System.out.println(Constante.ZMB_DMG_1 + daune + Constante.DMG);
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

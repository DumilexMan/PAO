package jucator;

import Constants.Constante;
import inamici.Inamic;
import obiecte.Arma;
import obiecte.Armura;
import obiecte.Consumabil;

import java.io.*;
import java.util.ArrayList;

import obiecte.*;


public class Jucator {
    private int viata;
    private int daune;
    private int rezistenta;

    private ArrayList<Arma> arme;
    private ArrayList<Armura> armuri;
    private ArrayList<Consumabil> consumabile;


    private void scrieInFisierCSV() throws IOException {
        String filePath = "jucatori.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(viata + "," + daune + "," + rezistenta);
        printWriter.close();
        System.out.println("Jucator creat!");
    }

    private void citesteFisierCSV() throws IOException {
        String filePath = "jucatori.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public Jucator() {
        this.viata = 5;
        this.daune = 3;
        this.rezistenta = 3;
        this.arme = new ArrayList<Arma>();
        this.armuri = new ArrayList<Armura>();
        this.consumabile = new ArrayList<Consumabil>();

        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public Jucator(int viata, int daune, int rezistenta) {
        this.viata = viata;
        this.daune = daune;
        this.rezistenta = rezistenta;
        this.arme = new ArrayList<Arma>();
        this.armuri = new ArrayList<Armura>();
        this.consumabile = new ArrayList<Consumabil>();

        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public Jucator(int viata, int daune, int rezistenta, ArrayList<Arma> arme, ArrayList<Armura> armuri, ArrayList<Consumabil> consumabile) {
        this.viata = viata;
        this.daune = daune;
        this.rezistenta = rezistenta;
        this.arme = arme;
        this.armuri = armuri;
        this.consumabile = consumabile;

        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public void afiseazaTotiJucatorii(){
        try {
            citesteFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea din fișierul CSV: " + e.getMessage());
        }
    }


    public int getViata() {
        return viata;
    }

    public int getDaune() {
        return daune;
    }

    public int getRezistenta() {
        return rezistenta;
    }

    public void setViata(int viata) {
        this.viata = viata;
    }

    public void setDaune(int daune) {
        this.daune = daune;
    }

    public void setRezistenta(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    private void ech_Armura(Armura armura) {
        this.rezistenta += armura.getRezistenta();
    }

    private void ech_Arma(Arma arma) {
        this.daune += arma.getDaune();
    }

    private void fol_Obiect(Consumabil consumabil) {
        this.viata += consumabil.getPuncte();
    }

    public void echipeaza_Armura(int valoare) {
        try {
            for (Armura armura : armuri) {
                if (armura.getRezistenta() == valoare) {
                    ech_Armura(armura);
                    armuri.remove(armura);
                    return;
                }
            }
            throw new IndexOutOfBoundsException(Constante.ARMURA_REZ + valoare);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void echipeaza_Arma(int valoare) {
        try {
            for (Arma arma : arme) {
                if (arma.getDaune() == valoare) {
                    ech_Arma(arma);
                    arme.remove(arma);
                    return;
                }
            }
            throw new IndexOutOfBoundsException(Constante.ARMA_DAU + valoare);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void foloseste_Obiect(int valoare) {
        try {
            for (Consumabil consumabil : consumabile) {
                if (consumabil.getPuncte() == valoare) {
                    fol_Obiect(consumabil);
                    consumabile.remove(consumabil);
                    return;
                }
            }
            throw new IndexOutOfBoundsException(Constante.CONS_EMPTY + valoare);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }


    public void ia_obiect(Obiect obiect) {
        if (obiect instanceof Arma) {
            this.arme.add((Arma) obiect);
        } else if (obiect instanceof Armura) {
            this.armuri.add((Armura) obiect);
        } else if (obiect instanceof Consumabil) {
            this.consumabile.add((Consumabil) obiect);
        }
    }

    public void inspecteazaObiecte() {
        System.out.println("Obiecte din lista de arme: ");
        for (Arma arma : arme) {
            System.out.println("- " + arma.getDaune());
        }

        System.out.println("Obiecte din lista de armuri: ");
        for (Armura armura : armuri) {
            System.out.println("- " + armura.getRezistenta());
        }

        System.out.println("Obiecte din lista de consumabile: ");
        for (Consumabil consumabil : consumabile) {
            System.out.println("- " + consumabil.getPuncte());
        }
    }

    public void inspecteazaObiecteCSV() throws IOException {
        Arma arma = new Arma();
        arma.citesteFisierCSV();
        Armura armura = new Armura();
        armura.citesteFisierCSV();
        Consumabil consumabil = new Consumabil();
        consumabil.citesteFisierCSV();
    }

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
        System.out.println(Constante.JCT_DMG_1 + x + Constante.DMG);
    }

    public void provoaca_daune(Inamic inamic) {
        int dmg = getDaune();
        inamic.calculeaza_daune(dmg);
    }

    public void arunca_obiect(int valoare) {
        for (Consumabil consumabil : consumabile) {
            if (consumabil.getPuncte() == valoare) {
                consumabile.remove(consumabil);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Jucator{" +
                "viata=" + viata +
                ", daune=" + daune +
                ", rezistenta=" + rezistenta +
                '}';
    }


}

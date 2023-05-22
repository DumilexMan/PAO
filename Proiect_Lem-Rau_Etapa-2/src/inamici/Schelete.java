package inamici;

import Constants.Constante;
import jucator.Jucator;

import java.io.*;

public class Schelete extends Inamic {


    //5 viata
//2 daune
//1 rezistenta
    public Schelete() {
        super(5, 2, 1);
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }


    public Schelete(int viata, int daune, int rezistenta) {
        super(viata, daune, rezistenta);
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    @Override
    protected void scrieInFisierCSV() throws IOException{
        String filePath = "schelete.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(viata + "," + daune + "," + rezistenta);
        printWriter.close();
        System.out.println("Schelete creat!");
    }

    @Override
    protected void citesteFisierCSV() throws IOException {
        String filePath = "schelete.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public void afiseazaTotiScheletii(){
        try {
            citesteFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea din fișierul CSV: " + e.getMessage());
        }
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

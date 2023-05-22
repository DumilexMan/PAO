package inamici;
import jucator.Jucator;

import java.io.*;

public abstract class Inamic {
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

    protected void scrieInFisierCSV() throws IOException {
        String filePath = "inamic.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(viata + "," + daune + "," + rezistenta);
        printWriter.close();
        System.out.println("Inamic creat!");
    }

    protected void citesteFisierCSV() throws IOException{
        String filePath = "inamici.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public Inamic(int viata, int daune, int rezistenta) {
        this.viata = viata;
        this.daune = daune;
        this.rezistenta = rezistenta;

        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
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

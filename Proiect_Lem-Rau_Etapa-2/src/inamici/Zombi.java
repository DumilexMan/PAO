package inamici;

import Constants.Constante;

import java.io.*;

public class Zombi extends Inamic {


//5 viata
//1 daune
//2 rezistenta

    public Zombi() {
        super(5, 1, 2);
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public Zombi(int viata, int daune, int rezistenta) {
        super(viata, daune, rezistenta);
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }


    @Override
    protected void scrieInFisierCSV() throws IOException{
        String filePath = "zombi.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(viata + "," + daune + "," + rezistenta);
        printWriter.close();
        System.out.println("Zombi creat!");
    }

    @Override
    protected void citesteFisierCSV() throws IOException {
        String filePath = "zombi.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public void afiseazaTotiZombi(){
        try {
            citesteFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea din fișierul CSV: " + e.getMessage());
        }
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

package obiecte;

import java.io.*;

public class Arma extends Obiect{
    private int daune;

    public Arma(){}
    public Arma(int daune) {
        this.daune = daune;
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public void setDaune(int daune) {
        this.daune = daune;
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public int getDaune() {
        return daune;
    }

    @Override
    protected void scrieInFisierCSV() throws IOException {
        String filePath = "arma.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(daune);
        printWriter.close();
        System.out.println("Arma creata!");
    }

    @Override
    public void citesteFisierCSV() throws IOException{
        String filePath = "arma.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

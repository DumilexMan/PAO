package obiecte;

import java.io.*;

public class Consumabil extends Obiect{
//va vindeca jucatorul
    private int puncte;

    public Consumabil(){}
    public Consumabil(int puncte) {
        this.puncte = puncte;
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public int getPuncte() {
        return puncte;
    }

    @Override
    protected void scrieInFisierCSV() throws IOException {
        String filePath = "consumabil.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(puncte);
        printWriter.close();
        System.out.println("Consumabil creat!");
    }

    @Override
    public void citesteFisierCSV() throws IOException{
        String filePath = "consumabil.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

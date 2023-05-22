package obiecte;

import java.io.*;

public class Armura extends Obiect{
    private int rezistenta;

    public Armura(){}
    public Armura(int rezistenta) {
        this.rezistenta = rezistenta;
        try {
            scrieInFisierCSV();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public void setRezistenta(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    public int getRezistenta() {
        return rezistenta;
    }

    @Override
    protected void scrieInFisierCSV() throws IOException {
        String filePath = "armura.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(rezistenta);
        printWriter.close();
        System.out.println("Armura creata!");
    }

    @Override
    public void citesteFisierCSV() throws IOException{
        String filePath = "armura.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

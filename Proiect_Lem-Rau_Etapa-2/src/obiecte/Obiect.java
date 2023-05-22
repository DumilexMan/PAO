package obiecte;

import java.io.*;

public abstract class Obiect {
    protected int valoare;

    protected void scrieInFisierCSV() throws IOException {
        String filePath = "obiect.csv";
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(valoare);
        printWriter.close();
        System.out.println("Inamic creat!");
    }

    protected void citesteFisierCSV() throws IOException{
        String filePath = "obiect.csv";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

}

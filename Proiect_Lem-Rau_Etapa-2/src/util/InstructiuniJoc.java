package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructiuniJoc {

    List<String> filePaths = new ArrayList<>();

    public InstructiuniJoc() {

    }


    public void joc_nou() {
        filePaths.add("jucatori.csv");
        filePaths.add("schelete.csv");
        filePaths.add("zombi.csv");
        filePaths.add("arma.csv");
        filePaths.add("armura.csv");
        filePaths.add("consumabil.csv");
        for(String filePath : filePaths) {
            try {
                FileWriter fileWriter = new FileWriter(filePath, false);

                fileWriter.close();

                System.out.println("Conținutul fișierului CSV a fost șters.");

            } catch (IOException e) {
                System.out.println("A apărut o eroare la ștergerea conținutului fișierului CSV: " + e.getMessage());
            }
        }
    }
}

package inamici;

import jucator.Jucator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface InterfataInamic {
    void setViata(int viata);
    void setDaune(int daune);
    void setRezistenta(int rezistenta);
    int getViata();
    int getDaune();
    int getRezistenta();
    void provoaca_daune(Jucator jucator);
    void calculeaza_daune(int daune);
    void scrieInFisierCSV();

    void citesteFisierCSV();
}

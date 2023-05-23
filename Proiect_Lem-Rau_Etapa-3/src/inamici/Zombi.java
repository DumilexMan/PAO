package inamici;

import Constants.Constante;

import java.io.*;
import java.sql.*;

public class Zombi extends Inamic {


//5 viata
//1 daune
//2 rezistenta

    public Zombi() {
        super(5, 1, 2);
        try {
            scrieBazaDeDate();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public Zombi(int viata, int daune, int rezistenta) {
        super(viata, daune, rezistenta);
        try {
            scrieBazaDeDate();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }


    protected void scrieBazaDeDate() throws IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Proiect";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sqlQuery = "INSERT INTO zombi VALUES (?, ?, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, String.valueOf(viata));
            preparedStatement.setString(2, String.valueOf(daune));
            preparedStatement.setString(3, String.valueOf(rezistenta));

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " rânduri au fost inserate în tabel.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driverul MySQL JDBC nu a fost găsit.");
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la conectarea la baza de date: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("A apărut o eroare la închiderea obiectelor JDBC: " + e.getMessage());
            }
        }
    }

    @Override
    public void citesteBazaDeDate(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            String url = "jdbc:mysql://localhost:3306/Proiect";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM schelete";
            resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                int viata = resultSet.getInt("Viata");
                int daune = resultSet.getInt("Daune");
                int rezistenta = resultSet.getInt("Rezistenta");

                System.out.println("Viata: " + viata + ", Daune: " + daune + ", Rezistenta: " + rezistenta);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driverul MySQL JDBC nu a fost găsit.");
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la conectarea la baza de date: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("A apărut o eroare la închiderea obiectelor JDBC: " + e.getMessage());
            }
        }
    }

    public void afiseazaTotiZombi(){
            citesteBazaDeDate();
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

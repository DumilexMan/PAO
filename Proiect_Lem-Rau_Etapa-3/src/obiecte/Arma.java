package obiecte;

import java.io.*;
import java.sql.*;

public class Arma extends Obiect{
    private int daune;

    public Arma(){}
    public Arma(int daune) {
        this.daune = daune;
        try {
            scrieBazaDeDate();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public void setDaune(int daune) {
        this.daune = daune;
        try {
            scrieBazaDeDate();
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }

    public int getDaune() {
        return daune;
    }
    @Override
    protected void scrieBazaDeDate() throws IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Proiect";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sqlQuery = "INSERT INTO arma VALUES (1, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, String.valueOf(daune));

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

            String sqlQuery = "SELECT * FROM arma";
            resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                int valoare = resultSet.getInt("Valoare");
                int daune = resultSet.getInt("Daune");

                System.out.println("Valoare: " + valoare + ", Daune: " + daune);
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
}

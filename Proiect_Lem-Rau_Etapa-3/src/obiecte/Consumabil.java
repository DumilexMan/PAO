package obiecte;

import java.io.*;
import java.sql.*;

public class Consumabil extends Obiect{
//va vindeca jucatorul
    private int puncte;

    public Consumabil(){}
    public Consumabil(int puncte) {
        this.puncte = puncte;
        try {
            scrieBazaDeDate();
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
    protected void scrieBazaDeDate() throws IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Proiect";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sqlQuery = "INSERT INTO consumabil VALUES (1, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, String.valueOf(puncte));

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

            String sqlQuery = "SELECT * FROM consumabil";
            resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                int valoare = resultSet.getInt("Valoare");
                int puncte = resultSet.getInt("Puncte");

                System.out.println("Valoare: " + valoare + ", Puncte: " + puncte);
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

package obiecte;

import java.io.*;
import java.sql.*;

public class Armura extends Obiect{
    private int rezistenta;

    public Armura(){}
    public Armura(int rezistenta) {
        this.rezistenta = rezistenta;
        try {
            scrieBazaDeDate();
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
    protected void scrieBazaDeDate() throws IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Proiect";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sqlQuery = "INSERT INTO armura VALUES (1, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, String.valueOf(rezistenta));

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

            String sqlQuery = "SELECT * FROM armura";
            resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()) {
                int valoare = resultSet.getInt("Valoare");
                int rezistenta = resultSet.getInt("Rezistenta");

                System.out.println("Valoare: " + valoare + ", Rezistenta: " + rezistenta);
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

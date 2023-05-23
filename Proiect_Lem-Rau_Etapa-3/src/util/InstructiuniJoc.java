package util;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructiuniJoc {

    List<String> tables = new ArrayList<>();

    public InstructiuniJoc() {

    }


    public void joc_nou() {
        tables.add("armura");
        tables.add("arma");
        tables.add("consumabil");
        tables.add("zombi");
        tables.add("schelete");
        tables.add("jucator");
        for(String table : tables) {

            Connection connection = null;
            Statement statement = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/Proiect";
                String username = "root";
                String password = "";

                connection = DriverManager.getConnection(url, username, password);

                statement = connection.createStatement();

                String sqlQuery = "DELETE FROM " + table;

                int rowsAffected = statement.executeUpdate(sqlQuery);

                // System.out.println(rowsAffected + " rânduri au fost inserate în tabel.");

            } catch (ClassNotFoundException e) {
                System.out.println("Driverul MySQL JDBC nu a fost găsit.");
            } catch (SQLException e) {
                System.out.println("A apărut o eroare la conectarea la baza de date: " + e.getMessage());
            } finally {
                // Pasul 5: Închideți obiectele Statement și Connection
                try {
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
}

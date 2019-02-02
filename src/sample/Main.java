package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private ArrayList<String> connections = new ArrayList<>();

    try {
        // Driver class für MySql-Datenbank laden
        Class.forName("com.mysql.jdbc.Driver");

        // Verbindung zur Datenbank herstellen
        String connectionUrl = "jdbc:mysql://localhost/fahrplanDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

        // Sql Befehl aufbauen und ausführen
        Statement stmt = connection.createStatement();
        ResultSet entries = stmt.executeQuery("SELECT * FROM fahrplan");

        // alle Datensätze aus dem ResultSet auslesen und
        // (Schritt 1) in einer ArrayList ablegen
        while (entries.next()) {
            connections.add(entries.getString("text"));
        }

        // alle verwendeten Objekte schliessen
        entries.close();
        stmt.close();
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (
    SQLException e) {
        e.printStackTrace();
    }

}


    public static void main(String[] args) {
        launch(args);
    }
}

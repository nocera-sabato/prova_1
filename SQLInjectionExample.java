import java.sql.*;

public class SQLInjectionExample {
  public static void main(String[] args) {
    try {
      // Carica il driver del database
      Class.forName("com.mysql.jdbc.Driver");

      // Connessione al database
      Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test_db", "root", "password"
      );

      // Query di esempio con input dell'utente
      String userInput = "1 OR 1=1";
      String query = "SELECT * FROM users WHERE id = " + userInput;

      // Creazione della statement
      Statement statement = connection.createStatement();

      // Esecuzione della query
      ResultSet result = statement.executeQuery(query);

      // Stampa i risultati
      while (result.next()) {
        System.out.println(result.getString("username"));
      }

      // Chiusura della connessione
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

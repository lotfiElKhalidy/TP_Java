import junit.framework.TestCase;
import java.sql.*;

public class TestSQLManager extends TestCase {
    public void testDatabaseConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
            assertNotNull(connection);
        } catch (SQLException e) {
            System.out.println("SQL exception ... " + e.getMessage());
        }
    }
}

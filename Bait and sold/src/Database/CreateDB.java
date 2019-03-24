package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS highscore");

            statement.executeUpdate("CREATE TABLE highscore (id INTEGER, first_name TEXT, last_name TEXT, major TEXT, cgpa FLOAT)");

            statement.executeUpdate("INSERT INTO highscore VALUES(6001234, 'Ted', 'Henry', 'Computer Science', 3.67)");
            statement.executeUpdate("INSERT INTO highscore VALUES(6001235, 'John', 'Smith', 'Chemistry', 3.78)");
            statement.executeUpdate("INSERT INTO highscore VALUES(6001236, 'Jane', 'Johnson', 'Physcs', 3.89)");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            try{
                if(connection != null)
                    connection.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}

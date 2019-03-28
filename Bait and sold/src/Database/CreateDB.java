package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS highscore");
            statement.executeUpdate("CREATE TABLE highscore (player_name TEXT, score INTEGER )");
            //we can utilize this to reset the scoreboard

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

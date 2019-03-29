package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB { //This is the class that will set up database and reset it

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC"); //remember that you should install
        //lib/sqlite-jdbc-3.23.1.jar before using database
        Connection connection = null; //You need connection to database
        //unlike file, database is like another program
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db"); //choose that database
            //make sure that the try/catch look the same as mine to prevent bugs

            Statement statement = connection.createStatement(); //this is the command line
            //You think of programming a program to use command line for you
            statement.setQueryTimeout(30); //Just set up for safety

            statement.executeUpdate("DROP TABLE IF EXISTS highscore"); //This means
            //Drop that table if it is existed
            statement.executeUpdate("CREATE TABLE highscore (player_name TEXT, score INTEGER )");
            //we can utilize this to reset the scoreboard, since we create new table

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

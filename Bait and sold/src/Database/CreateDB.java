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
            connection = DriverManager.getConnection("jdbc:sqlite:muicspace.db");

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

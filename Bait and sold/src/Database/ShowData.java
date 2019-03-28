package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowData {
    private String name;
    private int money =0;
    private String nameandscore;
    private String nameandscoredefault;
    private List<String> ranking = new ArrayList();

    public String show(int rank) throws ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:highscores.db");
            name = "None"; //sometimes the table has no data
            money = 0;
            nameandscoredefault = String.format("%s and %d",name,money);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("SELECT player_name, score FROM highscore ORDER BY score DESC");
            //choose the table where we store highscore and rearrange it before taking out data

            ResultSet rs = statement.executeQuery("SELECT player_name, score FROM highscore ORDER BY score DESC");
            //take out the set of data in descending order by score

            while(rs.next())
            {
            name = rs.getString("player_name");
            money = rs.getInt("score");
            nameandscore = name +"#"+ money;
            ranking.add(nameandscore);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try
            {
                if (connection != null)
                    connection.close();

            }
            catch (SQLException e) {System.err.println(e);}
        }
        if(ranking.size()<3)
        { //seldom that the database has nothing inside or less than three
            for(int i =0 ; i < 5-ranking.size(); i++){ranking.add(nameandscoredefault);} //fill that ranking with default :P
        }
        return ranking.get(rank-1);
    }
    public String showname(int rank) throws ClassNotFoundException
    {
       String[] a = show(rank).split("#");
       return a[0];
    }
    public String showmoney(int rank) throws ClassNotFoundException
    {
        String[] a = show(rank).split("#");
        return a[1];
    }
}


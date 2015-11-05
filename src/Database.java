import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database
{

    @SuppressWarnings("null")
    public void validateUserLogin (String username, String password) throws SQLException
    {
        Connection connection = null;
        ResultSet resultset = null;
        Statement statement = null;

        //String fullname = "";

        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/";
        String USER = "root";
        String PASS = "thisisapassword";
        String QUERY = "SELECT * FROM database.users WHERE username = '"+
            username+"'          AND password = '"+password+"' ";
        
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASS);
            resultset = statement.executeQuery(QUERY);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (resultset != null)
                resultset.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }
}
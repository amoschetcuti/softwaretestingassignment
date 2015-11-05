import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChatProvider
{
	String provider_name = "Test Provider";
	List<User> users = new ArrayList<>();
	int maxMessageLength = 100;
	
	public int chatProvider(String username, String password)
	{
		int num = 0;
		
		String sql = "select * from database.users where username='" + username + "'";
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                    "root", "thisisapassword");
            Statement s = conn.createStatement();

            java.sql.ResultSet rs = s.executeQuery(sql);
            String un = null;
            String pw = null;
            int id = 0;

            while (rs.next())
            {
                un = rs.getString("username");
                pw = rs.getString("password");
                id = rs.getInt("id");
            }
          
            try
            {
	            if (un.equals(username))
	            {
	            	if(pw.equals(password))            		
	            	{
	            		User user = new User();
	            		user.setId(id);
	            		user.setUsername(username);
	            		user.setPassword(password);
	            		users.add(user);
	            		
	            		num = 1;
	            	}
	            	else
	            	{
	            		num = 2;
	            	}
	            }
            }            
            catch(NullPointerException e)
            {
            	e.printStackTrace();
            	num = 3;
            }
        }        
        catch (SQLException e)
        {
            //e.printStackTrace();
        }
        
        return num;
	}
	
	public int getMaxMessageLength()
	{
		return maxMessageLength;
	}
		
	public String getName()
	{
		return provider_name;
	}
	
	public int sendMessageTo(String friendId, String msg)
	{
		return 0;
	}
	
	public int onMessageReceived(String text)
	{
		return 0;
	}
}

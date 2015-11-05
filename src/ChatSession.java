import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatSession
{
	public List<ChatMessage> receivedMessages = new ArrayList<>();
	public String[] censoredWords = {"Fudge", "Yikes", "Pudding"}; 
	private boolean parentalLock = false;
	public ChatProvider provider;
	
	public ChatSession(ChatProvider provider)
	{
		this.provider = provider;
		System.out.println("You have connected to "+ provider.getName());
	}
	
	public int initSession(String username, String password, String friendID)
	{
		int num = 0;
		
		String sql = "select * from database.users where a_username='" + username + "'";
		String sql2 = "select * from database.users where a_username='" + friendID + "'";
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                    "root", "thisisapassword");
            Statement s = conn.createStatement();

            java.sql.ResultSet rs = s.executeQuery(sql);
            String un = null;
            String pw = null;

            java.sql.ResultSet rs2 = s.executeQuery(sql2);
            String fi = null;
            
            while (rs.next())
            {
                un = rs.getString("a_username");
                pw = rs.getString("a_password");
            }
            
            while(rs2.next())
            {
            	fi = rs2.getString("a_username");
            }
          
            try
            {
	            if (un.equals(username))
	            {
	            	if(pw.equals(password))            		
	            	{
	            		if(fi.equals(friendID))
	            		{
	            			num = 0;
	            		}
	            		else
	            		{
	            			num = 3;
	            		}
	            	}
	            	else
	            	{
	            		num = 1;
	            	}
	            }
            }            
            catch(NullPointerException e)
            {
            	//e.printStackTrace();
            	num = 1;
            }
        }        
        catch (SQLException e)
        {
            //e.printStackTrace();
        }
        
        return num;
	}
	
	public int sendMessage(String text)
	{
		int num = 0;
//		if(ChatProvider.time() >= Thread.sleep(5000))
//		{
//			return 1;
//		}
		if(text.length() > provider.getMaxMessageLength())
		{
			num = 2;
		}
		if(text.length() == 0)
		{
			num = 3;
		}
		if(parentalLock == true)
		{
			for(String word : censoredWords)
			{
				if(text.contains(word))
				{
					num = 4;
				}
			}			
		}		
		//send message
		
		return num;
	}
	
	public void onMessageReceived(String text)
	{
		Date date = new Date();
		
		ChatMessage message = new ChatMessage(date, text);
		
		receivedMessages.add(message);
	}
}

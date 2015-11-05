import java.util.*;

public class Test
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String username = sc.next();
		System.out.print("Enter password: ");
		String password = sc.next();
		
		ChatProvider provider = new ChatProvider();
		
		if(provider.chatProvider(username, password) == 1)
		{
			System.out.print("Enter username for service A: ");
			String a_username = sc.next();
			System.out.print("Enter password for service A: ");
			String a_password = sc.next();
			System.out.print("Enter username of friend: ");
			String friendID = sc.next();
			
			ChatSession session = new ChatSession(provider);
			
			if(session.initSession(a_username, a_password, friendID) == 0)
			{
				System.out.print("Enter a message: ");
				String msg = sc.next();
				
				if(session.sendMessage(msg) == 0)
				{
					System.out.println("Message sent!");
				}
				if(session.sendMessage(msg) == 2)
				{
					System.out.println("Message too long!");
				}
				if(session.sendMessage(msg) == 3)
				{
					System.out.println("Message too short!");
				}
				if(session.sendMessage(msg) == 4)
				{
					System.out.println("Message contained bad words!");
				}
			}		
			if(session.initSession(a_username, a_password, friendID) == 1)
			{
				System.out.println("Invalid username or password!");
			}		
			if(session.initSession(a_username, a_password, friendID) == 3)
			{
				System.out.println("Invalid friend ID!");
			}
		}
		if(provider.chatProvider(username, password) == 2)
        {
    		System.out.println("Invalid password!");        	
        }
        if (provider.chatProvider(username, password) == 3)
        {
        	System.out.println("Invalid username!");       	
        }
	}

}

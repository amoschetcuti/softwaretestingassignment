import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatSession
{
	public List<ChatMessage> receivedMessages = new ArrayList<>();
	private boolean parentalLock = false;
	
	public ChatSession(ChatProvider provider)
	{
		System.out.println("You have connected to "+ provider.getName());
	}
	
	public int initSession(String username, String password, String friendID)
	{
		
		
		return 0;
	}
	
	public int sendMessage(String text)
	{
		return 0;
	}
	
	public void onMessageReceived(String text)
	{
		Date date = new Date();
		
		ChatMessage message = new ChatMessage(date, text);
		
		receivedMessages.add(message);
	}
}

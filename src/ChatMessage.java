import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage
{
	String timestamp;
	String content;
	
	public ChatMessage(Date date, String message)
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy-HH:mm:ss");
		
		this.timestamp = df.format(date);
		this.content = message;
	}
}

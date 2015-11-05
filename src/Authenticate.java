import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Authenticate extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public Authenticate()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    	
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        PrintWriter pww = response.getWriter();
        
        ChatProvider chatProvider = new ChatProvider();
        
        if(chatProvider.chatProvider(username, password) == 1)
        {
		    // use this or create request dispatcher
			response.setContentType("text/html");
			pww.write("<h1>Welcome, " + username + "</h1>");
        }
        else if(chatProvider.chatProvider(username, password) == 2)
        {
    		pww.write("invalid password\n");        	
        }
        else if(chatProvider.chatProvider(username, password) == 3)
        {
        	pww.write("invalid username\n");       	
        }
    }
}
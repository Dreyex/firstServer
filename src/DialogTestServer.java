import java.io.*;

//Test Dialoge mit Client

public class DialogTestServer extends BaseServer
{
    //specific behaviour
    @Override
    public void schreibeAntwort(PrintWriter pencil)
    {
        
        boolean continues = true; //standardly continous
        while (continues)
        {
            //check command by client
            String[] readLine = höreFrageArray();
            System.out.println("Command by client: " + readLine[0]);
            if(readLine[0].equals("logout"))
            {
                //client gave the command to logout
                continues = false;
            }
        }
    }
    
    //consturctor
    DialogTestServer(int port) 
    {
        super(port);
    }
    
}

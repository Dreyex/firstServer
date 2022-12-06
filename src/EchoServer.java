import java.io.*;

// LS 10 - Vererbung testen
// M.F, 06-12-2022
public class EchoServer extends BaseServer 
{
    //specific Attributes
    @Override
    public void schreibeAntwort(PrintWriter pencil)
    {
        pencil.println();
        pencil.println("Sie haben geschrieben: ");
        pencil.println(höreFrage());
        pencil.flush();
        
    }

    //specific Behaviour


    //Constructors
    EchoServer(int port) 
    {
        super(port);
    }
    

}

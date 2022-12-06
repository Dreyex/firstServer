import java.io.*;
import java.util.*;

// LS 10 Teste die Vererbung
//M.F, 06-11-2022 

public class HelloServer extends BaseServer 
{
    //Specific attributes
    String[] helo = new String[] {"Hello (Englisch)", "Namaste (Hindi)", "Bonjour (Franzoesisch)", "Privet (Russisch)", "Konnichiwa (Japanisch)", "Hola (Spanisch", "hei (Norwegisch)", "hej (Schwedisch"};


    //Specific Behaviour
    //Overriding the method oft the BaseServer
    @Override 
    public void schreibeAntwort(PrintWriter pencil)
    {
        Random rand = new Random();
        int i = rand.nextInt(helo.length);
        pencil.print("--> " + helo[i]);
        pencil.flush();
    }

    //Constructor
    HelloServer(int port) 
    {
        super(port);
    }

    //methods
    
}

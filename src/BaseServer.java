import java.net.*;
import java.io.*;

//BaseServer acts like a "Job" for a process
public class BaseServer implements Runnable
{
    //Attributes -----------------------------
    //damit ist es jeweils (mindestens) eine Aggregation
    //private ... Stichtwort Datenkapselung
    private ServerSocket serverDose;
    private BufferedReader vomClient; // die Ohren zum Hören
    private PrintWriter zumClient;    // der Bleistift zum Schreiben  
    private int port;  

    //Constuctor -------------------------------

    BaseServer (int port) 
    { // ########################
        this.port = port;
        try 
        {
            serverDose = new ServerSocket(port);
        } 
        catch (IOException e) 
        {
            // "Normale Fehlerausgabe"
            // e.printStackTrace();
            System.out.println("Server konnte am Port " + port + " nicht eingerichtet werden.");
        }
        System.out.println("Server am Port " + port + " eingerichtet");
        //System.out.println("Server wartet am Port " + port + " auf Anfragen ^u^");

    }

    //Methods ----------------------------------

    //Method that is started over the process
    @Override
    public void run() 
    {
        permanenteVerbindungMitClient();
    }

    void verbindungMitClient() 
    { // ########################
        try 
        {
            // warte auf Client-Anfragen... und warte... und warte...
            System.out.println("Server wartet am Port " + port + " auf Anfragen ^u^");
            Socket clientDose = serverDose.accept(); //Methode accept ist blockierend
            System.out.println("Verbindung mit Client: " + clientDose.getInetAddress().getHostAddress());     
            // vomClient = ... -> die Ohren
            vomClient = new BufferedReader(new InputStreamReader(clientDose.getInputStream()));

            // zumClient = ... -> der Bleistift
            zumClient = new PrintWriter(clientDose.getOutputStream()); 
            zumClient.print(">> ");
            zumClient.flush();

            // schreibe Info zum Client
            schreibeAntwort(zumClient);

            // Verbindung schließen
            clientDose.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Fehler in der Kommunikation mit dem Client");
            //e.printStackTrace();
        }
    }

    void permanenteVerbindungMitClient() 
    { // ########################
        while(true) 
        {
            verbindungMitClient();
        }
    }

    /**
    * Wird durch die einzelnen Server überschrieben - der "eigentliche" Job. <br/>
    * Beachte: als abstrakte M. hier nicht möglich, da in verbindungMitClient() benutzt.
    * @param zumClient Der Bleistift des BasisServers ist gekapselt (private)
    */
    public void schreibeAntwort(PrintWriter zumClient) 
    {
        zumClient.println();
        zumClient.print("BaseServer--> ");
        zumClient.flush();
    }

    /**
    * Unterschiedliches Verhalten beim Schreiben, aber gleiches
    * Verhalten beim Hören -> deshalb beim BasisServer implementiert
    * @return Die vom Client gesendete Zeile als String
    */
    public String höreFrage() {
    try 
    {    // zeilenweises Schreiben/Lesen, wie es zB von telnet praktiziertd
        return vomClient.readLine();
    } 
    catch (Exception ex) 
    {            
        System.out.println("Sorry - Ohren verstopft... Kann vom Client nicht lesen");
        return ""; // Rückgabewert bei verstopften Ohren
    }
    }

    /**
    * Die vom Client gesendete Zeile wird an den Leerzeichen gesplittet (getrennt)
    * @return Die vom Client gesendete Zeile als Array mit Strings
    */
    public String [] höreFrageArray( )
    {                                        // z.B. 'zeige test.txt' oder 'nutze notenDB':
        return höreFrage().split(" "); // der Befehl ist der Text bis zum Leerzeichen
    }
        
    
}

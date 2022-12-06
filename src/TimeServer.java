import java.io.PrintWriter;
import java.time.ZonedDateTime;

public class TimeServer extends BaseServer
{
    //specific attributes
    
    //specific Behaviour
    @Override
    public void schreibeAntwort(PrintWriter zumClient)
    {
        zumClient.println("--> Datum und Uhrzeit: ");
        zumClient.println(ZonedDateTime.now().getHour() + ":"+ ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond() + " " + ZonedDateTime.now().getYear() + "-" + ZonedDateTime.now().getMonthValue() + "-" + ZonedDateTime.now().getDayOfMonth() + " " + ZonedDateTime.now().getZone());
        zumClient.println();
        zumClient.flush();
    }

    //constructor
    TimeServer(int port) 
    {
        super(port);
    }

    
    
}

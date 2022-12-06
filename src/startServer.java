public class StartServer {
    
    public static void main (String args[])
    {
        //umständlich
        //BaseServer server = new BaseServer(3366);
        //server.permanenteVerbindungMitClient();

        //new BaseServer(3366).permanenteVerbindungMitClient();
        //new HelloServer(3367).permanenteVerbindungMitClient();
        //new EchoServer(3368).permanenteVerbindungMitClient();
        //new TimeServer(3369).permanenteVerbindungMitClient();
        new DialogTestServer(3370).permanenteVerbindungMitClient();
    }

}

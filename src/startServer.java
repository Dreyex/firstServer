public class StartServer {
    
    public static void main (String args[])
    {
        //umständlich
        //BaseServer server = new BaseServer(3366);
        //server.permanenteVerbindungMitClient();

        /*
        new BaseServer(3366).permanenteVerbindungMitClient();
        new HelloServer(3367).permanenteVerbindungMitClient();
        new EchoServer(3368).permanenteVerbindungMitClient();
        new TimeServer(3369).permanenteVerbindungMitClient();
        new TextFileServer(3370).permanenteVerbindungMitClient();
        */

        //parallel processing
        //Thread ... the process that is started with start()
        //HelloServer is the job to be executed
        Thread rofl = new Thread(new HelloServer(3367));
        rofl.start();

        Thread rufl = new Thread(new EchoServer(3368));
        rufl.start();

        Thread rafl = new Thread(new TimeServer(3369));
        rafl.start();

        Thread refl = new Thread(new TextFileServer(3370));
        refl.start();
    }

}

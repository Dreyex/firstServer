import java.io.*;

//Test Dialoge mit Client

public class TextFileServer extends BaseServer
{
    //specific attributes
    String cmd = "The following commands are accepted: logout, dir, cd, read";
    PrintWriter pencil; //from BaseServer over method schreibeAntwort
    String directoryName = "c:\\lambda";
    
    //specific behaviour
    @Override
    public void schreibeAntwort(PrintWriter pencil)
    {
        this.pencil = pencil;      //this.pencil - Eigenschaft der Klasse und nur pencil ist der übergebene Parameter
        boolean continues = true; //standardly continous
        while (continues)
        {
            try
            {
                //check command by client
                String[] readLine = höreFrageArray();
                System.out.println("Command by client: " + readLine[0]);
                //case distinction of commands
                if(readLine[0].equals("logout"))
                {
                    //client gave the command to logout
                    continues = false;
                }
                else if (readLine[0].equals("dir"))
                {
                    showDirectoryContent();
                }
                else if (readLine[0].equals("cd"))
                {
                    directoryName = readLine[1];
                }
                else if (readLine[0].equals("read"))
                {
                    readFile(readLine[1]);
                }
                else
                {
                    error();
                }
            }
            catch (Exception e)
            {
                error();
                continues = true;
            }
            
        }
    }

    private void readFile(String fileName) 
    {
        if(fileName.endsWith(".txt"))
        {
            try 
            {
                BufferedReader reader = new BufferedReader(new FileReader(directoryName + "\\" + fileName));
                String line = "";
                while ((line = reader.readLine())!= null)
                {
                    pencil.println(line);
                }
                pencil.println();
                pencil.flush();
                reader.close();
            } 
            catch (Exception e) 
            {
                pencil.println("File not found: " + fileName);
                pencil.flush();
            } 
        }
        else
        {
            pencil.println(fileName + "is not a txt file");
            pencil.println();
            pencil.flush();
        }
        
    }

    private void showDirectoryContent() 
    {
        File dir = new File(directoryName);
        if(dir.isDirectory())
        {
            String[] content = dir.list();
            for(int i=0; i<content.length; i++)
            {
                pencil.println(content[i]);
                
            }
            pencil.println();
            pencil.flush();
        }
        else
        {
            pencil.println("Given path is not a directory");
            pencil.println("A full path is required");
            pencil.flush();
        }
    }

    private void error()
    {
        System.out.println("uff ERROR - Command incorrect");
        pencil.println("ERROR: Command not found");
        pencil.println(cmd);
        pencil.flush();
    }
    
    //consturctor
    TextFileServer(int port) 
    {
        super(port);
    }
    
}

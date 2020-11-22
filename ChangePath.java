import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ChangePath{
   
   //Receive the path, oldString and the new One 
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }


    //Returns the current text on the file httpd.conf
    public static String findText(int lineNumberSearch) {
        
        String text = "";
        int lineNumber;
        try {
          FileReader readfile = new FileReader("c:/xampp/apache/conf/httpd.conf");
          BufferedReader readbuffer = new BufferedReader(readfile);
          for (lineNumber = 1; lineNumber < 577; lineNumber++) {
            if (lineNumber == lineNumberSearch) {
              text = readbuffer.readLine();
            } else
              readbuffer.readLine();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        return text;
    }
    
    public static void main(String[] args) throws Exception {
        
        //Encontra o texto que está na linha 261 que é a linha do document root 
        String oldDocumentRoot = findText(261); //DocumentRoot
        
        //Encontra o texto que está na linha 262 que é a linha do directory 
        String oldDirectory = findText(262); //Directory 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String newPath;  

      
        System.out.println("\n Use / for subdirectory ");
        System.out.println("\n For htdocs just press ENTER ");
        System.out.println("\n Current: " + oldDocumentRoot);
        System.out.print("\n Enter the path: ");
        newPath = br.readLine();

        
        String newDocumentRoot = "DocumentRoot \"C:/xampp/htdocs/"+newPath+"\"";
        String newDirectory = "<Directory \"C:/xampp/htdocs/"+newPath+"\">";
        
        
         modifyFile("C:/xampp/apache/conf/httpd.conf", oldDocumentRoot, newDocumentRoot);
         modifyFile("C:/xampp/apache/conf/httpd.conf", oldDirectory, newDirectory);
         
         System.out.println("done");
               
    }


    private static void extracted() {
        System.out.println();
    }    
}
    
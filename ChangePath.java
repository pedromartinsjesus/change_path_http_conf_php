import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ChangePath{
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

    public static String findText(int lineNumberSearch) {
        
        String text = "";
        int lineNumber;
        try {
          FileReader readfile = new FileReader("c:/Users/Awesome/Desktop/myfile.txt");
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
        
        
        String directory = findText(262); //Directory 

        String newDocumentRoot = "DocumentRoot \"C:/xampp/htdocs/cursolaravel/\"";

        /*  System.out.println(documentRoot);
         System.out.println(directory); */
        
        modifyFile("C:/Users/Awesome/Desktop/myFile.txt", oldDocumentRoot, newDocumentRoot);
         
        System.out.println("done");  
        


    }    
}
    
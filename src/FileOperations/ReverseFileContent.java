package FileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReverseFileContent extends  FileOperation
{
    private String Content;

    public String getContent() {return Content;}

    public  void SetContent(String string) { this.Content = string;}
    public ReverseFileContent(String Filename) throws IOException {
        if(new File(Filename).exists())
        {
            if(new File(Filename).isFile() && !new File(Filename).isDirectory())
            {
                ReadFromFile read = new ReadFromFile();
                WriteToFile write = new WriteToFile();
                List<String> Lines = read.ReadFileWithNioAsAbsolutePath(Filename);
                StringBuilder Reverse = new StringBuilder();
                Reverse.append("\n\n******* Reverse Each Line *******\n\n");
                for(var item : Lines)
                {
                    String[] words = item.split(" ");
                    for(int i = words.length -1 ; i >= 0 ;i--)
                    {
                        Reverse.append(words[i]).append(" ");
                    }
                    Reverse.append("\n");
                }
                this.SetContent(Reverse.toString());
                write.WriteToFileWithFileWriter(Filename,this.getContent(),true);
            }
        }
        else
        {
            Path path = Paths.get(Filename);
            Files.createFile(path);
            System.out.println("File Created please put some string inside the file !!");
        }
    }
}

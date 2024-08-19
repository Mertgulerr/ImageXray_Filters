package FileOperations;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
Create a program that reads a text file containing
a list of names and sorts them alphabetically.
Write the sorted names back to the file.
 */
public class FileSorting extends  FileOperation
{

    public FileSorting(String Filename) throws IOException {
        String filePath = DefaultPath + Filename;
        List<String> Content;
        File file = new File(filePath);
        if(file.isFile() && file.exists() && !file.isDirectory())
        {
            ReadFromFile read = new ReadFromFile();
            FileOperation fileOperation = new FileOperation();
            StringBuilder stringBuilder = new StringBuilder();
            WriteToFile write = new WriteToFile();
            Content = read.ReadFileWithNioAsAbsolutePath(filePath);
            for(int i =0 ; i<Content.size() ;i++)
            {
                for(int j=i+1 ;j<Content.size() ;j++)
                {
                    if(Content.get(i).compareTo(Content.get(j))>0)
                    {
                        String tempj =  Content.get(j);
                        String tempi = Content.get(i);
                        Content.set(i,tempj);
                        Content.set(j,tempi);
                    }
                }
            }
            for (String item : Content)
            {
                stringBuilder.append(item).append("\n");
            }
            String _Content =stringBuilder.toString();

            fileOperation.CleanUpFiles(filePath);
            fileOperation.CreateFileWithNio(filePath);

            write.WriteToFileWithBufferedWriter(filePath,_Content);

        }
    }

}

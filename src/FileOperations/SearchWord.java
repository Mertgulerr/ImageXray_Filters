package FileOperations;

import Package1.Triangle1;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchWord
{
    private String FilePath;
    public void SetFilePath(String FileString) { this.FilePath = FileString;}
    public String GetFilePath() {return this.FilePath;}
    public boolean CheckdirectoryExist()
    {
        boolean existance=false;
        SetFilePath(FilePath);
        File file = new File(FilePath);
        if(file.exists() && file.isDirectory())
        {
            existance= true;
        }
        return existance;
    }
    public ArrayList<String> ListFilesInGivenDirectory()
    {
        ArrayList<String> filesList = new ArrayList<String>();
        Path directory = Paths.get(this.FilePath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                filesList.add(file.getFileName().toString());
            }
        } catch (IOException e) {
            throw  new IllegalStateException("There is No File in Given Path");
        }
        return filesList;
    }
    public boolean SearchFileWithGivenWord(String Word, String File) throws IOException {
        Scanner scanner = new Scanner(new File(this.FilePath + File));
        int LineCounter = 0;
        boolean contains = false;
        while (scanner.hasNextLine())
        {
            LineCounter += 1;
            String Line = scanner.nextLine();
            contains = Line.contains(Word);
            if(contains)
            {
                System.out.println(Line +
                        "\n"+" ----Contains Given Word in Line ----".toUpperCase()
                        + " : "+LineCounter + "\n"+
                         File);
                return  contains;
            }
        }
        scanner.close();
        return contains;
    }
}

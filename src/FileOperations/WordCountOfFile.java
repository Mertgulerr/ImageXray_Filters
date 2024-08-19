package FileOperations;

import java.io.IOException;

/* Write a Java program that reads a text file and counts the number of words in it.
    Display the total count at the end.
 */
public class WordCountOfFile
{
   public int CountWordsOfFile(String Filename) throws IOException
   {
        ReadFromFile read = new ReadFromFile();
        return read.ReadFileWithStreamTokenizerAsAbsolutePath(FileOperation.DefaultPath + Filename);
   }

   public void CalculateAverageLenghtOfWordsInFile(String Filename) throws IOException
   {
       ReadFromFile read = new ReadFromFile();
       System.out.println("Average Lenght of words in the given file is :" + read.ReadFileWithStreamTokenizerAsAbsolutePath(FileOperation.DefaultPath + Filename));
   }
}

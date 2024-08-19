package FileOperations;

import java.io.File;
import java.io.IOException;

/*
    Write a Java program that copies the content of one text file to another.
    The program should take the filenames as command-line arguments.
*/
public class FileCopy extends FileOperation
{
    public void ContentCopy(String Filename) throws IOException
    {
        ReadFromFile read = new ReadFromFile();
        WriteToFile write = new WriteToFile();
        FileOperation fileOperation = new FileOperation();

        fileOperation.CreateFileWithNio(DefaultPath + Filename);
        String readed = read.ReadLargeFileWithNioAsAbsolutePath();
        write.WriteToFileWithBufferedWriter(DefaultPath + Filename,readed);
    }
}

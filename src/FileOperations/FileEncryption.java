package FileOperations;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

/*
    Create a program that reads the content of a text file,
    encrypts it using a simple encryption algorithm (e.g., shift each character by a fixed number),
    and then writes the encrypted content to a new file.
 */
public class FileEncryption extends FileOperation
{

    public void EncryptFile(String Filename) throws IOException
    {
        ReadFromFile read = new ReadFromFile();
        WriteToFile write = new WriteToFile();
        FileOperation fileOperation = new FileOperation();
        fileOperation.CreateFileWithNio(DefaultPath + Filename);
        byte array[]  = read.ReadFileWithFileChannelAsAbsolutePath(DefaultPath + FilePath1);
        for(int i =0 ;i<array.length ;i++) array[i] +=7;
        String Content = new String(array);
        write.WriteToFileWithFileWriter(DefaultPath +Filename,Content);
    }

    public void DecryptFile(String Filename) throws  IOException
    {
        FileOperation fileOperation = new FileOperation();
        ReadFromFile read = new ReadFromFile();
        WriteToFile write = new WriteToFile();
        byte array[]  = read.ReadFileWithFileChannelAsAbsolutePath(DefaultPath +Filename);
        for(int i =0 ;i<array.length ;i++) array[i] -=7;
        String Content = new String(array);
        fileOperation.CleanUpFiles(DefaultPath +Filename);
        fileOperation.CreateFileWithNio(DefaultPath +Filename);
        write.WriteToFileWithFileWriter(DefaultPath +Filename,Content);
    }
}

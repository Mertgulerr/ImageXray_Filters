package FileOperations;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CompareToFiles {

    public static void  CompareBytes(Path File1 , Path File2) throws IOException
    {
        String filename1 = File1.toFile().toString();
        String filename2 = File2.toFile().toString();
        ReadFromFile read = new ReadFromFile();
        int FileLenght;
        int pos = 0 ;
        boolean ret =true;
        List<Byte> ListFile1 = read.ReadEachByteFromGivenFile(filename1);
        List<Byte> ListFile2 = read.ReadEachByteFromGivenFile(filename2);
        if(ListFile1.size() > ListFile2.size())
        {
            System.out.println("The First File Bigger than the other Compare method will work size of Second File size");
            FileLenght = ListFile2.size();
        }
        else
        {
            System.out.println("The Second File Bigger than the other Compare method will work size of First File size");
            FileLenght = ListFile1.size();
        }

        for(int i =0 ;i< FileLenght ;i++)
        {
            if(!ListFile2.get(i).equals(ListFile1.get(i)))
            {
                ret =false;
                break;
            }
            else pos+=1;
        }

        if(!ret)
        {
            System.out.println("The First :" + String.valueOf(pos) + "character same on the given files");
        }
        else System.out.println("The Given Files Completly Same");
    }
    public static void CompareWithMisMatch(Path File1 , Path File2) throws IOException
    {
        long n;
        if((n = Files.mismatch(File1,File2)) == -1L)
            System.out.println("The Files are identical");
        else
            System.out.println("The"+ n +"bytes are identifacal");
    }
    public static boolean compareByMemoryMappedFiles(Path path1, Path path2) throws IOException {
        try (RandomAccessFile randomAccessFile1 = new RandomAccessFile(path1.toFile(), "r");
             RandomAccessFile randomAccessFile2 = new RandomAccessFile(path2.toFile(), "r")) {

            FileChannel ch1 = randomAccessFile1.getChannel();
            FileChannel ch2 = randomAccessFile2.getChannel();
            if (ch1.size() != ch2.size()) {
                return false;
            }
            long size = ch1.size();
            MappedByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, size);
            MappedByteBuffer m2 = ch2.map(FileChannel.MapMode.READ_ONLY, 0L, size);

            return m1.equals(m2);
        }
    }
}

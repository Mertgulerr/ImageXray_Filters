package FileOperations;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFile extends  FileOperation
{

    public  void WriteToFileWithBufferedWriter(String Filename , String Content) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Filename));
        bufferedWriter.write(Content);
        bufferedWriter.close();
    }

    public void WriteToFileWithFileWriter(String Filename , String Content) throws IOException
    {
        FileWriter fileWriter = new FileWriter(new File(Filename));
        fileWriter.write(Content);
        fileWriter.close();
    }

    public void WriteToFileWithFileWriter(String Filename , String Content, Boolean append) throws IOException
    {
        FileWriter fileWriter = null;
        if(append)
             fileWriter = new FileWriter(new File(Filename),true);
        else
             fileWriter = new FileWriter(new File(Filename),false);
        fileWriter.write(Content);
        fileWriter.close();
    }

    /*PrintWriter ile formatlanmış verileri aynı printf ile %d %s %c %f koyarak yazabiliyoruz.*/
    public void WriteToFileWithPrintWriter(String Filename,String Content) throws IOException
    {
        FileOperation fileOperation = new FileOperation();
        if(new File(Filename).exists() && !new File(Filename).isDirectory() && new File(Filename).isFile())
        {
            fileOperation.CleanUpFiles(Filename);
            fileOperation.CreateFileWithNio(Filename);
        }
        else if  (!new File(Filename).exists())
            fileOperation.CreateFileWithNio(Filename);

        File file = new File(Filename);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Integer integer = null;
        integer = Integer.getInteger(Content);
        if(integer !=  null) {
            printWriter.print(integer);
            printWriter.print("\n");
        }
        else
        {
            printWriter.print(Content);
            printWriter.print("\n");
        }
        fileWriter.close();
        printWriter.close();
    }
    /*FileOutputStream ile binary data yazabiliyoruz*/
    public void WriteToFileWithFileOutputStream(String Filename,String Content) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream( new File(Filename));

        byte [] stream = Content.getBytes();
        fileOutputStream.write(stream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /*DataOutputStream ilkel veri türlerini yazmak için kullanışlıdır.*/
    public void WriteToFileWithDataOutputStream(String Filename, String Content) throws  IOException
    {
        FileOperation fileOperation = new FileOperation();
        if(new File(Filename).exists() && !new File(Filename).isDirectory() && new File(Filename).isFile())
        {
            fileOperation.CleanUpFiles(Filename);
        }

        DataOutputStream dataOutputStream = new DataOutputStream( new FileOutputStream(new File(Filename)));
        dataOutputStream.writeBytes(Content);
        dataOutputStream.flush();
        dataOutputStream.close();

        ReadFromFile read = new ReadFromFile();
        byte[] read1 = read.ReadFileWithFileChannelAsAbsolutePath(Filename);
        String string = new String(read1);
        if(string.equals(Content)) System.out.println("Successfully");
        else System.out.println("Fail");
    }

    /* RandomAccessFile : RandomAccessFile, dosyanın başlangıcından itibaren bayt cinsinden ofset verilen dosyada belirli bir konuma yazmamızı sağlar.
    *  RandomAccessFile : Belirli konumlara yazmak için kullanışlıdır.*/
    public void  WriteToFileWithRandomAccessFile(String Filename, String Content,Integer Position) throws  IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(Filename),"rw");
        randomAccessFile.seek(Position);
        randomAccessFile.writeBytes(Content);
        randomAccessFile.close();

        ReadFromFile read = new ReadFromFile();
        byte[] read1 = read.ReadFileWithFileChannelAsAbsolutePath(Filename);
        String string = new String(read1);
        if(string.substring(Position).equals(Content))
            System.out.println("Successfully");
        else
            System.out.println("Failed");
    }

    /*FileChannel : Eğer çalışılan dosya büyük bir dosya ise yazılma ve okunma anlamında  o zaman FileChannel sınıfı standart IO dan daha hızlı sonuç üretecektir.*/
    public void  WriteToFileWithFileChannel(String Filename, String Content) throws  IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(Filename),"rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        byte [] byteString = Content.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(Content.length());
        byteBuffer.put(byteString);
        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        randomAccessFile.close();
        fileChannel.close();
    }

    public void WriteToFileWithNioFiles(String Filename, String Content) throws IOException {
        Path path = Paths.get(Filename);
        byte[] byteString = Content.getBytes();
        Files.write(path,byteString);

        ReadFromFile readFromFile = new ReadFromFile();
        if(readFromFile.ReadFileWithNioAsAbsolutePath(Filename).get(0).equals(Content))
            System.out.println("Successfully");
        else
            System.out.println("Failed");
    }
    /*File.createTempFile ile geçici bir dosya oluşturabilir ve işlem akışında bu dosyayı kullanabiliriz.*/
    public void WriteToTemporaryFile(String Filename, String Content) throws IOException {

        File file = File.createTempFile("test",".tmp");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(Content);
        fileWriter.close();

        BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
    }

    /* Bazı zamanlarda bir dosyaya yazarken aynı anda bir başka program akışınıda o dosyaya yazamaması isteriz.
    *  Bu durumlarda yazılan dosyanın o anki işlem sırasında kilitlenmesi gerekir bu sebeple lock ederiz
    *  Daha sonra lock release edildiğinde başka bir thread o dosyaya yazabilir duruma geçecektir.*/

    public void WriteFileWithFileLock(String Filename, String Content) throws  IOException
    {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(Filename),"rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock = null;
        try
        {
            fileLock = fileChannel.tryLock();
        }
        catch (final OverlappingFileLockException e) {
            randomAccessFile.close();
            fileChannel.close();
        }

        byte [] contentBytes = Content.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(Content.length());
        byteBuffer.put(contentBytes);

        fileChannel.write(byteBuffer);
        fileLock.release();

        randomAccessFile.close();
        fileChannel.close();
    }
}

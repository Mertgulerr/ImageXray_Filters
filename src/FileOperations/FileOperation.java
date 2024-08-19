package FileOperations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation
{
    protected static  final String DefaultPath = "Test/Resources/";
    protected static final String FilePath = "FileToCreate.txt";
    protected static final String FilePath1 = "NumericFile.txt";
    protected static final String FilePath2 = "fileTestUtf8.txt";
    protected static final String FILE_TO_MOVE = "originalFileToMove.txt";
    protected static final String TARGET_FILE = "targetFileToMove.txt";

    /* Bir dosyayı yaratmadan önce ilk olarak dosya mevcutsa siliyoruz.
        File sınıfı dosya işlemlerini yerine getirmek için kullanılır.
        File sınıfının delete adlı metodunu çağırarak dosyayı silebiliriz.
        Lakin eğer dosya varsa silinecektir aksi takdirde False geri dönürecektir
        buda silinme işleminin yapılmadığını gösterir.

        False: Dosya zaten yok  veya security management hatası silmeye hakkı yok.
    * */
    public static void CleanUpFiles()
    {
        File file = new File(FilePath);
        Boolean result = file.delete();
        assert result == Boolean.TRUE : "File can't deleting";
    }

    public void CleanUpFiles(String Filename)
    {
        File file = new File(Filename);
        Boolean result = file.delete();
        assert result == Boolean.TRUE : "File can't deleting";
    }

    public void CleanUpFilesNio(String Filename) throws IOException {
        Path path = Paths.get(Filename);
        Files.delete(path);
    }

    public static  String GetDefaultPath() { return DefaultPath;}
    public  static String GetFilePath() { return  FilePath;}
    public static  String GetFilePath1(){ return FilePath1;}
    public static  String GetFilePath2() {return  FilePath2;}

    /*
    *File.createNewFile metodu yeni dosya yaratmak için kullanılmaktadır.
    * Burda dikkat edilmesi gereken nokta dosya var olmamalı böylelikle True geri döndürür
    * Eğer dosya var ise o zaman false geri döndürecektir.
    * Bir hata fırlatmayacaktır lakin false geri dönecek*/
    public static void CreateFileWithFileClass(String FilePath) throws IOException
    {
        File file = new File(FilePath);
        boolean success = file.createNewFile();
        assert success == Boolean.TRUE : "File exist or Path is wrong";
    }
    /*FileOutputStream  ile bir dosya yaratmak için direk costructor'üne dosya yolunu parametre olarak vermek gerekir.
    * Genellikle try-with-resources ile yazılması uygundur ama aşağıdaki gibi yazmamda da sorun yok.
    * Önemli nokta burada dosyanın var olup olmaması önemli değildir
    * Eğer dosya varsa overwrite edecektir yani yinede hata vermez.*/
    public static  void CreateFileWithFileOutputStream()
    {
       try
       {
           FileOutputStream fileOutputStream = new FileOutputStream(FilePath);
       }
       catch (FileNotFoundException e)
       {
           e.printStackTrace();
           throw  new IllegalStateException(e.getMessage(),e.getCause());
       }
    }
    /* NIO paketi kullanılmıştır burada.
    *  Exception işlemede oldukça yararlı bir paket olması göze çarpıyor ve bu sebeple geri dönüş kodlarını kullanmaktansa
    *  FileAlreadyExist diye bir exception throws edecektir.
    *  */
    public static void CreateFileWithNio() throws IOException
    {
        Path path = Paths.get(FilePath);
        Files.createFile(path);
    }

    public void CreateFileWithNio(String Filename) throws IOException {
        Path path = Paths.get(Filename);
        Files.createFile(path);
    }

    public  static  void CreateFolderwithMkdir() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final File homeDir = new File(System.getProperty("user.home"));
        System.out.println("What is the Folder Name you want to create");
        String path = bufferedReader.readLine();
        final File dir = new File(homeDir, path);
        boolean nret = false;
        if(!dir.exists())
        {
            nret = dir.mkdir();
        }
        if (nret) System.out.println("Folder creation successfuly");
        else System.out.println("folder couldn't created");
    }

    public static void CreateFolderwithNio() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final File homeDir = new File(System.getProperty("user.home"));
        System.out.println("What is the Folder Name you want to create");
        String path = bufferedReader.readLine();
        final File dir = new File(homeDir, path);
        Path PathToCreate =Paths.get(dir.toURI());
        Files.createDirectory(PathToCreate);
        bufferedReader.close();
    }

    public static boolean CheckGivenPathIndicateDirectory(String Path)
    {
        return Files.isDirectory(Paths.get(Path));
    }

    public static boolean CheckGivenPathIndicateFile(String Path)
    {
        return Files.isRegularFile(Paths.get(Path));
    }

    public static boolean CheckGivenPathExist(String Path)
    {
       return Files.exists(Paths.get(Path));
    }

    public static boolean CheckGivenPathIsReadable(String Path)
    {
        return Files.isReadable(Paths.get(Path));
    }
    public static boolean CheckGivenPathIsNotIndicateSymbolicLink(String Path)
    {
        return Files.isSymbolicLink(Paths.get(Path));
    }
}


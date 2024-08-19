package FileOperations;

import java.awt.datatransfer.MimeTypeParseException;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExtension
{

    private String _extension;
    public String GetExtension(){return  _extension;};
    public void  SetExtension(String Extension){_extension = Extension;}

    /*Dosya Sistemde mevcut  değilse yani filNotFound durumdaysa hata fırlatılır.
    * Dosyanın bir uzantısı yoksa yine başarısız olacaktır.
    * Dosyaların uzantıları isletim sistemine bağlıdır bu sebeple eğer bir dosya uzantısı tanınmıyorsa varsayılan dosya tanımlayıcısı çağrılarak bir uzantı bulunmaya çalışılır.*/
    public  void FileExtensionMethod1(String Filename)
    {
        Path path = Paths.get(Filename);
        try{
            String MIMETypes = Files.probeContentType(path);
            SetExtension(MIMETypes);
            System.out.println("Extension Of the Given File is: " + MIMETypes.toUpperCase());
        }catch (SecurityException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException("There is no access to given file");
        }catch (Exception ie)
        {
            System.out.println(ie.getMessage());
            throw  new IllegalArgumentException("The file entered does not have an extension or the file cannot be identified.");
        }
    }
        /* Bu yöntem dahili FileNameMap kullanarak dosya türünü çözümlemeye çalışır.
        getContentType() Metodunun  en büyük dezavantajı çok yavaş olmasıdır.*/
    public void FileExtensionMethod2(String Filename) throws IOException {
        File file = new File(Filename);
        URLConnection urlConnection = file.toURL().openConnection();
        SetExtension(urlConnection.getContentType());
        System.out.println("Extension Of the Given File is: " + GetExtension().toUpperCase());
    }
        /*Girdi akışının ilk birkaç karakterini kullanarak türü belirlemeye çalışmaktadır.*/
    public void FileExtensionMethod3(String Filename) throws IOException {
        File file = new File(Filename);
        SetExtension(URLConnection.guessContentTypeFromName(file.getName()));
        if(GetExtension() !=null )System.out.println("Extension Of the Given File is: " + GetExtension().toUpperCase());
        else System.out.println("The Given file is not recognized".toUpperCase());
    }

    public void FileExtensionMethod4(String Filename) throws IOException {
        File file = new File(Filename);
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        SetExtension(fileNameMap.getContentTypeFor(Filename));
        if(GetExtension() !=null )System.out.println("Extension Of the Given File is: " + GetExtension().toUpperCase());
        else System.out.println("The Given file is not recognized".toUpperCase());
    }
}

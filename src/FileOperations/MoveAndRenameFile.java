package FileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveAndRenameFile extends  FileOperation
{
    /* Nio  Kütüphanesini kullanarak Dosya taşıma gerçekleştirebilir.
    *  Taşınacak dosya veya hedef yol var olmalıdır yoksa hata fırlatılır.*/
    public static void MoveFile() throws IOException {
        Path FileToMove = Paths.get(FileOperation.DefaultPath +FileOperation.FILE_TO_MOVE);
        Path targetPath = Paths.get(FileOperation.DefaultPath + FileOperation.TARGET_FILE);
        Files.move(FileToMove,targetPath);
    }

    /* File sınıfının renameTo metodu ile taşıma işlemi gerçekleştirilebilir.
    *  Taşınacak veya rename edilecek dosya var olması gerekir keza hedef dizinin de
    *  Burada iki farklı hata fırlarılabilir biri SecurityException diğeri NullPointerException
    * Move veya Rename işleminin yapılıp yapılmadığı doğrudan boolean değişken üzerinden değerlendirilir.*/
    public static void MoveFileWithfileClass() throws  IOException
    {
        File FiletoMove = new File(FileOperation.DefaultPath + FileOperation.FILE_TO_MOVE);
        boolean ismoved= FiletoMove.renameTo(new File(FileOperation.DefaultPath + FileOperation.TARGET_FILE));
        if (!ismoved) {
            throw new FileSystemException(TARGET_FILE);
        }
    }
}

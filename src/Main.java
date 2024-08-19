import Records.Book;
import Records.Person;
import Records.Rectangle;

import java.io.*;
import java.util.List;

public class Main
{
    public static void main(String [] args) throws IOException {

        //FILE CREATION
            /*FileOperation.CleanUpFiles();
            FileOperation.CreateFileWithFileClass();
            FileOperation.CleanUpFiles();
            FileOperation.CreateFileWithFileOutputStream();
            FileOperation.CleanUpFiles();
            FileOperation.CreateFileWithNio();*/

        //FOLDER CREATION
        //FileOperation.CreateFolderwithMkdir();
        //FileOperation.CreateFolderwithNio();

        //FILE READ
            /*ReadFromFile read = new ReadFromFile();
            System.out.println(read.ReadFileAsAbsolutePath());
            System.out.println(read.ReadFileWithNioAsAbsolutePath());
            System.out.println(read.ReadLargeFileWithNioAsAbsolutePath());
            System.out.println(read.ReadFileWithLinesMethodNioAsAbsolutePath());
            System.out.println(read.ReadFileWithScannerClassAsAbsolutePath());
            System.out.println(read.ReadFileWithStreamTokenizerAsAbsolutePath());
            System.out.println(read.ReadFileWithDataInputStreamAsBinaryOrPrimitiveData());
            System.out.println(read.ReadFileWithFileChannelAsAbsolutePath());
            System.out.println(read.ReadFileEncodedWithUTF8());*/

            //FILE WRITE
            /*WriteToFile write = new WriteToFile();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a Formatted string to write file");
            String Line = "";
            while(scanner.hasNextLine())
            {
                Line = scanner.nextLine();
                //write.WriteToFileWithPrintWriter(FileOperation.GetDefaultPath() + "WriteToFile.txt",Line);
                //write.WriteToFileWithFileOutputStream(FileOperation.GetDefaultPath() + "BinaryFile.txt",Line);
                //write.WriteToFileWithDataOutputStream(FileOperation.GetDefaultPath() + "DataOutputFile.txt",Line);
                //write.WriteToFileWithRandomAccessFile(FileOperation.GetDefaultPath() + "DataOutputFile.txt",Line,9);
                //write.WriteToFileWithFileChannel(FileOperation.GetDefaultPath() + "DataOutputFile.txt",Line);
                //write.WriteToFileWithNioFiles(FileOperation.GetDefaultPath() + "BinaryFile.txt",Line);
                //write.WriteToTemporaryFile(FileOperation.GetDefaultPath() + "BinaryFile.txt",Line);
            }*/



        //Task 1: File Copy
            /*FileCopy fileCopy = new FileCopy();
            fileCopy.ContentCopy("Poem.txt");*/

        //Task 2 : File Encryption
            /*FileEncryption fileEncryption = new FileEncryption();
            fileEncryption.EncryptFile("Encrypt.txt");
            fileEncryption.DecryptFile("Encrypt.txt");*/

        // Task 3: Word Count Of a File
           /* WordCountOfFile countOfFile = new WordCountOfFile();
            System.out.println(countOfFile.CountWordsOfFile(FileOperation.GetFilePath()));
            System.out.println(countOfFile.CountWordsOfFile(FileOperation.GetFilePath1()));*/

        //Task 4: Search Word in a given Directory Path with all files
        /*SearchWord searchWord = new SearchWord();
        searchWord.SetFilePath(FileOperation.GetDefaultPath());
        boolean existance = searchWord.CheckdirectoryExist();
        ArrayList<String> files = new ArrayList<String>();
        if(existance)
        {
            files = searchWord.ListFilesInGivenDirectory();
            files.remove(0);
            for(int i =0 ; i<files.size() ;i++)
            {
                boolean result = searchWord.SearchFileWithGivenWord("Maecenas", files.get(i));
            }
        }*/

        //Task 5: Create a program that reads a text file containing
        //a list of names and sorts them alphabetically.
        //Write the sorted names back to the file.
       /* try{
            FileSorting fileSorting = new FileSorting("Names.txt");
        }catch (IOException err)
        {
            err.printStackTrace();
            throw  new IllegalStateException(err.getMessage());
        }*/

        //Task 6: Calculate Average Lenght of the words in the File
        /*WordCountOfFile countOfFile = new WordCountOfFile();
        countOfFile.CalculateAverageLenghtOfWordsInFile("FileToCreate.txt");*/

        //Task 7 : Create a program that reads the content of a text file,
        // reverses the order of characters in each line, and writes the modified content back to the file.
        //ReverseFileContent reverseFileContent = new ReverseFileContent(FileOperation.GetDefaultPath() +"Encrypt.txt");

        //Task 8: File Move and Renaming
        //MoveAndRenameFile.MoveFileWithfileClass();

        //Task 9: File Extension Dedector
        /*FileExtension fileExtension = new FileExtension();
        System.out.println("FileExtensionMethod1");
        fileExtension.FileExtensionMethod1("/Users/mertguler/Downloads/IMG_4503.HEIC");
        fileExtension.FileExtensionMethod1("/Users/mertguler/Desktop/Cover Letter for Ericsson.docx");
        fileExtension.FileExtensionMethod1(FileOperation.GetDefaultPath() + FileOperation.GetFilePath2());
        System.out.println("FileExtensionMethod2");
        fileExtension.FileExtensionMethod2("/Users/mertguler/Downloads/IMG_4503.HEIC");
        fileExtension.FileExtensionMethod2("/Users/mertguler/Desktop/Cover Letter for Ericsson.docx");
        fileExtension.FileExtensionMethod2(FileOperation.GetDefaultPath() + FileOperation.GetFilePath2());
        System.out.println("FileExtensionMethod3");
        fileExtension.FileExtensionMethod3("/Users/mertguler/Downloads/IMG_4503.HEIC");
        fileExtension.FileExtensionMethod3("/Users/mertguler/Desktop/Cover Letter for Ericsson.docx");
        fileExtension.FileExtensionMethod3(FileOperation.GetDefaultPath() + FileOperation.GetFilePath2());
        System.out.println("FileExtensionMethod4");
        fileExtension.FileExtensionMethod4("/Users/mertguler/Downloads/IMG_4503.HEIC");
        fileExtension.FileExtensionMethod4("/Users/mertguler/Desktop/Cover Letter for Ericsson.docx");
        fileExtension.FileExtensionMethod4(FileOperation.GetDefaultPath() + FileOperation.GetFilePath2());*/

        //Task 10 : File Contents Compare : Compare Two file
        /*Path path1 = Paths.get(FileOperation.GetDefaultPath() + FileOperation.GetFilePath());
        Path path2 = Paths.get(FileOperation.GetDefaultPath() + FileOperation.GetFilePath2());

        CompareToFiles.CompareBytes(path1,path2);
        CompareToFiles.CompareWithMisMatch(path1,path2);*/

        /*Employee e1 = new Employee("Şahika","Koçarslanlı",129);
        System.out.println("Firstname: " + e1.firstname() + "\r\nLastname: " + e1.lastName() + "\r\nId: " + e1.Id());
        System.out.println(e1.toString());

        Employee e2 = new Employee("Seda","Sayan");
        System.out.println("Firstname: " + e2.firstname() + "\r\nLastname: " + e2.lastName() + "\r\nId: " + e2.Id());
        System.out.println(e1.toString());

        System.out.println("Total Employee Count: " + Employee.TotalCountEmployee());*/

        Person p1 = new Person("Mert",5);
        System.out.println(p1.toString());
        Person.PersonWriter(p1);
        Person.Greet(p1);

        Person author = new Person("Johnny",27);
        List<Book> books = List.of(
                 new Book("Book 1",author),
                 new Book("Book 2", new Person("Catherine",51)),
                 new Book("Book 3",author)
        );

        Book.PrintBooks(author);

        Rectangle rec1 = new Rectangle(15.47,3.31);
        System.out.println("Area of Rectangle is: " + rec1.Area());

        }
    }

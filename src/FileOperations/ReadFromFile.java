package FileOperations;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Bu sınıf bir dosyayı okumak için birbirinden farklı metotları
 * karşılaştırarak örnekler sunmak için hazırlanmıştır.
 * */
public class ReadFromFile extends FileOperation
{
    private String readFromInputStream(InputStream inputStream) throws IOException
    {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private String readFromInputStream(BufferedReader reader)
    {
        StringBuilder resultStringBuilder = new StringBuilder();
        try
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultStringBuilder.toString();
    }

   /*File Read: Belirtilimiş bir konumdaki bir dosyayı okumaya yönelik olarak ilk metodumuz
   * BufferedReader : Yığın Okuyucusu --> Reader tipinde bir örnek alır bu kodda ise FileReader parametre geçilmiş
   * FileReader'ın parametresi ise dosyanın yoludur.
   * reader.ReadLine() denirse \n görülen yere kadar okur
   * reder.ReadLine() geriye null döndürüyorsa end of file ile karşılaşılmış demektir. */
    public String ReadFileAsAbsolutePath() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FilePath));
            return readFromInputStream(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(reader !=null)  reader.close();
        }
    }

     /* Bu kullanım şekli NIO paketiyle birlikte karşımıza çıkmaktadır JDK 7  galiba.
     *  Daha çok küçük boyutlu dosyaları okumak için kullanılır.*/
    public List<String> ReadFileWithNioAsAbsolutePath(String filePath) throws IOException
    {
        Path path = Paths.get(filePath);
        List <String> lines = Files.readAllLines(path);
        return  lines;
    }

    public String ReadLargeFileWithNioAsAbsolutePath() throws IOException
    {
        Path path = Paths.get(DefaultPath + FilePath);
        BufferedReader lines = Files.newBufferedReader(path);
        return readFromInputStream(lines);
    }

    public String ReadFileWithLinesMethodNioAsAbsolutePath() throws IOException
    {
        Path path = Paths.get(FilePath);
        Stream<String> lines = Files.lines(path);
        String data= lines.collect(Collectors.joining("\n"));
        lines.close();
        return data.trim();
    }

    public String ReadFileWithScannerClassAsAbsolutePath() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FilePath));
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine())
        {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return stringBuilder.toString();
    }
     /* Bu kullanım şekli token token okumak için hazırlanmıştır token bir simgedir  default token ise boşluktur("\n")
     *  boşluğun bulunduğu her kısıma kadar olan bölümler birer token olarak sayılacaktır.
     * */
    public String ReadFileWithStreamTokenizerAsAbsolutePath() throws IOException {
        FileReader fileReader = new FileReader(FilePath1);
        StreamTokenizer streamTokenizer = new StreamTokenizer(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        while(StreamTokenizer.TT_EOF != streamTokenizer.nextToken())
        {
            switch (streamTokenizer.ttype)
            {
                case StreamTokenizer.TT_WORD:
                    stringBuilder.append(streamTokenizer.sval).append("\n");
                break;
                case StreamTokenizer.TT_NUMBER:
                    stringBuilder.append(streamTokenizer.nval).append("\n");
                break;
            }
        }
        return  stringBuilder.toString();
    }

    public int ReadFileWithStreamTokenizerAsAbsolutePath(String Filename) throws  IOException
    {
        FileReader fileReader = new FileReader(Filename);
        StreamTokenizer streamTokenizer = new StreamTokenizer(fileReader);
        int average = 0;
        int count = 0;
        String word = "";
        int len=0;
        while(StreamTokenizer.TT_EOF != streamTokenizer.nextToken())
        {
            switch (streamTokenizer.ttype)
            {
                case StreamTokenizer.TT_WORD:
                {
                    word = streamTokenizer.sval;
                    len += word.length();
                    count += 1;
                }
                    break;
                case StreamTokenizer.TT_NUMBER:
                {
                    word = String.valueOf((int)streamTokenizer.nval);
                    len += word.length();
                    count += 1;
                }
                    break;
            }
        }
        average = len /count;
        return average;
    }

    /* Bu kullanım şeklinde binary olarak okuma sağlanmıştır. Ascii formatta binary olarak okumak istenirse DataInpuStream kullanılabilir.
    *  .avaible() metoduyla birlikte ise kaç byte yer aldığı dosya içerisinde hesaplanıp ona göre bir collection hazırlanabilir.
    * Burada byte array kullanılmış ve geri dönüşte ise String'e çevirilmiştir.
    * */
    public String ReadFileWithDataInputStreamAsBinaryOrPrimitiveData(String Filename) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(Filename));
        int bytes = dataInputStream.available();
        byte[] array = new byte[0];
        if (bytes > 0) {
            array = new byte[bytes];
            array = dataInputStream.readAllBytes();
        }
        return new String(array);
    }
    /* Eğer okunmak istenen dosya çok uzunsa FileChannel sınıfı bunu daha hızlı handle etmektedir.
    *  Binary olarak okunmaktadır.*/
    public String ReadFileWithFileChannelAsAbsolutePath() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(FilePath1,"r");
        FileChannel fileChannel = randomAccessFile.getChannel();
        int buffersize=1024;
        if(buffersize> fileChannel.size())
            buffersize = (int)fileChannel.size();

        ByteBuffer byteBuffer = ByteBuffer.allocate(buffersize);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        fileChannel.close();
        randomAccessFile.close();
        return new String(byteBuffer.array());
    }

    public byte [] ReadFileWithFileChannelAsAbsolutePath(String Filename) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(Filename,"r");
        FileChannel fileChannel = randomAccessFile.getChannel();
        int buffersize=1024;
        if(buffersize> fileChannel.size())
            buffersize = (int)fileChannel.size();

        ByteBuffer byteBuffer = ByteBuffer.allocate(buffersize);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        fileChannel.close();
        randomAccessFile.close();
        return byteBuffer.array();
    }

    public String ReadFileEncodedWithUTF8() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath2),"UTF-8"));
        String read = readFromInputStream(bufferedReader);
        bufferedReader.close();
        return  read;
    }

    /*Büyük boyutlu dosyalar ile çalışılırken her bir line temel girdi çıktı işlemlerini kullanacağından
    * bellekte saklanacaktır buda bir noktada ram kapasitesini dolduracağından  outofmemory hatasını fırlatacaktır.*/
    public void ReadLargeFileMethod1(String Filename) throws IOException {
        FileInputStream fileInputStream = null;
        Scanner scanner = null;
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        if(scanner.ioException() !=null)
            throw scanner.ioException();
        if(fileInputStream !=null)
            fileInputStream.close();
        if (scanner !=null)
            scanner.close();
    }

    public void ReadLargeFileMethod2(String Filename) throws IOException {
        SeekableByteChannel seekableByteChannel = null;
        seekableByteChannel =Files.newByteChannel(Paths.get(Filename), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
        while(seekableByteChannel.read(byteBuffer) >0)
        {
            byteBuffer.flip();
            System.out.println( new String(byteBuffer.array()));
            byteBuffer.clear();
        }
    }

    public List<Byte> ReadEachByteFromGivenFile(String Filename) throws  IOException
    {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(Filename));
        List<Byte> ReadedBytes = new ArrayList<>();
        int ch ;
        while((ch = bufferedInputStream.read()) != -1)
        {
           ReadedBytes.add((byte)ch);
        }
        bufferedInputStream.close();
        return ReadedBytes;
    }
}


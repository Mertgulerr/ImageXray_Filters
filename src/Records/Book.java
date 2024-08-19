package Records;

import java.util.ArrayList;
import java.util.List;

public record Book(String title , Person author)
{
    static List<Book> Books = new ArrayList<Book>();
    public Book
    {
        Books.add(this);
    }
    public  static void PrintBooks(Person author)
    {
        for(int i =0; i<Books.size() ;i++)
        {
            if(Books.get(i).author.equals(author))
            {
                System.out.println(Books.get(i).author.name() + " -- " + Books.get(i).author.age());
            }
        }
    }
}

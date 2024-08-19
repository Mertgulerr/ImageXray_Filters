import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
public class Arraylist
{
    public static void ArraylistBasic()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i =0; i<15;i++) list.add((int)Math.pow(i,3));
        for (int item: list)
        {
            System.out.println(String.valueOf(item));
        }
    }

    public static void ArraylistSort()
    {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0 ; i<100; i++)
        {
            list.add(rnd.nextInt(1000)+1);
        }

        //Collections.sort(list); // this is the first method to ssort an arraylist
        //list.sort(Comparator.naturalOrder()); that one second type to sort an arraylist ascending order
        //Collections.sort(list,Comparator.reverseOrder()); descending sort type one
        list.sort(Comparator.reverseOrder()); //descending sort type two

        System.out.println(list);

    }

    public static int ArraylistSearch(String std)
    {
        ArrayList<String> list = new ArrayList<String>();

        list.add("Selam");
        list.add("naber");
        list.add("nasilsin");
        list.add("heyyo");
        list.add("kalem");
        list.add("silgi");
        list.add("ates");
        list.add("su");
        list.add("toprak");
        list.add("hava");
        list.add("tahta");

        if(list.contains(std))
        {
           return list.indexOf(std);
        }
        else return -1;

    }

    public static void ArraylistInterSelection()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i = 0 ; i<100 ;i++ )
        {
            list1.add(rnd.nextInt(250)+1);
            list2.add(rnd.nextInt(250)+1);
        }
        ArrayList<Integer> listInterSel = new ArrayList<Integer>();
        for(int i = 0; i<list1.size();i++)
        {
            if(list2.contains(list1.get(i))) listInterSel.add(list1.get(i));
        }

        if (!listInterSel.isEmpty())
        {
            Collections.sort(listInterSel,Comparator.reverseOrder());
            for (int i = 0 ; i<listInterSel.size() ; i++)
            {
                for (int j = i+1 ; j<listInterSel.size() ; j++)
                {
                    if(listInterSel.get(j).equals(listInterSel.get(i)))
                    {
                        listInterSel.remove(listInterSel.get(j));
                    }
                }
            }
            System.out.println(listInterSel);
        }

    }

    public static  void  ArraylistManipulation(ArrayList<String> str)
    {
        int size = str.size();
        int count = 0;
        int last_index=0;

        for(int i=0 ; i<size ; i++)
        {
            for(int j = 0; j<size; j++)
            {
                if(str.get(i).equals(str.get(j)))
                {
                    count++;
                    last_index = str.lastIndexOf(str.get(j));
                }
            }
            if(count != 1)
            {
                str.remove(last_index);
                last_index=0;
                count=0;
                size= str.size();
                i = 0;
            }
            else
            {
                count=0;
                last_index=0;
            }
        }

        str.sort(Comparator.naturalOrder());
        System.out.println(str);
    }
}

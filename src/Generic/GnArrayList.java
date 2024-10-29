package Generic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.lang.Math;
public class GnArrayList<T>
{
    private int capacity;
    private List<T> arraylist;
    public GnArrayList() {
        this.arraylist = new ArrayList<>();
    };

    public GnArrayList(int capacity)
    {
        if(capacity>0) this.capacity = capacity;
        else throw  new IllegalArgumentException("Capacity Must Be Bigger Than Zero !!");
    }

    public void InitializeArraylist(Collection<T> collections)
    {
        this.arraylist = new ArrayList<>(collections);
    }
    public  void addItem(T item)
    {
        this.arraylist.add(item);
    }
    public  void addItem(int index,T item)
    {
        this.arraylist.add(index,item);
    }

    public void addItem(Collection<T> items)
    {
        this.arraylist.addAll(items);
    }

    public  void addItem(int index,Collection<T> items)
    {
        this.arraylist.addAll(index,items);
    }

    public boolean removeItem(T Item)
    {
        return this.arraylist.remove(Item);
    }
    public void removeItem(int index)
    {
        this.arraylist.remove(index);
    }
    public void IterateList()
    {
        ListIterator<T> listIterator = this.arraylist.listIterator(this.arraylist.size());
        List<T> tempList = new ArrayList<>();
        while(listIterator.hasPrevious())
        {
            tempList.add(listIterator.previous());
        }
        Collections.reverse(tempList);
        System.out.println(tempList);
    }

    public void ClearList()
    {
        this.arraylist.clear();
    }

    public int Size()
    {
        int count = 0;
        count = this.arraylist.size();
        return count;
    }

    public T get(int i)
    {
        return  this.arraylist.get(i);
    }

    public List<T> GnArrayListToList()
    {
        List<T> list = new ArrayList<>();
        for (var item : this.arraylist)
        {
            list.add(item);
        }
        return list;
    }
}

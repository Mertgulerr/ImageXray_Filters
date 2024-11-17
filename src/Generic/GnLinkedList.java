package Generic;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GnLinkedList<T> implements Comparable<T>
{
    //Challenge Question: Reverse a LinkedList in Place
    private LinkedList<T> LinkTLinkedList = null;
    public GnLinkedList(){ this.LinkTLinkedList = new LinkedList<>();}
    public void AddItem(T Item)
    {
        this.LinkTLinkedList.add(Item);
    }
    public void AddItem(int index, T Item)
    {
        this.LinkTLinkedList.add(index,Item);
    }

    public  void AddItem(Collection<T> Item)
    {
        this.LinkTLinkedList.addAll(Item);
    }
    public void AddFirst(T Item)
    {
        this.LinkTLinkedList.addFirst(Item);
    }

    public void AddLast(T Item)
    {
        this.LinkTLinkedList.addLast(Item);
    }

    public GnLinkedList<T> ReverseList(){
        GnLinkedList<T> Reverse = new GnLinkedList<>();
        int size = this.LinkTLinkedList.size();
        while(size > 0)
        {
            T temp = this.LinkTLinkedList.pollLast();
            if( temp != null)
            {
                Reverse.AddItem(temp);
            }
            size -=1;
        }
        return  Reverse;
    }

    public static void MergeTwoSortedLinkedLists(LinkedList<Integer> L1, LinkedList<Integer> L2)
    {
       /* 3. Merge Two Sorted LinkedLists
             Question: Write a method to merge two sorted linked lists into a single sorted linked list.

            Hints:

            Use a dummy node to simplify the merging process.
            Compare the heads of both lists and attach the smaller one to the merged list, moving the pointer of the chosen list forward.
            Solution Outline:

            Use a dummy node as the head of the new merged list.
            Compare nodes in both lists, attaching the smaller node to the merged list each time until all nodes are attached.*/

        LinkedList<Integer> MergedLinkedList = new LinkedList<>();
        int SortSize = Math.min(L1.size(), L2.size());
           while(SortSize>0)
           {
               int HeadL1 = L1.pollFirst();
               int HeadL2 = L2.pollFirst();
               MergedLinkedList.add(Math.min(HeadL1, HeadL2));
               SortSize-=1;
           }
           if(L1.size() > L2.size())
               MergedLinkedList.addAll(L1);
           else
               MergedLinkedList.addAll(L2);


    }

    public static boolean FindInterSectionOfTwoLinkedList(LinkedList<Integer> L1, LinkedList<Integer> L2)
    {
            /*2. Find the Intersection of Two LinkedLists
                Question: Write a function that takes two singly linked lists and returns the node at which they intersect. If the two lists have no intersection, return null.

                Hints:

                Traverse both lists to get their lengths.
                Align both lists by skipping nodes in the longer list until they are the same length, then look for the intersection point.
                Solution Outline:

                Calculate the length of both lists.
                Align them by moving the pointer of the longer list forward by the difference in lengths.
                Traverse the lists together to find the intersection point.
            * */

            int lenL1,lenL2,sub,value;
            boolean nret = Boolean.FALSE;
            lenL1 = L1.size();
            lenL2 = L2.size();

            if(lenL1> lenL2)
            {
                sub = lenL1 - lenL2;
                while (sub>0)
                {
                    value = L1.removeFirst();
                    sub--;
                }
            }
            else
            {
                sub= lenL2 - lenL1;
                while (sub > 0)
                {
                    value = L2.removeFirst();
                    sub--;
                }
            }

        Iterator<Integer> IterateL1 = L1.iterator();
            while (IterateL1.hasNext())
            {
                int temp = IterateL1.next();
                if(L2.contains(temp))
                {
                    System.out.println("FindInterSectionOfTwoLinkedList: " + temp + " InterSection Node of Two Given LinkedList");
                    nret = Boolean.TRUE;
                    break;
                }
            }

            if(!nret) System.out.println("FindInterSectionOfTwoLinkedList: " + " InterSection Node of Two Given LinkedList is NULL ");

            return  nret;
    }

    public static void RemoveDuplicateNodes(LinkedList<String> L1)
    {
        //Remove Duplicate Nodes
        for(int i = 0 ; i < L1.size(); i++)
        {
            for(int j = i + 1 ; j < L1.size() ; j++)
            {
                String L1i = L1.get(i);
                String L1j = L1.get(j);
                if(L1i.equals(L1j)) L1.remove(L1j);
            }
        }

        System.out.println(L1);
    }

    @Override
    public int compareTo(T o) {
        if (LinkTLinkedList != null && !LinkTLinkedList.isEmpty() && LinkTLinkedList.getFirst() instanceof String)
        {
            for (T item: LinkTLinkedList)
            {
                return Integer.compare(item.toString().length(),o.toString().length());
            }
        }
        return 0;
    }

    public static <T> List<T> fromArrayToList(T[] a)
    {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction)
    {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }
}

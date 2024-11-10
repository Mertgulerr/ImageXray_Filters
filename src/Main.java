import GUI.*;
import Generic.GnArrayList;
import Generic.GnLinkedList;
import Generic.GnListExample;
import Generic.TwoDArrayExample;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toCollection;

public class Main
{
    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        //region ArrayList
        GnArrayList<Integer> integerGnArrayList = new GnArrayList<>();
        GnArrayList<String> stringsToSearch = new GnArrayList<>();
        List<String> stringsToSearchClone = new ArrayList<String>();
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));


        Collection<Integer> collection = IntStream.range(11,20).boxed().collect(Collectors.toSet());

        integerGnArrayList.addItem(1);
        integerGnArrayList.addItem(12);
        integerGnArrayList.addItem(22);
        integerGnArrayList.addItem(1,52);
        integerGnArrayList.addItem(collection);

        integerGnArrayList.IterateList();

        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(toCollection(ArrayList::new));


        stringsToSearch.addItem(list);

        for(int i =0 ;i< stringsToSearch.Size();i++)
        {
            stringsToSearchClone.add(String.valueOf(stringsToSearch.get(i)));
        }

        // region Searching an Unsorted List
        // 1. Use indexof or Last|| First indexof
        stringsToSearchClone.indexOf("a");
        stringsToSearchClone.lastIndexOf("a");

        // Use Stream API
        List<String> result = stringsToSearchClone
                .stream()
                .filter(matchingStrings::contains)
                .collect(toCollection(ArrayList::new));

        // Use iterator to check one by one ever item in list
        Iterator<String> iterator = stringsToSearchClone.iterator();
        List<String> resultiterator = new ArrayList<>();

        while(iterator.hasNext())
        {
            String s = iterator.next();
            if(matchingStrings.contains(s))
                resultiterator.add(s);
        }
        //endregion

        //region Searching Sorted List
        List<Integer> IntegerList = new ArrayList<>(List.copyOf(integerGnArrayList.GnArrayListToList()));
        Collections.sort(IntegerList);
        System.out.println(IntegerList);
        System.out.println(Collections.binarySearch(IntegerList,12));
        //endregion

        //region Remove İtem in ArrayList
        integerGnArrayList.removeItem(Integer.valueOf(13));
        integerGnArrayList.removeItem(2);
        System.out.println(integerGnArrayList.GnArrayListToList());

        //endregion

        //region LinkedList
        GnLinkedList<String> stringGnLinkedList = new GnLinkedList<>();
        stringGnLinkedList.AddItem(list);
        GnLinkedList<String> reverseGnLinkedList = stringGnLinkedList.ReverseList();


        LinkedList<Integer> L1 = new LinkedList<>(IntStream.range(1,20).boxed().collect(Collectors.toList()));
        LinkedList<Integer> L2 =new LinkedList<>(IntStream.range(7,20).boxed().collect(Collectors.toList()));

        GnLinkedList.FindInterSectionOfTwoLinkedList(L1,L2);

        LinkedList<String> linklist = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(toCollection(LinkedList::new));
        linklist.add(4,"a");
        linklist.add(7,"c");
        linklist.add(11,"f");
        linklist.add(1,"9");

        GnLinkedList.RemoveDuplicateNodes(linklist);

        //endregion

    }
}
package Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GnListExample
{
    public GnListExample()
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N;
        int Q;
        String insert = "Insert";
        String delete = "Delete";
        N = scanner.nextInt();
        while(N>0)
        {
            list.add(scanner.nextInt());
            N-=1;
        }
        Q = scanner.nextInt();
        while (Q >0)
        {
            scanner.nextLine();
            String query= scanner.nextLine();
            int position,value;
            if(query.equals(insert))
            {
                 position= scanner.nextInt();
                 value= scanner.nextInt();
                 list.add(position,value);
            } else if (query.equals(delete))
            {
                position = scanner.nextInt();
                list.remove(position);
            }
            else break;
            Q-=1;
        }
        for (Integer item:list) {
            System.out.println(item +" ");
        }
    }
}

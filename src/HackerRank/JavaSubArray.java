package HackerRank;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class JavaSubArray
{
    public JavaSubArray() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n>=1 && n<=100)
        {
            int [] array = new int[n];
            for(int i =0 ;i<n ;i++)
            {
                int temp = scanner.nextInt();
                if(temp >= -10000 && temp <= 10000)
                array[i] = temp;
            }
            int i=0,j=0,k=0;
            int sum =0;
            int count =0 ;
            for(k=0 ;k<n ; k++)
            {
                for(i =n-1 ; i>=0 ;--i)
                {
                    for(j =0 ;j<n-i ; ++j)
                    {
                     sum += array[j+k];
                    }
                    if(sum <0)  count++;
                    sum = 0 ;
                    if((j+k)> (n-1))
                    {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

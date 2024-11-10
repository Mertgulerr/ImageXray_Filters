package Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoDArrayExample

{
     private static final int DimensionX = 6;
     private static final int DimensionY = 6;

     public TwoDArrayExample()
     {
         Scanner scanner = new Scanner(System.in);
         List<List<Integer>> arr = new ArrayList<>();
         System.out.println("Give " +DimensionX + "X" + DimensionY + "2D Array");

         for (int i = 0 ; i < DimensionX ; i++)
         {
             List<Integer> arrRowItems = new ArrayList<>();

             for(int j = 0 ; j < DimensionY ; j++)
             {
                 int arrItem = Integer.parseInt(scanner.next());
                 arrRowItems.add(arrItem);
             }
             scanner.nextLine();
             arr.add(arrRowItems);

         }

         int sumx1,sumx2,sumy,sumleast = 0,sumttotal;
         for(int i = 0 ; i<DimensionX-2; i++ )
         {
             for(int j = 0 ;j <DimensionY-2 ;j++)
             {
                 sumx1 = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                 sumy = arr.get(i+1).get(j+1);
                 sumx2 = arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                 sumttotal = sumx1 + sumx2 + sumy;
                 if(sumleast<sumttotal) sumleast = sumttotal;
             }
         }
     }
}

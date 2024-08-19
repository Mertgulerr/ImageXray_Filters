package Package2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface MathOperation
{
    int add(int a,int b);
    int add(String a,String b);
    default double add(double a,double b)
    {
        return a+b;
    }
    static double add(int a,double b)
    {
        return a+b;
    }

    int subtract(int a, int b);
    int subtract(String a,String b);
    default double subtract(double a, double b)
    {
        BigDecimal rounded = BigDecimal.valueOf(a-b);
        rounded=rounded.setScale(1, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
    static double subtract(int a, double b)
    {
        BigDecimal rounded = BigDecimal.valueOf(a-b);
        rounded=rounded.setScale(1, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

    int multiple(int a, int b);
    int multiple(String a,String b);
    default double multiple(double a, double b)
    {
        BigDecimal rounded = BigDecimal.valueOf(a*b);
        rounded=rounded.setScale(1, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }
    static double multiple(int a, double b)
    {
        BigDecimal rounded = BigDecimal.valueOf(a*b);
        rounded=rounded.setScale(1, RoundingMode.HALF_UP);
        return rounded.doubleValue();
    }

    int divide(int a, int b);
    int divide(String a,String b);
    default double divide(double a, double b)
    {
        if(b != 0)
        {
            BigDecimal rounded = BigDecimal.valueOf(a/b);
            rounded=rounded.setScale(1, RoundingMode.HALF_UP);
            return rounded.doubleValue();
        }
        else return 0;
    }
    static double divide(int a, double b)
    {
        if(b != 0)
        {
            BigDecimal rounded = BigDecimal.valueOf(a/b);
            rounded=rounded.setScale(1, RoundingMode.HALF_UP);
            return rounded.doubleValue();
        }
        else return 0;
    }
}

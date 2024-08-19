import java.util.Objects;

public class Decimal
{
    public static String DecimaltoBinary(Integer Number)
    {
        StringBuilder binary =new StringBuilder();
        int index=0;
        int bits=8;
        if(Number!=0 && Number != null)
        {
            if(Number>=256) bits=16;
            while(Number>0)
            {
                index=Number%2;
                binary.append(index);
                Number/=2;
            }
            binary.reverse();
            while(binary.length()<bits)
                binary.insert(0,"0");
            return binary.toString();
        }
        else return "";
    }

    public static String DecimaltoOctal(Integer Number)
    {
        StringBuilder binary =new StringBuilder();
        int index=0;
        if(Number!=0 && Number != null)
        {
            while(Number>0)
            {
                index=Number%8;
                binary.append(index);
                Number/=8;
            }
            binary.reverse();
            return binary.toString();
        }
        else return "";
    }

    public static Integer EBOB(Integer Number1,Integer Number2)
    {
        int m,n,r;
        m=Number1;
        n=Number2;
        if(m>n)
        {
           r=m%n;
           while(r!=0)
           {
               m=n;
               n=r;
               r = m%n;
           }
           return n;
        }
        else return -1;
    }

    public static Integer EKOK (Integer Number1,Integer Number2)
    {
        if(!Objects.equals(Number1, Number2) && !(Number1 <=0 || Number2 <=0))
        {
            return (Number1 *Number2) /EBOB(Number1,Number2);
        }
        else return -1;
    }
}

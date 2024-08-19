public class Calculator
{
    private int number1;
    private int number2;

    public void Setnumber1(Integer number1)
    {
        if(number1 != null)this.number1 = number1.intValue();
    }

    public int Getnumber1()
    {
        return this.number1;
    }

    public void Setnumber2(Integer number2)
    {
        if(number2 != null)this.number2 = number2.intValue();
    }

    public int Getnumber2()
    {
        return this.number2;
    }

    Calculator(Integer number1,Integer number2)
    {
        if(number1 != null)this.number1 = number1.intValue();
        else  this.number1 = 0;
        if(number2 != null)this.number2 = number2.intValue();
        else  this.number2 = 0;
    }
    Calculator()
    {
        this.number2 = this.number1 = 0;
    }

    int add()
    {
        if((this.number2 + this.number1) <= Integer.MAX_VALUE   && (this.number2 + this.number1) >= Integer.MIN_VALUE )
            return this.number1+ this.number2;
        else
            System.out.println("Bound of integer exceeded");
        return 0;
    }

    static int add(int number1,int number2)
    {
        return number1 + number2;
    }

    int subract()
    {
        if((this.number1 - this.number2) <= Integer.MAX_VALUE   && (this.number1 - this.number2) >= Integer.MIN_VALUE )
            return this.number1 - this.number2;
        else
            System.out.println("Bound of integer exceeded");
        return 0;
    }

    static int subract(int number1,int number2)
    {
        return  number1-number2;
    }

    int multiple()
    {
        if((this.number1 * this.number2) <= Integer.MAX_VALUE   && (this.number1 * this.number2) >= Integer.MIN_VALUE )
            return this.number1 * this.number2;
        else
            System.out.println("Bound of integer exceeded");
        return 0;
    }

    static int multiple(int number1,int number2)
    {
        return  number1*number2;
    }

    static double multiple(double number1, double number2)
    {
        return  number1*number2;
    }

    double divide()
    {
       if(this.number2 != 0)
       {
           double num1 = this.number1;
           double num2 = this.number2;
            if((num1/number2) <= Double.MAX_VALUE  && (num1/num2) >= Double.MIN_VALUE)
                return  num1/num2;
            else
                System.out.println("Bound of integer exceeded");
            return 0;
       }
       else
           System.out.println("Divide numberr cannot be Zero");
       return 0;
    }

    static int divide(int number1,int number2)
    {
        if(number2!=0)
            return  number1/number2;
        else
            return -1;
    }

    static double divide(double number1,double number2)
    {
        if(number2!=0)
            return  number1/number2;
        else
            return -1;
    }


}

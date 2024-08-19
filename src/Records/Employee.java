package Records;

public record Employee(String firstname , String lastName , int Id)
{
    static int EmployeeCount;

    //Compact Costructor: Varsayılan Costructor benzer bir yapıya sahiptirler.
    //Instance alındığında ilk olarak bu çağırlacaktır çünkü paramatresiz olarak yaratılmıştır.
    public Employee
    {
        EmployeeCount++;
        if(Id != 0)
        {
            if(Id < 100) throw  new IllegalArgumentException("Id can not be below the 100");
        }
        if(firstname.length() < 2) throw  new IllegalArgumentException("Firstname must be more than 2 character");
    }
    public Employee(String firstname,String lastname)
    {
       this(firstname,lastname,0);
    }

    public static int TotalCountEmployee()
    {
            return EmployeeCount;
    }
}

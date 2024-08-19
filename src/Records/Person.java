package Records;

public record Person(String name , int age)
{
    public Person
    {
        if(age<0)
            throw  new IllegalArgumentException("Instance age is negative");
    }
    public static void PersonWriter(Person p1)
    {
        System.out.println(p1.name.toUpperCase());
        System.out.println(p1.age);
    }
    public  static  void Greet(Person p1)
    {
        System.out.print("Hi " + p1.name);
        System.out.print(" How are you ?");
    }
}

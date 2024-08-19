/*Create a Java class called Person with attributes for name and age.
 Write a constructor   to initialize these attributes and a method to display
 the person's details.*/

/* Builder Pattern : Private Constructure Usage*/
public class Person
{
    private String FirstName;
    private String LastName;
    private int age;
    private double weight;
    private double height;
    private String address;

    private Person(PersonBuilder builder)
    {
        this.FirstName=builder.FirstName;
        this.LastName=builder.LastName;
        this.age= builder.age;;
        this.weight= builder.weight;
        this.height=builder.height;
        this.address= builder.address;
    }

    public static  class PersonBuilder
    {
        private String FirstName;
        private String LastName;
        private int age=25;
        private double weight;
        private double height;
        private String address=null;

        public PersonBuilder(String FirstName, String LastName)
        {
            this.FirstName=FirstName;
            this.LastName=LastName;
        }

        public PersonBuilder SetAge(int age)
        {
            this.age=age;
            return this;
        }

        public PersonBuilder SetWeight(double weight)
        {
            this.weight =weight;
            return this;
        }
         public  PersonBuilder SetHeight(double weight)
         {
             this.height =height;
             return this;
         }

         public  PersonBuilder SetAddress(String address)
         {
             this.address =address;
             return this;
         }

         public Person Build()
         {
             return  new Person(this);
         }
    }

}

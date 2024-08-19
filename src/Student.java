import java.util.ArrayList;

/*
Create a Java class called Student with attributes
for name, roll number, and marks in three subjects.
Write a method to calculate the average marks of the student.
 */

class Phone
{
    private String AreaCode;
    public void SetAreaCode(String CountryCode){ this.AreaCode = CountryCode;}
    public String GetAreaCode(){return this.AreaCode;}
    private String PhoneNumber;
    public void SetPhoneNumber(String CellPhoneNumber){this.PhoneNumber = CellPhoneNumber;}
    public String GetPhoneNumber(){return this.PhoneNumber;}
    @Override
    public String toString()
    {
        if(!this.PhoneNumber.isBlank() && !this.PhoneNumber.isEmpty())
            return "The Phone Number is : " +this.GetPhoneNumber();
        else
            return null;
    }
    Phone()
    {
        this.AreaCode ="+00";
        this.PhoneNumber="5000000000";
    }
    Phone(String CountryCode, String CellPhoneNumber)
    {
        if(!CountryCode.isEmpty() && !CountryCode.isBlank())
        {   try
        {
            int code;
            code = Integer.parseInt(CountryCode);
            this.AreaCode="+"+String.valueOf(code);
        }catch(NumberFormatException e)
        {
            System.out.println("Given String is Not valid format for CountryCode");
        }
        }
        else
        {
            System.out.println("Given input is Empty or Blank Space");
            this.AreaCode="+00";
        }

        if(!CellPhoneNumber.isBlank() && !CellPhoneNumber.isEmpty()) {
            try {
                if (CellPhoneNumber.length() == 10 && '5' == CellPhoneNumber.charAt(0)) {
                    this.PhoneNumber=CellPhoneNumber;
                }
                else
                    this.PhoneNumber="5000000000";
            } catch (Exception e) {
                System.out.println("Given String is not valid for CellPhone Number Format");
            }
        }
    }
}

class Address
{
    private  int Number;
    public void SetApartmentNumber(int ApartmentNumber) { this.Number = ApartmentNumber;}
    public int GetApartmentNumber(){return this.Number;}
    private String StreetName;
    public void SetStreetName(String StreetName){this.StreetName = StreetName;}
    public String GetStreetName(){return this.StreetName;}
    private String City;
    public void SetCity(String CityName){this.City = CityName;}
    public String GetCity(){return this.City;}
    private String Province;
    public void SetProvince(String Province){this.Province = Province;}
    public String GetProvince(){return this.Province;}
    Phone HomePhoneNumber;
    public void SetHomePhoneNumber(Phone HomePhoneNumber) { this.HomePhoneNumber = HomePhoneNumber;}
    public String GetHomePhoneNumber()
    {
        StringBuilder Str1=new StringBuilder();
        Str1.append("Cell Phone Number: " +this.HomePhoneNumber.GetPhoneNumber());
        return Str1.toString();
    }

    Address()
    {
        this.Number=0;
        this.City=null;
        this.Province=null;
        this.StreetName=null;
    }

    Address(Integer ApartmentNumber,
            String StreetName ,
            String CityName,
            String Province)
    {
        if(ApartmentNumber >0 &&
           !StreetName.isEmpty() && !StreetName.isBlank() &&
           !CityName.isEmpty() && !CityName.isBlank() &&
           !Province.isEmpty() && !Province.isBlank())
        {
            this.Number=ApartmentNumber;
            this.StreetName=StreetName;
            this.City=CityName;
            this.Province=Province;
        }
    }
}

public class Student
{
    private String StudentName;
    public void SetStudentName(String Name){ this.StudentName = Name;}
    public String GetStudentName(){return this.StudentName;}
    private Integer StudentRoolNumber;
    public void  SetStudentRoolNumber(Integer Number)
    {
        if(Number<=0) System.out.println("Student Rool Number Must be Positive Integer");
            else this.StudentRoolNumber = Number;
    }
    public Integer GetStudentRoolNumber() { return  this.StudentRoolNumber;}
    private Integer LessonCount;

    public void SetLessonCount(Integer CountOfLessons) { this.LessonCount = CountOfLessons;}

    public Integer GetLessoncount() {return this.LessonCount;}
    private  record Lessons
            (
                    String LessonsName,
                    Integer Mark1,
                    Integer Mark2,
                    Integer Mark3
            ){}

    private ArrayList<Lessons> Lesson;

    public void SetLesson(String LessonName, Integer Mark1, Integer Mark2 ,Integer Mark3)
    {
        Lessons l1 = new Lessons(LessonName,Mark1,Mark2,Mark3);
        Lesson.add(l1);
    }

    public double CalculateLessonAverage(String LessonName)
    {
        double average=0.0D;
        int index = 0;
        for(int i=0 ;i<Lesson.size() ;i++)
        {
            if(Lesson.get(i).LessonsName.equals(LessonName)){
                index= Lesson.lastIndexOf(Lesson.get(i));
            }

        }

        average= (double) ((Lesson.get(index).Mark1 +Lesson.get(index).Mark2+Lesson.get(index).Mark3)/3);

        return average;
    }

    private Address address;

    public void SetAddress(Integer ApartmentNumber,
                           String Street,
                           String City,
                           String Province)
    {
        this.address.SetApartmentNumber(ApartmentNumber);
        this.address.SetStreetName(Street);
        this.address.SetCity(City);
        this.address.SetProvince(Province);
    }

    public void SetAddress(Address address){ this.address =address;}

    public String GetAddress()
    {
        StringBuilder Str1 =new StringBuilder();
        Str1.append("Apartment Number: "+this.address.GetApartmentNumber() + "\n");
        Str1.append("Street Name: " +this.address.GetStreetName() + "\n");
        Str1.append("City Name: "+this.address.GetCity() + "\n");
        Str1.append("Province: "+this.address.GetProvince());
        return Str1.toString();
    }

    private Phone CellPhone;
    public void SetCellPhone(String AreaCode, String CellPhoneNumber)
    {
        this.CellPhone.SetAreaCode(AreaCode);
        this.CellPhone.SetPhoneNumber(CellPhoneNumber);
    }

    public void SetCellPhone(Phone cellPhone) { this.CellPhone = cellPhone;}

    public String GetCellPhoneNumber()
    {
        StringBuilder Str1=new StringBuilder();
        Str1.append("Cell Phone Number: " +this.CellPhone.GetPhoneNumber());
        return Str1.toString();
    }

    Student()
    {
        this.StudentName = null;
        this.LessonCount = 0;
        this.StudentRoolNumber = 0;
        this.Lesson = new ArrayList<Lessons>(this.LessonCount);

    }

    Student(
            String Name,
            Integer RoolNumber,
            Integer LessonCount
    )
    {
        this.StudentName = Name;
        this.StudentRoolNumber = RoolNumber;
        this.LessonCount = LessonCount;
        this.Lesson = new ArrayList<Lessons>(this.LessonCount);
    }

    Student (Address Address, Phone CellPhone)
    {
        this.address=Address;
        this.CellPhone=CellPhone;
    }
}

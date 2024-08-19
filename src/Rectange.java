//Create a Java class called Rectangle with attributes for length and width.
// Write a constructor to initialize these attributes and a method to calculate
// the area of the rectangle.
public class Rectange
{
    private double width;
    private double height;

    Rectange()
    {
        this(0,0);
    }
    Rectange(double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    public double getWidth()
    {
        System.out.println("Width of the rectange is: " + this.width);
        return this.width;
    }
    public void setWidth(double width)
    {
        this.width = width;
        System.out.println("Width of the rectange is " +this.width);
    }
    public double getHeight()
    {
        System.out.println("Width of the rectange is: " + this.height);
        return this.height;
    }
    public void setHeight(double height)
    {
        this.height = height;
        System.out.println("Width of the rectange is " +this.height);
    }

    public double Area()
    {
        this.width = this.width == 0 ? 0: Double.valueOf(this.width);
        this.height = this.height == 0 ? 0: Double.valueOf(this.height);
        return  this.width* this.height;
    }

    public String toString()
    {
        return this.getClass().toString();
    }
}

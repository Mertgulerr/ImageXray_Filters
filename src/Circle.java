public class Circle
{
    private  int radius;

    public void SetRadius(int radius)
    {
        this.radius = radius;
    }

    public int GetRadius()
    {
        return this.radius;
    }
    Circle(int radius)
    {
        this.radius = radius;
    }
    Circle()
    {

    }

    public double Circumference()
    {
        return 2 * Math.PI * this.radius;
    }

    public double Area()
    {
        return Math.PI*Math.pow(this.radius,2);
    }

    public String toString()
    {
        return this.getClass().toString();
    }
}

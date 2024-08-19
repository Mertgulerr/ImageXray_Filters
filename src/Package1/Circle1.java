package Package1;

public class Circle1 extends Shape {

    private Double Radius;
    static final Double PI = Math.PI;

    public void setRadius(Double radius) {
        if (!radius.isNaN() && radius > 0.0D)
            this.Radius = radius;
    }

    public Double getRadius() {
        return this.Radius;
    }

    public Circle1()
    {
        this.Radius =0.0D;
    }

    public Circle1(Double radius)
    {
        this.setRadius(radius);
    }

    @Override
    public Double CalculateArea()
    {
        return PI * Math.pow(getRadius(), 2);
    }
}

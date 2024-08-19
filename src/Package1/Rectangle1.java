package Package1;

public class Rectangle1 extends Shape
{
    private Double ShortEdge;
    private Double LongEdge;

    public Rectangle1()
    {
        this.ShortEdge=0D;
        this.LongEdge=0D;
    }
    public Rectangle1(Double shortEdge,Double longEdge)
    {
        this.SetEdge(shortEdge,longEdge);
    }

    private void SetEdge(Double shortEdge, Double longEdge)
    {
        if((!shortEdge.isNaN() && shortEdge != 0) && (!longEdge.isNaN() && longEdge !=0))
        {
            this.ShortEdge=shortEdge;
            this.LongEdge=longEdge;
        }
    }

    @Override
    public Double CalculateArea()
    {
        return this.ShortEdge * this.LongEdge;
    }
}

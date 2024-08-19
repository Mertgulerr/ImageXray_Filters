package Records;

public record Rectangle(Double width,Double length)
{
    public Rectangle{
        if(width <= 0 || length <=0)
            throw  new IllegalArgumentException("One of the arguments of the rectangle is negative");
    }

    public  Double Area()
    {
        return width() * length();
    }
}

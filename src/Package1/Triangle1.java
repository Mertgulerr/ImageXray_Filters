package Package1;

public class Triangle1 extends Shape
{
    private  int type;
    private  Double Side;
    private  Double SideOfHeight;
    private  Double[] ThreeSides;
    public Double Calculate(Double aSide,Double aSideOfHeight)
    {
        this.type=1;
        if(!aSide.isNaN() && aSide >0)
             this.Side=aSide;
        if(!aSideOfHeight.isNaN() && aSideOfHeight>0)
             this.SideOfHeight=aSideOfHeight;
        return CalculateArea();
    }

    public Double Calculate(Double[]array,int length)
    {
        if(length == 3)
        {
            type = 2;
            this.ThreeSides = array.clone();
        }
        return CalculateArea();
    }

    @Override
    Double CalculateArea() {
        if(type == 1)
        {
            return (this.Side * this.SideOfHeight)/2;
        }
        else if(this.type == 2)
        {
            //Heron formula
            double s = (this.ThreeSides[0] +this.ThreeSides[1] +this.ThreeSides[2])/2;
            return Math.sqrt(s*(s- this.ThreeSides[0])*(s- this.ThreeSides[1])*(s- this.ThreeSides[2]));
        }
        return null;
    }
}

package Package2;

interface Vehicle
{
    void Start();
    void Stop();
}

public interface FourWheeler extends Vehicle
{
    void drive();
}

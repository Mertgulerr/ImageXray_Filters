package Package2;

public class Car implements FourWheeler
{
    @Override
    public void drive() {
        System.out.println("The car is driving!!");
    }

    @Override
    public void Start() {
        System.out.println("The Car Started");
    }

    @Override
    public void Stop() {
        System.out.println("The Car Stopped");
    }
}

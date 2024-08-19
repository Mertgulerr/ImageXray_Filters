package Package2;

public interface Sound
{
    default void makeSound() {
        System.out.println("Default Sound *brrr*");
    }
}

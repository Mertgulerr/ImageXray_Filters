package Package2;

public class Operation implements MathOperation{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int add(String a, String b) {
        return Integer.parseInt(a)+Integer.parseInt(b);
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }

    @Override
    public int subtract(String a, String b) {
        return Integer.parseInt(a)-Integer.parseInt(b);
    }

    @Override
    public int multiple(int a, int b) {
        return a*b;
    }

    @Override
    public int multiple(String a, String b) {
        return Integer.parseInt(a)*Integer.parseInt(b);
    }

    @Override
    public int divide(int a, int b) {
        if(b!=0) return a/b;
        else return 0;
    }

    @Override
    public int divide(String a, String b) {
        if(Integer.parseInt(b)!=0) return Integer.parseInt(a)/Integer.parseInt(b);
        else return 0;
    }
}

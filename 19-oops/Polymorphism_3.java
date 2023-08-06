public class Polymorphism_3 {
    
    public static void main(String args[]) {
        Calculator c = new  Calculator();
        System.out.println(c.sum(3, 5));
        System.out.println(c.sum(3, 5, 6));
        System.out.println(c.sum(3.8f, 5.3f));
    }
}

class Calculator {
    int sum(int a, int b) {
        return (a+b);
    }

    float sum(float a, float b) {
        return (a+b);
    }

    int sum(int a, int b, int c) {
        return (a+b+c);
    }
}

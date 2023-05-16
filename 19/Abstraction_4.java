public class Abstraction_4 {
    
    public static void main(String args[]) {
        Horse myhorse = new Horse();
        Chicken myChicken = new Chicken();
        myhorse.eats();
        myhorse.walks();
        myChicken.eats();
        myChicken.walks();
        myhorse.changeColor();
        System.out.println("horse: " + myhorse.color);
        System.out.println("Chicken: " + myChicken.color);
    } 
}

//abstract class-- may or maynot have abstract methods or properties
abstract class Animal {
    String color;

    Animal() {
        color = "brown";
    }

    void eats() {
        System.out.println("eats");
    }
    abstract void walks();
}

class Horse extends Animal {
    
    void changeColor() {
        color = "dark brown";
    }
    void walks() {
        System.out.println("walks on 4 legs");
    }
}

class Chicken extends Animal {

    void changeColor() {
        color = "light brown";
    }
    void walks() {
        System.out.println("walks on 2 legs");
    }
}
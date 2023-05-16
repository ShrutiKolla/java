public class Inheritance_2 {

    public static void main(String args[]) {

        Mammal tiger = new Mammal();
        Bird crow = new Bird();
        Fish dolphin = new Fish();

        tiger.walks();
        crow.flies();
        dolphin.swims();
        //multiple inheritance
        /*Dogs Dobby = new Dogs();
        Dobby.legs = 4;
        Dobby.breed = "Bull";
        Dobby.eats();
        System.out.println(Dobby.breed);*/

        //Single inheritance
        /*Fish shark = new Fish();
        shark.eats();
        shark.swims(); */
    }
}

//base class
class Animal {
    String color;

    void eats() {
        System.out.println("eats");
    }
    void breathes() {
        System.out.println("breathes");
    }
}

class Mammal extends Animal {
    void walks() {
        System.out.println("walks");
    }
}
class Fish extends Animal {
    void swims() {
        System.out.println("swims");
    }
}
class Bird extends Animal {
    void flies() {
        System.out.println("flies");
    }
}

// class Mammal extends Animal {
//     int legs;
// }

// class Dogs extends Mammal {
//     String breed;
// }

// class Fish extends Animal {
//     int fins;

//     void swims() {
//         System.out.println("swims in the water");
//     }
// }
public class Interface_5 {
    public static void main(String args[]) {
        Bear b = new Bear();
        b.eats();
        b.isVeg();
        b.isNonveg();
        // Queen q = new Queen();
        // Rook r = new Rook();
        // King k = new King();
        // q.moves();
        // r.moves();
        // k.moves();
    }
}

//multiple inheritance
interface Herbivore {
    void eats();
    void isVeg();
}

interface Carnivore {
    void eats();
    void isNonveg();
}

class Bear implements Herbivore, Carnivore {
    public void eats() {
        System.out.println("eats both veg and non veg");
    }
    public void isNonveg() {
        System.out.println("hunts");
    }
    public void isVeg() {
        System.out.println("eats plants");
    }
}

//total abstraction
interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal(in 4 dirns");
    }
}

class Rook implements ChessPlayer {
    public void moves()
    {
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal (by 1 step");
    }
}
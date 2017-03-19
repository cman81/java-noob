import java.util.Random;

public class Dice {
    int dice1;
    int dice2;
    
    public Dice() {
        throwMe();
    }
    
    void throwMe() {
        Random rand = new Random();
        dice1 = rand.nextInt(6) + 1;
        dice2 = rand.nextInt(6) + 1;
    }
    
    int getTotal() {
        return dice1 + dice2;
    }
    
}

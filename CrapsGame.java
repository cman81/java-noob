/**
 * Play a game of craps with yourself. Stick to OO concepts
 */
public class CrapsGame {
    Dice dice = new Dice();
    int point = 0; // this can be 4, 5, 6, 8, 9, or 10
    boolean isWinner = false;
    
    public static void main(String []args) {
        CrapsGame game = new CrapsGame();
        
        System.out.println("Welcome to the Craps game!");
        
        while (true) {
            game.dice.throwMe();
            int thisRoll = game.dice.getTotal();
            System.out.println(String.format(
                "The dice are currently set to %d",
                thisRoll
            ));
            
            if (game.point == 0) {
                if (!game.establishPoint(thisRoll)) {
                    break;
                }
            } else {
                if (game.determineResult(thisRoll)) {
                    break;
                }
            }
        }
    }
    
    /**
     * Returns true if we can establish the point number and keep playing,
     * otherwise returns false because we rolled a 2, 3, 7, 11, or 12)
     */
    public boolean establishPoint(int thisRoll) {
        // establish the point number
        if (thisRoll == 7 || thisRoll == 11) {
            isWinner = true;
            return false;
        }
        if (thisRoll == 2 || thisRoll == 3 || thisRoll == 12) {
            isWinner = false;
            return false;
        }

        point = thisRoll;
        return true;
    }
    
    public boolean determineResult(int thisRoll) {
        if (thisRoll == point) {
            isWinner = true;
            return true;
        }
        if (thisRoll == 7) {
            isWinner = false;
            return true;
        }
        
        return false;
    }
}

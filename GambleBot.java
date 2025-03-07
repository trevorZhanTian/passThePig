public class GambleBot extends Player{
    private int score;
    private int hand;
    private String strategy = "Gamble Strategy";

    public GambleBot(String name) {
        super(name);
    }

    public String getStrategy() {
        return strategy;
    }

    public void updateScore() {
        score += hand;
        super.setScores(score);
    }

    public void updateHand() {
        hand = 0;

        if (hand != 0) {
            System.out.println(super.getName() + " decides to keep going.");
            System.out.println();
        }
        
        for (int i = 0; i < 10; i++) {
            int newHand = Pigs.getHand();
            String[] handNames = Pigs.getHandName();
            System.out.println(super.getName() + " gets a " + handNames[0] + " and a " + handNames[1] + ".");
            System.out.println(super.getName() + " gets " + newHand + " points!");
            hand += newHand;

            if (newHand == 0) {
                hand = 0;
                break;
            }

            if (score + hand > 100) {
                System.out.println(super.getName() + " has " + (score + hand) + " points.");
                break;
            }

            System.out.println(super.getName() + " can stop with " + (score + hand) + " points.");
        }

        if (hand == 0) {
            System.out.println(super.getName() + " pig out!");
            System.out.println();
        } else if (score + hand > 100) {
            System.out.println(super.getName() + " wins the game!");
        } else {
            System.out.println(super.getName() + " decides to stop");
            System.out.println();
        }

    }

}

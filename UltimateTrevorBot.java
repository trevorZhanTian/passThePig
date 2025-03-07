import java.util.ArrayList;

public class UltimateTrevorBot extends Player {
    private String strategy = "Ultimate Trevor Strategy";
    private int score;
    private int hand;
    private int index;

    public UltimateTrevorBot(String name, int index) {
        super(name, index);
    }

    public static double map(int value, int min, int max, double min1, double max1) { // inspired by built-in method
                                                                                      // "map" in Processing
        return min1 + (value - min) * (max1 - min1) / (max - min);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        int defaultExpectedScore = 19;

        // keep rolling if under expectedscore, stop if exceed
        // plus or minus constant the difference to the hightest score and how close the
        // bot and other players are to winning

        int leadingCompare = myScore - super.getHighestScore();
        double leadingCompareOffset = map(leadingCompare, winningScore * -1, winningScore, 0.4, -0.4); // convert from a
                                                                                                       // scale of
                                                                                                       // (-100, 100) to
                                                                                                       // (0.5, -0.4)

        int leaderWinningDistance = winningScore - super.getHighestScore();
        double leaderWinningDistanceOffset = map(leaderWinningDistance, 100, 1, 0, 0.4); // convert from a scale of
                                                                                         // (100, 1) to (0, 0.5)

        int myWinningDistance = winningScore - myScore;
        double myWinningDistanceOffset = map(myWinningDistance, 100, 1, 0.3, -0.3); // convert from a scale of (100, 1)
                                                                                    // to (0.4, -0.3)

        double expectedScoreConstant = 1 + leadingCompareOffset + leaderWinningDistanceOffset + myWinningDistanceOffset;

        return hand < defaultExpectedScore * expectedScoreConstant;
    }

    public void updateScore() {
        score += hand;
        super.setScores(score);
    }

    public ArrayList<Integer> getOtherScores() {
        ArrayList<Integer> scoresCopy = super.getScores();
        ArrayList<Integer> otherScores = new ArrayList<Integer>();
        for (int i = 0; i < scoresCopy.size(); i++) {
            if (i != index) {
                otherScores.add(scoresCopy.get(i));
            }
        }
        return otherScores;
    }

    public void updateHand() {
        hand = 0;
        while (wantsToRoll(score, hand, getOtherScores(), passThePig.winningScore)) {
            if (hand != 0) {
                System.out.println(super.getName() + " decides to keep going.");
                System.out.println();
            }

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

    public String getStrategy() {
        return strategy;
    }
}

import java.util.ArrayList;

public class UltimateTrevorBot extends Player {
    private int score;
    private int hand;
    private int index;

    public UltimateTrevorBot (String name, int index) {
        super(name, index);
    }

    public static double map (int value, int min, int max, double min1, double max1) {  //inspired by built-in method "map" in Processing
        return value + (value - min) / (max - min) * (max1 - min1);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        int defaultExpectedScore = 21;

        //keep rolling if under expectedscore, stop if exceed
        // plus or minus constant the difference to the hightest score and how close the bot and other players are to winning

        int leadingCompare = myScore - super.getHighestScore();
        double leadingCompareOffset = map(leadingCompare, winningScore*-1, winningScore, 0.5, -0.4);    //convert from a scale of (-100, 100) to (0.5, -0.4)

        int leaderWinningDistance = winningScore - super.getHighestScore();
        double leaderWinningDistanceOffset = map(leaderWinningDistance, 100, 1, 0, 0.5);    //convert from a scale of (100, 1) to (0, 0.5)

        int myWinningDistance = winningScore - myScore;
        double myWinningDistanceOffset = map(myWinningDistance, 100, 1, 0.4, -0.3);    //convert from a scale of (100, 1) to (0.4, -0.3)
        
        double expectedScoreConstant = 1 + leadingCompareOffset + leaderWinningDistanceOffset + myWinningDistanceOffset;

        return hand < defaultExpectedScore * expectedScoreConstant;
    }

    public void updateScore() {
        score += hand;
        super.setScores(score);
    }

    public ArrayList<Integer> getOtherScores() {
        ArrayList<Integer> otherScores = super.getScores();
        otherScores.remove(index);
        return otherScores;
    }

    public void updateHand() {
        hand = 0;
        while (wantsToRoll(score, hand, getOtherScores(), passThePig.winningScore)) {
            hand += Pigs.getHand();
        }
    }

    public int getScore() {
        return score;
    }
}

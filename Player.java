import java.util.ArrayList;

public class Player {
    private String name;
    private String strategy;
    private boolean wantsToRoll;
    private int index;
    private static ArrayList<Integer> scores;

    public Player(String name, int index) {
        this.name = name;
        this.index = index;
        scores.add(0);
    }

    public static int getHighestScore() {
        int hightestScore = scores.get(0);
        for (int num : scores) {
            if (num > hightestScore) {
                hightestScore = num;
            }
        }
        return hightestScore;
    }

    public static ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores (int score) {
        scores.set(index, score);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return wantsToRoll;
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }
}

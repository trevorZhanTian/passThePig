public class Player {
    private String name;
    private String strategy;

    public Player(String name) {
        this.name = name;
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

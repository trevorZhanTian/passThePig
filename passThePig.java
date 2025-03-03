import java.util.ArrayList;

class Player {
    private String name;
    private String strategy;

    public Player(String name) {
        this.name = name;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return boolean wantsToRoll;
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy
    }

}

class BotPlayer extends Player{
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

    }
}

class HumanPlayer extends Player{

}

public class passThePig {
    public static void main (String[]args) {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new BotPlayer("AlwaysRollBot"));
        players.add(new SchemerBot("SchemerBot"));
        players.add(new RiskyBotPlayer("RiskyBot"));
        players.add(new WimpyBotPlayer("WimpyBot"));
    }
}
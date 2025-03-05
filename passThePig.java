import java.util.ArrayList;

public class passThePig {
    public static void main (String[]args) {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new BotPlayer("TBot1"));
        players.add(new SchemerBot("TBot2"));
        players.add(new RiskyBotPlayer("Tbot3"));
        players.add(new WimpyBotPlayer("Tbot4"));

        System.out.println("1");
    }
}
import java.util.ArrayList;

public class passThePig {

    public static int winningScore = 100;
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static void main (String[]args) {
        System.out.println("Welcome to Pass The Pigs!");
        System.out.println();

        players.add(new UltimateTrevorBot("TBot0", 0));
        players.add(new UltimateTrevorBot("TBot1", 1));
        players.add(new UltimateTrevorBot("TBot2", 2));
        players.add(new UltimateTrevorBot("TBot3", 3));
        players.add(new HumanPlayer("Trevor"));

        // for(int i = 0; i < .length; i++){
        //     players.get(i).
        // }

        // int[] scores = new int[players.size()];
        
        while (Player.getHighestScore() < winningScore) {
            for (Player player: players) {
                // int n = 0;
                player.updateHand();
                player.updateScore();            
                // ((UltimateTrevorBot)player).updateHand();
                // ((UltimateTrevorBot)player).updateScore();
                // scores[n] = ((UltimateTrevorBot)player).getScore();
                // n++;
                printScores();

                if (Player.getHighestScore() >= winningScore) {
                    break;
                }
            }
        }
    }   

    public static void printScores() {
        for (int i = 0; i < players.size(); i++) {
            System.out.print("------------");
        }
        System.out.println();
        System.out.println();
        System.out.print("| ");  
        for (Player player: players) {
            System.out.print(player.getName() + ": " + player.getScore() + " | ");
        }
        System.out.println();
        System.out.println();          
    }
}
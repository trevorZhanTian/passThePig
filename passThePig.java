import java.util.ArrayList;

public class passThePig {

    public static int winningScore = 100;
    public static void main (String[]args) {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new UltimateTrevorBot("TBot0", 0));
        players.add(new UltimateTrevorBot("TBot1", 1));
        players.add(new UltimateTrevorBot("TBot2", 2));
        players.add(new UltimateTrevorBot("TBot3", 3));

        int[] scores = new int[players.size()];
        
        while (Player.getHighestScore() < winningScore) {
            for (Player player: players) {
                int n = 0;
                ((UltimateTrevorBot)player).updateHand();
                ((UltimateTrevorBot)player).updateScore();
                scores[n] = ((UltimateTrevorBot)player).getScore();
                n++;

                System.out.println("-----------------------------");
                System.out.println();
                System.out.println(Player.getScores());       
                System.out.println();         
                System.out.println("-----------------------------");
                

                System.out.println();
                System.out.println();
            }
        }



        // System.out.println(Pigs.getPoints());
        // System.out.println(Pigs.pigs[0]);
        // System.out.println(Pigs.pigs[1]);

        // System.out.println("1");
        // // test
    }   
}
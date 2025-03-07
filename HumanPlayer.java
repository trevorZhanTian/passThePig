import java.util.Scanner;

public class HumanPlayer extends Player {
    private int score;
    private int hand;

    public HumanPlayer(String name) {
        super(name);
    }

    public void updateScore() {
        score += hand;
        super.setScores(score);
    }

    public void updateHand() {
        hand = 0;
        boolean wantsToRoll = true;
        Scanner sc = new Scanner(System.in);

        while (wantsToRoll) {
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

            System.out.print("Continue? (y/n): ");
            String answer = sc.nextLine();
            System.out.println();
            if (answer.equals("n")) {
                wantsToRoll = false;
            }
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

import java.util.Random;

public class Pigs {
    public static String[] pigs = new String[2];
    public static int[] points  = new int[2];

    public static String[] getHandName() {
        return pigs;
    }

    public static int getHand() {
        
        for (int i = 0; i <2; i++) {
            int randomNum = new Random().nextInt(1000)+1;
            if (randomNum <= 349) {
                pigs[i] = "Dot";
                points[i] = 1;
            } else if (349 < randomNum && randomNum <= 651) {
                pigs[i] = "No Dot";
                points[i] = 1;
            } else if (651 < randomNum && randomNum <= 875) {
                pigs[i] = "Razorback";
                points[i] = 5;
            } else if (875 < randomNum && randomNum <= 963) {
                pigs[i] = "Trotter";
                points[i] = 5;
            } else if (963 < randomNum && randomNum <= 993) {
                pigs[i] = "Snouter";
                points[i] = 10;
            } else if (993 < randomNum && randomNum <= 1000) {
                pigs[i] = "Leaning Jowler";
                points[i] = 15;
            }   
        }

        if (points[0] + points[1] == 2) {
            if (pigs[0].equals(pigs[1])) {
                return 1;
            } else {
                return 0;
            }
        }

        if (pigs[0].equals(pigs[1])) {
            return (points[0] + points[1]) * 2;
        } else if ((points[0] + points[1]) % 5 == 1) {  //means one of the pig is "Dot" or "No Dot"
            return points[0] + points[1] - 1;
        } else {
            return points[0] + points[1];
        }
    }
}

// Rolling Probabilities
// Dot
// 34.90%
// No Dot	
// 30.20%
// Razorback
// 22.40%
// Trotter
// 8.80%
// Snouter
// 3.00%
// Leaning Jowler
// 0.70%

// Razorback
// 5 (20 for 2)
// Trotter
// 5 (20 for 2)
// Snouter
// 10 (40 for 2)
// Leaning Jowler
// 15 (60 for 2)
// Double Dots
// 1
// Double No Dots
// 1
// Dot & No Dot	
// Pig out!


import java.util.*;

public class Game {

    Random random = new Random();
    public HashSet<Integer> winSet;
    //include data to represent the "Winning lottery numbers"

    public Game(){
        winSet = new HashSet<Integer>();
    }

    //generates and stores 5 unique random numbers between 1 and 42.
    public void winningLotNumber(){
        winSet.clear();
        while(winSet.size() < 5){
            winSet.add(random.nextInt(1, 42));
        }
        //System.out.println("Winning Set: " + Arrays.toString(winSet.toArray()));
    }

    public int numMatch(HashSet<Integer> playerNums){
        //print sets being compared
        System.out.println("Winning Numbers: " + winSet);
        System.out.println("Player Numbers: " + playerNums);
        //compare sets and count matches
        int matchCount = 0;
        Object[] playNums = playerNums.toArray();
        for(Object val: playNums){
            if(winSet.contains((Integer) val)){
                matchCount += 1;
            }
        }
        //print and return matches
        //System.out.println("Number of Matches: " + matchCount);
        return matchCount;
    }

    public float winnings(int matches){
        //print and return cash winnings for each amount of matches
        switch (matches) {
            case 1 -> {
                System.out.println("Winnings: $" + 0.0f + "\n");
                return 0.0f;
            }
            case 2 -> {
                System.out.println("Winnings: $" + 1.0f + "\n");
                return 1.0f;
            }
            case 3 -> {
                System.out.println("Winnings: $" + 10.86f + "\n");
                return 10.86f;
            }
            case 4 -> {
                System.out.println("Winnings: $" + 197.53f + "\n");
                return 197.53f;
            }
            case 5 -> {
                System.out.println("Winnings: $" + 212534.83f + "\n");
                return 212534.83f;
            }
        }
        System.out.println("Winnings: $" + -1.0f + "\n");
        return -1.0f;
    }
}

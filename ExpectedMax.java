import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExpectedMax {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int iterations = 10000;
        int numDice = 2;
        //edit this variable to change the number of sides the dice has

        System.out.println("How many sides?");
        int numSides = input.nextInt();

        ArrayList<Dice> dice = new ArrayList<>();

        for(int i = 0; i < numDice; i++){
            dice.add(new Dice(numSides));
            //creates a list of dice
        }

        int averageMax = 0;

        for(int i = 0; i < iterations; i ++){
            //rolls all the dice in the list and gets the expected max.
            int maxOfNRolls;
            ArrayList<Integer> allRolls = new ArrayList<>();
            for (Dice die : dice) {
                allRolls.add(die.roll());
            }
            maxOfNRolls = Collections.max(allRolls);

            averageMax += maxOfNRolls;
        }
        int finalOutcome = averageMax/iterations;
        System.out.println(finalOutcome);
    }
}

record Dice(int sides) {
    public int roll() {
        return (int) Math.ceil(Math.random() * sides);
    }
    //this record object is just used as a stand in for a die
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import javax.swing.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        final int max_turn =10;
        final int range=100;

        int score=0;
        System.out.println("Welcome to number guessing game");
        Random random=new Random();
        int the_num = random.nextInt(range)+1;
            for (int turn = 1; turn<=max_turn;turn++) {

                System.out.println(" Your Attempt : " + turn);
                System.out.println("Your Score : " + score);
                System.out.println("Number of allowed attempts: " + max_turn);

                try {
                  String input=JOptionPane.showInputDialog("ENTER YOUR GUESS !");
                  int guess=Integer.parseInt(input);
                    if (the_num== guess) {
                        System.out.println("Congratulations you have won");
                        score = score + 100;
                        System.out.println("Here's your score " + score);
                        break;
                    } else if (the_num > guess) {
                        System.out.println("The number is higher than " + guess);
                    } else {
                        System.out.println("The number is lower than " + guess);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.Attempt will not be considered");
                    turn--;
                }
            }
            JOptionPane.showMessageDialog(null, " THE NUMBER WAS "+ the_num + " YOUR SCORE " +score);




    }
}
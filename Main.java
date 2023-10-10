
/**
 * Write a description of class Main here.
 *
 * @author (Main)
 * @version (In development as of 14/9/2023)
 */
import java.util.Scanner;
public class Main
{
    public Scanner inputStream = new Scanner(System.in);
    public int playerOneScore = 0;
    public int playerTwoScore = 0;
    public boolean playerOneCooperates;
    public boolean playerTwoCooperates;
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        welcome();
    }

    /*
     * This method prints a welcome message and menu to start the game or view instructions.
     */
    public void welcome(){
        System.out.println("WHAT IS THIS?\nThis is a Prisoners dilemma game that I made in java.\nFor infomation on how to play, press i\nTo play the game, press p");

        String input = getString();

        if(input.toLowerCase().equals("i")) instructions();
        else if(input.toLowerCase().equals("p")) startGame();
        else return;
    }
    
    /*
     * Gets String from the user.
     */
    public String getString(){
        String stringGet;
        stringGet = inputStream.nextLine();
        return stringGet;
    }

    /*
     * Prints instructions and start game menu.
     */
    public void instructions(){
        System.out.println("How to play:");
        System.out.println("There are 2 prisoners who have been accused of a crime and have been taken in for questioning.\nBoth Prisoners are put in different rooms where they are questioned.\nThey both have the option to cooperate with one another or defect.\nIf both prisoners cooperate then they will get 1 year in prison.\nIf they both defect then they both get 3 years in prison.\nIf one cooperates and the other defects then the prisoner who defected will get off scot free but the other prisoner will get 5 years in prison.\n");
        System.out.println("Press p to start game.");

        String input = getString();

        if(input.toLowerCase().equals("p")) startGame();
        else return;
    }

    /*
     * Iterates rounds until a player loses and then prints the result
     */
    public void startGame(){
        System.out.print('\u000C');
        
        //Iterates rounds until losing score is met
        boolean continueRounds = true;
        while(continueRounds){
            round();
            if(playerOneScore >= 15 || playerTwoScore >= 15){
                continueRounds = false;
            }  
        }

        //After losting score is met the highest value will be specified.
        System.out.println("GAME OVER!!");
        if(playerOneScore < playerTwoScore){
            System.out.println("Player one wins!");
        }
        else if(playerOneScore > playerTwoScore){
            System.out.println("Player 2 wins!");
        }
        else{
            System.out.println("Tie!");
        }
    }

    /*
     * A single round of the game. Gives player options to cooperate and defect and takes input
     */
    public void round(){
        //Player one
        System.out.println("Player 1:");
        System.out.println("Press c to cooperate\nor press d to defect.");

        String input = getString();

        if(input.toLowerCase().equals("c")) playerOneCooperates = true;
        else if(input.toLowerCase().equals("d")) playerOneCooperates = false;
        else return;

        System.out.print('\u000C');

        //Player two
        System.out.println("Player 2:");
        System.out.println("Press c to cooperate\nor press d to defect.");

        String input2 = getString();

        if(input2.toLowerCase().equals("c")) playerTwoCooperates = true;
        else if(input2.toLowerCase().equals("d")) playerTwoCooperates = false;
        else return;
        System.out.print('\u000C');

        calculateScore(playerOneCooperates, playerTwoCooperates);
    }
    /*
     * Calculates the prison sentence based on what options the users picked.
     */
    public void calculateScore(boolean playerOneCooperate, boolean playerTwoCooperate){
        if(playerOneCooperate && playerTwoCooperate){
            playerOneScore++;
            playerTwoScore++;
        }
        if(playerOneCooperate && !playerTwoCooperate){
            playerOneScore += 5;
        }
        if(!playerOneCooperate && playerTwoCooperate){
            playerTwoScore += 5;
        }
        if(!playerOneCooperate && !playerTwoCooperate){
            playerOneScore += 3;
            playerTwoScore += 3;
        }
        System.out.println("Player 2 gets " +playerTwoScore+" years");
        System.out.println("Player 1 gets " +playerOneScore+" years");
    }
}

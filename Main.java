
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
     * Prints player options and takes players choices.
     */
    public void startGame(){
        //Player one
        System.out.print('\u000C');
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

        calculateScore();
    }
    /*
     * Calculates the prison sentence based on what options the users picked.
     */
    public void calculateScore(){
        if(playerOneCooperates && playerTwoCooperates){
            playerOneScore++;
            playerTwoScore++;
        }
        if(playerOneCooperates && !playerTwoCooperates){
            playerOneScore += 5;
        }
        if(!playerOneCooperates && playerTwoCooperates){
            playerTwoScore += 5;
        }
        if(!playerOneCooperates && !playerTwoCooperates){
            playerOneScore += 3;
            playerTwoScore += 3;
        }
        System.out.println("Player 1 gets " +playerOneScore+" years");
        System.out.println("Player 2 gets " +playerTwoScore+" years");

    }
    public void rounds(){
        
    }
}

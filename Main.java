
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

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        welcome();
    }
    
    public void welcome(){
        // This is the welcmome message/instructions.
        //System.out.println("");
        System.out.println("WHAT IS THIS?\nThis is a Prisoners dilemma game that I made in java.\nFor infomation on how to play, press i\nTo play the game, press p");

        String input = getString();

        if(input.toLowerCase().equals("i")) instructions();
        else if(input.toLowerCase().equals("p")) startGamePlayerOne();
        else return;
    }
    
    public String getString(){
        String stringGet;
        stringGet = inputStream.nextLine();
        return stringGet;
    }
    // This is where you are told how the game works and how to play it.
    public void instructions(){
        System.out.println("How to play:");
        System.out.println("There are 2 prisoners who have been accused of a crime and have been taken in for questioning.\nBoth Prisoners are put in different rooms where they are questioned.\nThey both have the option to cooperate with one another or defect.\nIf both prisoners cooperate then they will get 1 year in prison.\nIf they both defect then they both get 3 years in prison.\nIf one cooperates and the other defects then the prisoner who defected will get off scot free but the other prisoner will get 5 years in prison.\n");
        System.out.println("Press p to start game.");

        String input = getString();

        if(input.toLowerCase().equals("p")) startGamePlayerOne();
        else return;
    }
}
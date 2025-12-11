
/**
 * abcd
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class TestClass
{

    //main
    public static void main(String[] args)
    {
        //variables for game decision structure
        byte GameDecision;
        boolean bolDoWhile = true;
        
        //menu display
        System.out.println("____ Welcome to DragonCraft ____");
        
        System.out.println("1. Enter \n2. Exit game");
        
        //error trap repeat if error found
        do
        {
            //call game class if input is 1
            GameDecision = new Scanner(System.in).nextByte();
            if(GameDecision == 1)
            {
                Game app = new Game();
                app.startBattle();
                bolDoWhile = false;
            }
            //end game if input is 2
            else if (GameDecision == 2)
            {
                System.out.println("____ Exiting DragonCraft ____");
                startUp();
                bolDoWhile = false;                        
            }
            //if not 1 or 2 make user re input
            else
            {
                System.out.println("Error please input 1 or 2");
                bolDoWhile =  true;
            }
        }while (bolDoWhile == true);
    }

    //method output menu message
    public static void startUp()
    {
        System.out.println("Rise as a dragon rider and battle the chaos consuming the land.");
    }
}

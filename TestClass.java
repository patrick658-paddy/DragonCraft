
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
        byte GameDecision;
        boolean bolDoWhile = true;
        
        System.out.println("____Welcome to DragonCraft____");
        
        System.out.println("1. Enter \n2. Exit game");
        
        do
        {
            GameDecision = new Scanner(System.in).nextByte();
            if(GameDecision == 1)
            {
                Game app = new Game();
                app.startBattle();
            }
            else if (GameDecision == 2)
            {
                                    
            }
            else
            {
                System.out.println("Error please input 1 or 2");
                bolDoWhile =  true;
            }
        }while (bolDoWhile == true);
    }
    
   

    
    public static void startUp()
    {
        System.out.println("Rise as a dragon rider and battle the chaos consuming the land.");
    }
}

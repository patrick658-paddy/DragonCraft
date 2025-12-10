
/**
 * Description: abcd .
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
    //declare variables
    String strName;
    ArrayList<Dragon> DragonList = new ArrayList<>();
    byte bytActiveDragon;
    
    public Player(String n, ArrayList<Dragon> d, byte ad)
    {
        this.strName = n;
        this.DragonList = d;
        this.bytActiveDragon = ad;
    }
     public Player()
    {
        this.strName = "Unknown";
        this.bytActiveDragon = -1;
    }
    
    //method to pick active dragon
    public void pickDragon()
    {
        byte bytDragon = 0;
        String Dragon = "";
        boolean doWhile = true;

        
        do
        {
            System.out.println("Do you want to change dragons? \nYes \nNo");
            Dragon = new Scanner(System.in).nextLine().toUpperCase();
            if(Dragon == "YES")
            {
                bytDragon++;
                doWhile = false;
                
                System.out.println("Dragon selected " + DragonList.get(bytDragon));
                
            }
            else if (Dragon == "NO")
            {
                doWhile = false;
            }
            else
            {
                System.out.println("Error Please input Yes or No");
                doWhile = true;
            }
        }
        while (doWhile == true);

    }
    
}
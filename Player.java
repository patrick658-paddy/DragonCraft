
/**
 * Description: .
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
    String strName;
    ArrayList<Dragon> DragonList = new ArrayList<>();
    byte bytActiveDragon;
    
    public Player(String n, ArrayList<Dragon> d, byte ad)
    {
        this.strName = n;
        this.DragonList = d;
        this.bytActiveDragon = ad;
    }
    
    public void pickDragon()
    {
        System.out.println("Pick your Dragon");
        
    }
    
    public void upgradeDragon(byte bytLevel)
    {
        String Upgrade;
        boolean doWhile = true;
        System.out.println("Do you want to upgrade your active Dragon? \nYes \nNo");
        
        Upgrade = new Scanner(System.in).nextLine().toUpperCase();
        do
            if(Upgrade == "YES")
            {
                doWhile = false;
                
            }
            else if (Upgrade == "NO")
            {
                doWhile = false;
            }
            else
            {
                System.out.println("Error Please input Yes or No");
                doWhile = true;

            }
        while (doWhile == true);
    }
}
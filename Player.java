
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
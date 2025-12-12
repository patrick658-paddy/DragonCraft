
/**
 * Description: This class will create the player's dragons allow the player to switch their dragon being used and choose the move the player wants to do.
 *
 * @author (Eric, Paddy, Abdulla)
 * @version (15 Dec, 2025)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
    //declare variables
    String strName;
    ArrayList<Dragon> DragonList = new ArrayList<>();
    byte bytActiveDragon;
    
    public Player(String n)
    {
        this.strName = n;
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
    
    // get dragon amount in their roster
    public byte getDragonAmount()
    {
        return (byte)(this.DragonList.size());
    }
    
    public String outputAllDragon()
    {
        String out="";
        for(int i=0;i<this.DragonList.size();i++)
        {
            out+="\n Dragon" +(i+1);
            out+=this.DragonList.get(i);
        }
        return out;
    }
    
    public byte ChooseMove()
    {
        byte ChooseMove;
        boolean bolDoWhile = true;
        
        System.out.println("Choose your move \n1-4");
        
        do
        {
            ChooseMove = new Scanner(System.in).nextByte();
            if(ChooseMove >= 4 || ChooseMove < 0)
            {
                bolDoWhile = false;
            }
            else
            {
                System.out.println("Error please input 1-4");
                bolDoWhile = true;
            }
        } while(bolDoWhile == true);
        
        return ChooseMove;
    }
}
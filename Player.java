
/**
 * Description: .
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
        
    }
}
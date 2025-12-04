
/**
 * Write a description of class Dragon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Dragon
{
    //initialize all instance variable of a dragon
    String name;
    short maxHp;
    short health;
    byte level;
    short xp;
    short armor;
    ArrayList<Moves> moveList =new ArrayList<Moves>();
    String statusEffect;
    short sp;
    
    public Dragon(String n,short m,byte l,short a,ArrayList<Moves>mo,short s )
    {
        this. name=n;
        this. maxHp=m;
        this.health=this.maxHp;
        this.level=l;
        this.xp=0;
        this.armor=a;
        this.moveList=mo;
        this.statusEffect="NULL";
        short sp=s;
    }
    
    
}
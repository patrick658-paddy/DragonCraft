
/**
 * Write a description of class Dragon here.
 *
 * @author (your strName)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Dragon
{
    //initialize all instance variable of a dragon
    String strName;
    short shrMaxHp;
    short shrHealth;
    byte bytLevel;
    short shrXp;
    short shrArmor;
    ArrayList<Moves> moveList =new ArrayList<Moves>();
    String strStatusEffect;
    short shrSp;
    
    public Dragon(String n,short m,byte l,short a,ArrayList<Moves>mo,short s )
    {
        this. strName=n;
        this. shrMaxHp=m;
        this.shrHealth=this.shrMaxHp;
        this.bytLevel=l;
        this.shrXp=0;
        this.shrArmor=a;
        this.moveList=mo;
        this.strStatusEffect="NULL";
        short shrSp=s;
    }
    
    
    public void attack(Dragon target, Moves move)
    {
        
    }
    
    
    
}
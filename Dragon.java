
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
    short shrAttack;
    byte bytLevel;
    short shrXp;
    short shrArmor;
    byte bytType; //1 = fire, 2 =  ice, 3 = water, 4 = lighting, 5 = earth  
    ArrayList<Moves> moveList =new ArrayList<Moves>();
    String strStatusEffect;
    short shrSp;
    //constructor to initilize the atat for each dragon
    public Dragon(String n,short m,short a,byte l,short d,byte t ,ArrayList<Moves>mo,short s )
    {
        this. strName=n;
        this. shrMaxHp=m;
        this.shrHealth=this.shrMaxHp;
        this.shrAttack=a;
        this.bytLevel=l;
        this.shrXp=0;
        this.shrArmor=d;
        this.bytType=t;
        this.moveList=mo;
        this.strStatusEffect="NULL";
        short shrSp=s;
    }
    
    
    public void attack(Dragon target, Moves move, Battlefield arena)
    {
        //calculate did the move's status effect lands
        byte random=(byte)((Math.random()*100)+1);
        //save the damage amount it will deal 
        int damage=0;
        //check is the number in range to apply a status effect
        if(random<=move.fltEffectChance*100)
        {
            //assign the effect onto the dragon
            this.strStatusEffect=move.strEffectName;
            
        }
        //populate the variable with the base damage it will deal;
        damage=move.shrDmg+this.shrAttack;
        //check which type is the move
        if(move.bytType==1)
        {
            //if it is a fire type move check enemy's dragon type and modify the damage base on the type chart
            if(target.bytType==2)
            {
                //if target is ice buff damage
                damage*=1.2;
            }
            if(target.bytType==3)
            {
                //if target is water nerff damage
                damage*=0.8;
            }
            if(target.bytType==5)
            {
                //if target is groud nerff damage
                damage*=0.8;
            }
        }
        else if(move.bytType==2)
        {
            //if the attack is ice type
            if(target.bytType==2)
            {
                //if target is ice buff damage
                damage*=1.2;
            }
            if(target.bytType==3)
            {
                //if target is water nerff damage
                damage*=0.8;
            }
            if(target.bytType==5)
            {
                //if target is groud nerff damage
                damage*=0.8;
            }
        }
        
        
        
    }
    
    
    
}
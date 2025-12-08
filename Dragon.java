
/**
 * Description: .
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
    public Dragon(String n,short m,short a,byte l,short d,byte t ,ArrayList<Moves>mo )
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
        short shrSp=0;
    }
    
    
    public int attack(Dragon target, Moves move, Battlefield arena)
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
            if(target.bytType==1)
            {
                //nerf damage
                damage*=0.8;
            }
            if(target.bytType==3)
            {
                //if target is water buff damage
                damage*=1.2;
            }
            if(target.bytType==5)
            {
                //if target is lighting nerff damage
                damage*=0.8;
            }
        }
        else if(move.bytType==3)
        {
            //if attack is water type
            if(target.bytType==1)
            {
                //buff damage
                damage*=1.2;
            }
            if(target.bytType==2)
            {
                //buff damage
                damage*=0.8;
            }
            if(target.bytType==4)
            {
                //buff damage
                damage*=0.8;
            }
            if(target.bytType==5)
            {
                //buff damage
                damage*=1.2;
            }
            
        }
        else if(move.bytType==4)
        {
            //if attack is water type
            if(target.bytType==5)
            {
                //nerf
                damage*=0.8;
            }
            if(target.bytType==2)
            {
                //buff damage
                damage*=1.2;
            }
            if(target.bytType==3)
            {
                //buff damage
                damage*=1.2;
            }
            if(target.bytType==4)
            {
                //buff damage
                damage*=0.8;
            }
            
        }
        else if(move.bytType==5)
        {
            //if attack is water type
            if(target.bytType==3)
            {
                //nerf
                damage*=0.8;
            }
            if(target.bytType==4)
            {
                //buff damage
                damage*=1.2;
            }
            if(target.bytType==2)
            {
                //buff damage
                damage*=1.2;
            }
            if(target.bytType==5)
            {
                //buff damage
                damage*=0.8;
            }
            
        }
        
        //now inplement arena buff or nerff
        damage=arena.applyModifier(move.bytType,damage);
        // add xp to the dragon
        this.shrXp=(byte)((Math.random()*100)+100);
        //prompt the user they gained this amount of xp
        System.out.println("You got " + this.shrXp + " xp. "+(100+(100*this.bytLevel)-this.shrXp)+" Away from level up!");
        
        return damage;
    }
    
    public void takeDamage(int damage)
    {
        this.shrHealth-=damage;
        if(this.shrHealth<0)
        {
            this.shrHealth=0;
        }
    }
    
    
    public boolean isAlive()
    {
        //check if the hP is bigger than zero 
        if(this.shrHealth>0)
        {
            //return truen when alive
            return true;
        }
        else
        {
            //return false when not
            return false;
        }
    }
    
    public void levelUp()
    {
        //if xp reaches the max xp cap
        if(this.shrXp>=100+(100*this.bytLevel))
        {
            //reset the xp and make show the over part still goes back
            this.shrXp-=100+(100*this.bytLevel);
            //Level up
            this.bytLevel++;
            System.out.println("Congratulation You leveled up. You are now level " + this);
        }
        
    }
    
    //toString methods a nethod for the output if each object
    
    public String toString()
    {
        return "Dragon's name " + this. strName +" Dragon's maxHp " + this. shrMaxHp+" Dragon's attack " +
        this.shrAttack + " Dragon's defence " + this.shrArmor + " Dragon's level " + this.bytLevel + 
        " Dragon's Type " + this.bytType;
        
    }
}
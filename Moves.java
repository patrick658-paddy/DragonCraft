
/**
 * Description: This class creates the constructor for the abilities the dragons will use aswell as making output format for the moves created.
 *
 * @author (Eric, Paddy, Abdulla)
 * @version (15 Dec, 2025)
 */
public class Moves
{
    //declare variables for move
    String strName;
    byte bytType;
    short shrDmg;
    boolean bolIsHeal;
    float fltEffectChance;
    String strEffectName;
    short shrSkillCost;
    short shrSkillGrant;

    //constructor 
    public Moves(String n, byte t, short d, boolean h, float e, String s, short c, short g)
    {
        this.strName = n;
        this.bytType = t;
        this.shrDmg = d;
        this.bolIsHeal = h;
        this.fltEffectChance = e;
        this.strEffectName = s;
        this.shrSkillCost = c;
        this.shrSkillGrant = g;
    }
    
    //toString
    public String toString()
    {
        return this.strName + "\nType: " + this.bytType + "\nDamage: " + this.shrDmg + "\nHeal? " 
        + this.bolIsHeal + "\nEffect:" + this.strEffectName + "\nSkill Cost: " + this.shrSkillCost + "\nSkill Grant: "
        + this.shrSkillGrant;
    }
}
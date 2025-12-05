
/**
 * Write a description of class Moves here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Moves
{
    String strName;
    byte bytType;
    short shrDmg;
    boolean bolIsHeal;
    float fltEffectChance;
    String strEffectName;
    short shrSkillCost;
    short shrSkillGrant;
    
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
    
    public String toString()
    {
        return this.strName + "\nType: " + this.bytType + "\nDamage: " + this.shrDmg + "\nHeal? " 
        + this.bolIsHeal + "\nEffect:" + this.strEffectName + "\nSkill Cost: " + this.shrSkillCost + "\nSkill Grant: "
        + this.shrSkillGrant;
    }
}
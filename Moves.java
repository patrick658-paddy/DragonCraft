
/**
 * Description: .
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
    float fltEffect;
    String strEffect;
    short shrSkillCost;
    short shrSkillGrant;
    
    public Moves(String n, byte t, short d, boolean h, float e, String s, short c, short g)
    {
        this.strName = n;
        this.bytType = t;
        this.shrDmg = d;
        this.bolIsHeal = h;
        this.fltEffect = e;
        this.strEffect = s;
        this.shrSkillCost = c;
        this.shrSkillGrant = g;
    }
}
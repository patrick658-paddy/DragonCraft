
/**
 * Write a description of class TestClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class TestClass
{
    //declare arrayList
    public void addMoves()
    {
        Moves Fireball = new Moves ("Fireball", (byte)1, (short)500, false, (float)0.1, "Burn", (short)50, (short)0);
        Moves Splash = new Moves ("Splash", (byte)2, (short)250, false,(float)0, " ", (short)10, (short)0);
        Moves Freeze = new Moves ("Freeze", (byte)3, (short)200, false, (float)0.3, "Frozen", (short)40, (short)0);
        Moves Bite = new Moves ("Bite", (byte)0, (short)400, false, (float)0, " ", (short)15, (short)0);
        Moves Heal = new Moves ("Heal", (byte)0, (short)200, true, (float)0, " ", (short)50, (short)0);
    }
    
}

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
    ArrayList<Moves> AbilityLibrary = new ArrayList<>();
    public void addMoves()
    {
        AbilityLibrary.add (new Moves ("Fireball", (byte)1, (short)500, false, (float)0.1, "Burn", (short)20, (short)0));
    }
}
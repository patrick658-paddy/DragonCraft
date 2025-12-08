
/**
 * Write a description of class TestClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class TestClass
{

    public void CreateMoves()
    {
        Moves Fireball = new Moves ("Fireball", (byte)1, (short)450, false, (float)0.2, "Burn", (short)40, (short)0);
        Moves Fireclaw = new Moves ("Fireclaw", (byte)1, (short)500, false, (float)0, " ", (short)30, (short)0);
        Moves Firebreath = new Moves ("Firebreath", (byte)1, (short)600, false, (float)0.1, "Burn", (short)50, (short)0);
        Moves Flame_Slash = new Moves ("Flame Slash", (byte)1, (short)400, false, (float)0.2, "Burn", (short)20, (short)0);
        
        Moves Splash = new Moves ("Splash", (byte)2, (short)250, false,(float)0, " ", (short)10, (short)0);
        Moves Water_Pump = new Moves ("Water Pump", (byte)2, (short)400, false, (float)0, " ", (short)20, (short)0);
        Moves Water_Shuriken = new Moves("Water Shuriken", (byte)2, (short)500, false, (float)0, "", (short)50, (short)0); 


        
        
        
        

        
        
        Moves Freeze = new Moves ("Freeze", (byte)3, (short)100, false, (float)0.6, "Frozen", (short)30, (short)0);
        Moves Icicle = new Moves ("Icicle", (byte)3, (short)400, false, (float)0.1, "Frozen", (short)40, (short)0);
        Moves Glacier = new Moves ("Glacier", (byte)3, (short)500, false, (float)0.2, "Frozen", (short)50, (short)0);
        
        Moves Earthquake = new Moves ("Earthquake", (byte)4, (short)400, false, (float)0, " ", (short)40, (short)0);
        Moves Rockslide = new Moves ("Rock Slide", (byte)4, (short)500, false, (float)0, " ", (short)50, (short)0);
        Moves Fissure = new Moves ("Fissure", (byte)4, (short)500, false, (float)0, " ", (short)50, (short)0);
        
      

        Moves Cleanse = new Moves("Cleanse", (byte)2, (short)300, true, (float)0, " ", (short)50, (short)0);
      
        
        Moves Thunderbolt = new Moves ("Thunderbolt", (byte)5, (short)500, false, (float)0.5, "Shocked", (short)50, (short)0);


       
        
        Moves Bite = new Moves ("Bite", (byte)0, (short)400, false, (float)0, " ", (short)15, (short)0);
        
        Moves Heal = new Moves ("Heal", (byte)0, (short)200, true, (float)0, " ", (short)50, (short)0);
    }

}


/**
 * abcd
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class TestClass
{

    //main
    public static void main(String[] args)
    {
        byte GameDecision;
        boolean bolDoWhile = true;
        
        System.out.println("____Welcome to DragonCraft____");
        
        System.out.println("1. Enter \n2. Exit game");
        
        do
        {
            GameDecision = new Scanner(System.in).nextByte();
            if(GameDecision == 1)
            {
                                                    
            }
            else if (GameDecision == 2)
            {
                        
            }
            else
            {
                System.out.println("Error please input 1 or 2");
                bolDoWhile =  true;
            }
        }while (bolDoWhile == true);
    }
    
    public void CreateMoves()
    {
        ArrayList<Moves> FireMovesList = new ArrayList<Moves>();
        ArrayList<Moves> WaterMovesList = new ArrayList<Moves>();
        ArrayList<Moves> IceMovesList = new ArrayList<Moves>();
        ArrayList<Moves> EarthMovesList = new ArrayList<Moves>();
        ArrayList<Moves> LightiningMovesList = new ArrayList<Moves>();
        ArrayList<Moves> BaseMovesList = new ArrayList<Moves>();
        
        FireMovesList.add(new Moves ("Fireball", (byte)1, (short)450, false, (float)0.2, "Burn", (short)40, (short)0));
        FireMovesList.add(new Moves ("Fireclaw", (byte)1, (short)500, false, (float)0, " ", (short)30, (short)0));
        FireMovesList.add(new Moves ("Firebreath", (byte)1, (short)600, false, (float)0.1, "Burn", (short)50, (short)0));
        FireMovesList.add(new Moves ("Flame Slash", (byte)1, (short)400, false, (float)0.2, "Burn", (short)20, (short)0));
        
        WaterMovesList.add(new Moves ("Splash", (byte)2, (short)250, false,(float)0, " ", (short)10, (short)0));
        WaterMovesList.add(new Moves ("Water Pump", (byte)2, (short)400, false, (float)0, " ", (short)20, (short)0));
        WaterMovesList.add(new Moves("Water Shuriken", (byte)2, (short)500, false, (float)0, "", (short)50, (short)0));
        WaterMovesList.add(new Moves("Cleanse", (byte)2, (short)300, true, (float)0, " ", (short)50, (short)0));
      
        
        IceMovesList.add(new Moves ("Freeze", (byte)3, (short)100, false, (float)0.6, "Frozen", (short)30, (short)0));
        IceMovesList.add(new Moves ("Icicle", (byte)3, (short)400, false, (float)0.1, "Frozen", (short)40, (short)0));
        IceMovesList.add(new Moves ("Glacier", (byte)3, (short)500, false, (float)0.2, "Frozen", (short)50, (short)0));
        IceMovesList.add(new Moves ("Frostbite", (byte)3, (short)350, false, (float)0.25, "Frozen", (short)30, (short)0));

        EarthMovesList.add(new Moves ("Earthquake", (byte)4, (short)400, false, (float)0, " ", (short)40, (short)0));
        EarthMovesList.add(new Moves ("Rock Slide", (byte)4, (short)500, false, (float)0, " ", (short)50, (short)0));
        EarthMovesList.add(new Moves ("Fissure", (byte)4, (short)500, false, (float)0, " ", (short)50, (short)0));
        EarthMovesList.add(new Moves ("Stone Crash", (byte)4, (short)450, false, (float)0, " ", (short)40, (short)0));

        LightiningMovesList.add(new Moves ("Thunderbolt", (byte)5, (short)500, false, (float)0.5, "Shocked", (short)50, (short)0));
        LightiningMovesList.add(new Moves ("Thunder Punch", (byte)5,(short)250, false, (float)0.6, "Shocked", (short)40, (short)0));
        LightiningMovesList.add(new Moves ("Storm Strike", (byte)5, (short)450, false, (float)0.3, "Shocked", (short)40, (short)0));
        LightiningMovesList.add(new Moves ("Volt Burst", (byte)5, (short)550, false, (float)0.4, "Shocked", (short)50, (short)0));

        BaseMovesList.add(new Moves ("Bite", (byte)0, (short)400, false, (float)0, " ", (short)15, (short)0));
        
        BaseMovesList.add(new Moves ("Heal", (byte)0, (short)200, true, (float)0, " ", (short)50, (short)0));
    }

    
    public static void startUp()
    {
        System.out.println("Rise as a dragon rider and battle the chaos consuming the land.");
    }
}

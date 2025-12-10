
/**
 * Description: .
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Game
{
    private Player player1;
    private Player player2;
    private Battlefield arena;
    Player enemy=new Player();
    static int gameCount=0;
    public void startBattle()
    {
        ArrayList<Moves> FireMovesList = new ArrayList<Moves>();
        ArrayList<Moves> WaterMovesList = new ArrayList<Moves>();
        ArrayList<Moves> IceMovesList = new ArrayList<Moves>();
        ArrayList<Moves> EarthMovesList = new ArrayList<Moves>();
        ArrayList<Moves> LightiningMovesList = new ArrayList<Moves>();
        ArrayList<Moves> BaseMovesList = new ArrayList<Moves>();
        do
        {
            CreateMoves(FireMovesList,WaterMovesList ,IceMovesList ,EarthMovesList ,LightiningMovesList,BaseMovesList);
            createRandomDragon(FireMovesList,WaterMovesList ,IceMovesList ,EarthMovesList ,LightiningMovesList,BaseMovesList);
        }while(player1.DragonList.get(player1.bytActiveDragon).isAlive()&&player2.DragonList.get(player2.bytActiveDragon).isAlive());
    }
    public void CreateMoves(ArrayList<Moves> FireMovesList,
        ArrayList<Moves> WaterMovesList ,
        ArrayList<Moves> IceMovesList ,
        ArrayList<Moves> EarthMovesList ,
        ArrayList<Moves> LightiningMovesList ,
        ArrayList<Moves> BaseMovesList)
    {
        
        
        FireMovesList.add(new Moves ("Fireball", (byte)1, (short)45, false, (float)0.2, "Burn", (short)40, (short)0));
        FireMovesList.add(new Moves ("Fireclaw", (byte)1, (short)50, false, (float)0, " ", (short)30, (short)0));
        FireMovesList.add(new Moves ("Firebreath", (byte)1, (short)60, false, (float)0.1, "Burn", (short)50, (short)0));
        FireMovesList.add(new Moves ("Flame Slash", (byte)1, (short)40, false, (float)0.2, "Burn", (short)20, (short)0));
        
        WaterMovesList.add(new Moves ("Splash", (byte)2, (short)25, false,(float)0, " ", (short)10, (short)0));
        WaterMovesList.add(new Moves ("Water Pump", (byte)2, (short)40, false, (float)0, " ", (short)20, (short)0));
        WaterMovesList.add(new Moves("Water Shuriken", (byte)2, (short)50, false, (float)0, "", (short)50, (short)0));
        WaterMovesList.add(new Moves("Cleanse", (byte)2, (short)30, true, (float)0, " ", (short)50, (short)0));
      
        
        IceMovesList.add(new Moves ("Freeze", (byte)3, (short)10, false, (float)0.6, "Frozen", (short)30, (short)0));
        IceMovesList.add(new Moves ("Icicle", (byte)3, (short)40, false, (float)0.1, "Frozen", (short)40, (short)0));
        IceMovesList.add(new Moves ("Glacier", (byte)3, (short)50, false, (float)0.2, "Frozen", (short)50, (short)0));
        IceMovesList.add(new Moves ("Frostbite", (byte)3, (short)35, false, (float)0.25, "Frozen", (short)30, (short)0));

        EarthMovesList.add(new Moves ("Earthquake", (byte)4, (short)40, false, (float)0, " ", (short)40, (short)0));
        EarthMovesList.add(new Moves ("Rock Slide", (byte)4, (short)50, false, (float)0, " ", (short)50, (short)0));
        EarthMovesList.add(new Moves ("Fissure", (byte)4, (short)50, false, (float)0, " ", (short)50, (short)0));
        EarthMovesList.add(new Moves ("Stone Crash", (byte)4, (short)45, false, (float)0, " ", (short)40, (short)0));

        LightiningMovesList.add(new Moves ("Thunderbolt", (byte)5, (short)50, false, (float)0.5, "Shocked", (short)50, (short)0));
        LightiningMovesList.add(new Moves ("Thunder Punch", (byte)5,(short)25, false, (float)0.6, "Shocked", (short)40, (short)0));
        LightiningMovesList.add(new Moves ("Storm Strike", (byte)5, (short)45, false, (float)0.3, "Shocked", (short)40, (short)0));
        LightiningMovesList.add(new Moves ("Volt Burst", (byte)5, (short)55, false, (float)0.4, "Shocked", (short)50, (short)0));

        BaseMovesList.add(new Moves ("Bite", (byte)0, (short)40, false, (float)0, " ", (short)15, (short)0));
        BaseMovesList.add(new Moves ("Tackle", (byte)0, (short)30, false, (float)0, " ", (short)15, (short)0));
        BaseMovesList.add(new Moves ("Heal", (byte)0, (short)20, true, (float)0, " ", (short)50, (short)0));
    }
    public void createRandomDragon(ArrayList<Moves> FireMovesList,
        ArrayList<Moves> WaterMovesList ,
        ArrayList<Moves> IceMovesList ,
        ArrayList<Moves> EarthMovesList ,
        ArrayList<Moves> LightiningMovesList ,
        ArrayList<Moves> BaseMovesList )
    {
        
        //generate a random dradon into the enemy roster
         //generate a random dradon into the enemy roster
         //A list of dragon name
        String[] dragons = {"Alduin", "Smaug", "Toothless", "Draco", "Firnen", 
             "Glaurung", "Ancalagon", "Saphira", "Viserion", "Rhaegal", "Drogon", 
             "Meraxes", "Vermithrax", "Falkor", "Shenron", "Norbert", "Kilgharrah", "Eborsisk", 
             "Levithan", "Hydraxis", "Pyrexis", "Obsidrax", "Stormclaw", "Ignivar", "Zephyros"};
        String dragonName =dragons[(int)(Math.random() *25)];
        //declare enemy gragon level that will get higher progressivly
        byte level=(byte)(Math.random() *5+Game.gameCount);
        short shrMaxHp=(short)(Math.random() *20+100);
        short shrAttack=(short)(Math.random() *25+50);
        short shrArmor=(short)(Math.random() *10+50);
        byte bytType=(byte)(Math.random()*4+1);
        ArrayList<Moves> moveList = new ArrayList<Moves>();
        //Use an arrayList so you can use a 
        switch(bytType)
        {
            //if fire
            case 1:
                {
                    for(int i=0;i<FireMovesList.size();i++)
                    {
                        moveList.add(FireMovesList.get(i));
                    }
                    break;
                }
            case 2:
                {
                    for(int i=0;i<IceMovesList.size();i++)
                    {
                        moveList.add(IceMovesList.get(i));
                    }
                    break;
                }
            case 3:
                {
                    for(int i=0;i<WaterMovesList.size();i++)
                    {
                        moveList.add(WaterMovesList.get(i));
                    }
                    break;
                }
            case 4:
                {
                    for(int i=0;i<LightiningMovesList.size();i++)
                    {
                        moveList.add(WaterMovesList.get(i));
                    }
                    break;
                }
            case 5:
                {
                    for(int i=0;i<EarthMovesList.size();i++)
                    {
                        moveList.add(WaterMovesList.get(i));
                    }
                    break;
                }
        }
        
        
        enemy.DragonList.add(new Dragon(dragonName,shrMaxHp,shrAttack,level,shrArmor,bytType,moveList));
         
    }
}
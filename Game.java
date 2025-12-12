
/**
 * Description: This class is the actual game that will create enemys, randomize the arena, and is where the player will be able to input to play the game.
 *
 * Paddy Ji, Abdulla, Eric
 * @version (15 Dec, 2025)
 */

import java.util.*;
public class Game
{
    private Player player1=new Player();
    private Player enemy=new Player();
    Battlefield arena;
    static int gameCount=0;
    //create arrayList to store each type of the move
    ArrayList<Moves> FireMovesList = new ArrayList<Moves>();
    ArrayList<Moves> WaterMovesList = new ArrayList<Moves>();
    ArrayList<Moves> IceMovesList = new ArrayList<Moves>();
    ArrayList<Moves> EarthMovesList = new ArrayList<Moves>();
    ArrayList<Moves> LightiningMovesList = new ArrayList<Moves>();
    ArrayList<Moves> BaseMovesList = new ArrayList<Moves>();
    //create arrayList to store all battle field
    
    public void startBattle()
    {
       
        //statement for trycatch block
        boolean tryCatch=false;
        //String thaat save any user input in String
        String answer="";
        //boolean variable shows If player all dragon was dead
        boolean isAllDead=false;
        

        //assign each move to the list
        createMoves();
        //put(declear) all arena into the arrayList
       
        //create 3 random Dragon and add it to the player's roster if they have no dragon in the team yet
        if(player1.getDragonAmount()<=0)
        {
            for(int i=0;i<3;i++)
            {
                player1.DragonList.add(createRandomDragon());
                System.out.println("----------------------------------------------");

            }
        }
        else
        {
            //If player already have dragon in their team 
            System.out.println("You met a new Dragon here stats are: ");
            //create one random dragon and ask the player do you want to switch one of your dragon with this one 
            Dragon add=createRandomDragon();
            System.out.println(player1.outputAllDragon());
            System.out.println("Here is your current roster Do you want to switch: Yes/No");
            //add a try catch block to see if the answer is valid

            do
            {
                answer=new Scanner(System.in).nextLine();
                //If answer is not yes or no
                if(!(answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("no")))
                {
                    //switch the variable to true so it will re run the loop again
                    tryCatch =true;
                    System.out.println("Answer invalid please enter yes or no");
                }
            }
            while (tryCatch == true);

            //check if player want to swtich their Dragon

            if(answer.equalsIgnoreCase("yes"))
            {
                changeDragon(add);
                System.out.println(player1.outputAllDragon());
            }

            
        }
        //game loop between battle(a run) only stops looping when all players dragon are dead
        
        do 
        {
            //generate a random  for arena 
            arena=arena.getRandomArena();
            //output the info of the arena 
            System.out.println("--------------------------------------------------");
            System.out.println("Battle start: \nYou got to a new Arena here is the info:");
            System.out.println(arena);
            //game loop per battle loops when both enemy's and player's dragon are alive
            do
            {
                
            }while(player1.DragonList.get(player1.bytActiveDragon).isAlive()&&enemy.DragonList.get(enemy.bytActiveDragon).isAlive());
        }while(!isAllDead);
        
    }
    //create ethod to save all ppossibale moves into different arrayList base on the type
    public void createMoves()
    {

        FireMovesList.add(new Moves ("Fireball", (byte)1, (short)45, false, (float)0.2, "Burn", (short)40, (short)0));
        FireMovesList.add(new Moves ("Fireclaw", (byte)1, (short)50, false, (float)0.2, "Burn", (short)30, (short)0));
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

        BaseMovesList.add(new Moves ("Heal", (byte)0, (short)20, true, (float)0, " ", (short)50, (short)0));
    }

    public Dragon createRandomDragon( )
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
        //Use 
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

        Dragon random = new Dragon(dragonName,shrMaxHp,shrAttack,level,shrArmor,bytType,moveList);
        System.out.println(random);
        return random;
    }

    public void changeDragon(Dragon New)
    {
        // statement for trycatch block
        boolean tryCatch=false;
        // int storing user input
        int index=-1;
        System.out.println("Now Which Dragon in your team you want to switch out");
        //do while loop checking for valid input
        do
        {
            try
            {
                index=new Scanner(System.in).nextInt();
            }
            catch(Exception e)
            {
                //if inut is not a int
                tryCatch=true;
                System.out.println("Answer invalid please enter a numer between 1 to "+ player1.DragonList.size()); 
            }
            //if input is out of range
            if(index<1||index>player1.DragonList.size())
            {
                tryCatch=true;
                System.out.println("Answer invalid please enter a numer between 1 to "+ player1.DragonList.size());
            }

        }while(tryCatch==true);
        //set the new dragon into the spot
        player1.DragonList.set(index-1,New);
    }
   
}
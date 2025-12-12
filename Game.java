
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
        // Create enemy dragons if empty
        if(enemy.getDragonAmount() <= 0)
        {
            for(int i=0; i<3; i++)
            {   
                enemy.DragonList.add(createRandomDragon());
            }
        }

        // Set active dragons
        player1.bytActiveDragon = 0;
        enemy.bytActiveDragon = 0;

        boolean keepPlaying = true; //variable
        do 
        {
            isAllDead = false; // reset for this battle
            // generate a random arena 
            arena = arena.getRandomArena();
            System.out.println("--------------------------------------------------");
            System.out.println("Battle start: \nYou got to a new Arena here is the info:");
            System.out.println(arena);

            // INNER BATTLE LOOP (player vs enemy)
            do
            {
                Dragon playerD = player1.DragonList.get(player1.bytActiveDragon);
                Dragon enemyD  = enemy.DragonList.get(enemy.bytActiveDragon);

                if (!playerD.isAlive()) {
                    System.out.println("Your dragon " + playerD.strName + " has fainted!");
                    isAllDead = true;
                    break;
                }

                if (!enemyD.isAlive()) {
                    System.out.println("Enemy dragon " + enemyD.strName + " has fainted!");
                    isAllDead = true;
                    break;
                }

                System.out.println("\nYour Dragon: " + playerD.strName + " HP: " + playerD.shrHealth + "/" + playerD.shrMaxHp);
                System.out.println("Enemy Dragon: " + enemyD.strName + " HP: " + enemyD.shrHealth + "/" + enemyD.shrMaxHp);

                printBattleHeader();
                
                // PLAYER TURN --------------------
                System.out.println("\nChoose a move:");
                for (int i = 0; i < playerD.moveList.size(); i++)
                {
                    System.out.println((i+1) + ". " + playerD.moveList.get(i).strName);
                }

                int moveChoice = new Scanner(System.in).nextInt() - 1;
                Moves playerMove = playerD.moveList.get(moveChoice);

                int dmg = playerD.attack(enemyD, playerMove, arena);
                enemyD.takeDamage(dmg);

                System.out.println("Your " + playerD.strName + " used " + playerMove.strName + " and dealt " + dmg + " damage!");
                System.out.println("Enemy " + enemyD.strName + " has " + enemyD.shrHealth + "/" + enemyD.shrMaxHp + " HP remaining.");

                if (!enemyD.isAlive())
                {
                    System.out.println("Enemy " + enemyD.strName + " fainted!");
                    break;
                }

                // ENEMY TURN --------------------
                int enemyMoveIndex = (int)(Math.random() * enemyD.moveList.size());
                Moves enemyMove = enemyD.moveList.get(enemyMoveIndex);

                int enemyDamage = enemyD.attack(playerD, enemyMove, arena);
                playerD.takeDamage(enemyDamage);

                System.out.println("Enemy " + enemyD.strName + " used " + enemyMove.strName + " and dealt " + enemyDamage + " damage!");
                System.out.println("Your " + playerD.strName + " has " + playerD.shrHealth + "/" + playerD.shrMaxHp + " HP remaining.");

                if (!playerD.isAlive())
                {
                    System.out.println("Your dragon " + playerD.strName + " fainted!");
                    break;
                }

            } while(player1.DragonList.get(player1.bytActiveDragon).isAlive() &&
            enemy.DragonList.get(enemy.bytActiveDragon).isAlive());

            // AFTER EACH BATTLE, ask if player wants to continue
            if(!isAllDead)
            {
                System.out.println("Do you want to continue battling? Yes/No");
                String answer2 = new Scanner(System.in).nextLine();
                if(answer.equalsIgnoreCase("no"))
                {
                    keepPlaying = false;
                    System.out.println("Exiting DragonCraft. See you next time!");
                }
            }

        } while(keepPlaying && !isAllDead);
    }
    //create ethod to save all ppossibale moves into different arrayList base on the type
    public void createMoves()
    {

        FireMovesList.add(new Moves ("Fireball", (byte)1, (short)45, false, (float)0.2, "Burn", (short)40));
        FireMovesList.add(new Moves ("Fireclaw", (byte)1, (short)50, false, (float)0.2, "Burn", (short)30));
        FireMovesList.add(new Moves ("Firebreath", (byte)1, (short)60, false, (float)0.1, "Burn", (short)50));
        FireMovesList.add(new Moves ("Flame Slash", (byte)1, (short)40, false, (float)0.2, "Burn", (short)20));

        WaterMovesList.add(new Moves ("Splash", (byte)2, (short)25, false,(float)0, " ", (short)10));
        WaterMovesList.add(new Moves ("Water Pump", (byte)2, (short)40, false, (float)0, " ", (short)20));
        WaterMovesList.add(new Moves("Water Shuriken", (byte)2, (short)50, false, (float)0, "", (short)50));
        WaterMovesList.add(new Moves("Cleanse", (byte)2, (short)30, true, (float)0, " ", (short)50));

        IceMovesList.add(new Moves ("Freeze", (byte)3, (short)10, false, (float)0.6, "Frozen", (short)30));
        IceMovesList.add(new Moves ("Icicle", (byte)3, (short)40, false, (float)0.1, "Frozen", (short)40));
        IceMovesList.add(new Moves ("Glacier", (byte)3, (short)50, false, (float)0.2, "Frozen", (short)50));
        IceMovesList.add(new Moves ("Frostbite", (byte)3, (short)35, false, (float)0.25, "Frozen", (short)30));

        EarthMovesList.add(new Moves ("Earthquake", (byte)4, (short)40, false, (float)0, " ", (short)40));
        EarthMovesList.add(new Moves ("Rock Slide", (byte)4, (short)50, false, (float)0, " ", (short)50));
        EarthMovesList.add(new Moves ("Fissure", (byte)4, (short)50, false, (float)0, " ", (short)50));
        EarthMovesList.add(new Moves ("Stone Crash", (byte)4, (short)45, false, (float)0, " ", (short)40));

        LightiningMovesList.add(new Moves ("Thunderbolt", (byte)5, (short)50, false, (float)0.5, "Shocked", (short)50));
        LightiningMovesList.add(new Moves ("Thunder Punch", (byte)5,(short)25, false, (float)0.6, "Shocked", (short)40));
        LightiningMovesList.add(new Moves ("Storm Strike", (byte)5, (short)45, false, (float)0.3, "Shocked", (short)40));
        LightiningMovesList.add(new Moves ("Volt Burst", (byte)5, (short)55, false, (float)0.4, "Shocked", (short)50));

        BaseMovesList.add(new Moves ("Bite", (byte)0, (short)40, false, (float)0, " ", (short)15));

        BaseMovesList.add(new Moves ("Heal", (byte)0, (short)20, true, (float)0, " ", (short)50));
    }

    public Dragon createRandomDragon()
    {
        // List of possible dragon names
        String[] dragons = {
                "Alduin", "Smaug", "Toothless", "Draco", "Firnen", 
                "Glaurung", "Ancalagon", "Saphira", "Viserion", "Rhaegal", "Drogon", 
                "Meraxes", "Vermithrax", "Falkor", "Shenron", "Norbert", "Kilgharrah", 
                "Eborsisk", "Levithan", "Hydraxis", "Pyrexis", "Obsidrax", 
                "Stormclaw", "Ignivar", "Zephyros"
            };

        // Choose a random name
        String dragonName = dragons[(int)(Math.random() * dragons.length)];

        // Level scaling depending on game count
        byte level = (byte)((int)(Math.random() * 5) + Game.gameCount);

        // Base stats
        short shrMaxHp   = (short)((int)(Math.random() * 20) + 100);
        short shrAttack  = (short)((int)(Math.random() * 25) + 50);
        short shrArmor   = (short)((int)(Math.random() * 10) + 50);

        // FIXED: Correct uniform type generation (1–5)
        byte bytType = (byte)((int)(Math.random() * 5) + 1);

        // Prepare move list for this dragon
        ArrayList<Moves> moveList = new ArrayList<>();

        switch(bytType)
        {
            case 1: // Fire
                moveList.addAll(FireMovesList);
                break;

            case 2: // Ice
                moveList.addAll(IceMovesList);
                break;

            case 3: // Water
                moveList.addAll(WaterMovesList);
                break;

            case 4: // Lightning
                moveList.addAll(LightiningMovesList);
                break;

            case 5: // Earth
                moveList.addAll(EarthMovesList);
                break;
        }

        // Create the actual dragon
        Dragon random = new Dragon(
                dragonName,
                shrMaxHp,
                shrAttack,
                level,
                shrArmor,
                bytType,
                moveList
            );

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

    public void printBattleHeader() {
        System.out.println("""
                                                   ,===:'.,            `-._
                                                        `:.`---.__         `-._
                                                          `:.     `--.         `.
                  _/  \\    _((o                           \\.        `.         `.
                 /     \\  /  _  ^^^o               (,,(,    \\.         `.   ____,-`.,
                /   !   \\/  ! '!!!v'            (,'     `/   \\.   ,--.___`.'
               !  !  \\ _' ( \\____          ,  ,'  ,--.  `,   \\.;'         `
               ! . \\ _!\\   \\===^\\)        `{D, {    \\  :    \\;
                \\ \\_!  / __!                  V,,'    /  /    //
                 \\!   /    \\                  j;;    /  ,' ,-//.    ,---.      ,
           (\\_      _/   _\\ )                 \\;'   /  ,' /  _  \\  /  _  \\   ,'/  
            \\ ^^--^^ __-^ /(__                       \\   `'  / \\  `'  / \\  `.' /  
             ^^----^^    "^--v'                        `.___,'   `.__,'   `.__,'
        """);
    }
}
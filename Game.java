
/**
 * Description: .
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private Player player1;
    private Player player2;
    private Battlefield arena;
    Player enemy=new Player();
    static int gameCount=0;
    public void startBattle()
    {
        do
        {
            createEnemy();
        }while(player1.DragonList.get(player1.bytActiveDragon).isAlive()&&player2.DragonList.get(player2.bytActiveDragon).isAlive());
    }
    
    public void createEnemy()
    {
        //initialize an enemy name
         enemy.strName="Liam";
        //generate a random dradon into the enemy roster
         //generate a random dradon into the enemy roster
        String dragonName = "Crispy McGizzard";
        //declare enemy gragon level that will get higher progressivly
        byte level=(byte)(Math.random() *5+Game.gameCount);
        short shrMaxHp=(short)(Math.random() *20+100);
        short shrAttack=(short)(Math.random() *25+50);
        short shrArmor=(short)(Math.random() *10+50);
        byte bytType=(byte)(Math.random()*4+1);
         enemy.DragonList.add();
         
    }
}
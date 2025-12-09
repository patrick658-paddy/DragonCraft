
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
         
         enemy.DragonList.add();
         
    }
}
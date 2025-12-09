
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
    
    public void startBattle()
    {
        do
        {
            
        }while(player1.DragonList.get(player1.bytActiveDragon).isAlive()&&player2.DragonList.get(player2.bytActiveDragon).isAlive());
    }
}

/**
 * Write a description of class Battlefield here.
 *
 * @author (Abdulla)
 * @version (a version number or a date)
 */
import java.util.Random;

public class Battlefield 
{
    private String arenaName;

    private float fireModifier;
    private float iceModifier;
    private float waterModifier;
    private float lightningModifier;
    private float earthModifier;

    //Constructor
    public Battlefield(String arenaName,float fireModifier,float iceModifier, 
    float waterModifier,float lightningModifier, float earthModifier) 
    {
        this.arenaName = arenaName;
        this.fireModifier = fireModifier;
        this.iceModifier = iceModifier;
        this.waterModifier = waterModifier;
        this.lightningModifier = lightningModifier;
        this.earthModifier = earthModifier;
    }

    //GETTERS
    public String getArenaName() { return arenaName; }
    public float getFireModifier() { return fireModifier; }
    public float getIceModifier() { return iceModifier; }
    public float getWaterModifier() { return waterModifier; }
    public float getLightningModifier() { return lightningModifier; }
    public float getEarthModifier() { return earthModifier; }

    //DAMAGE MODIFIER
    public float applyModifier(byte abilityType, float baseDamage) {
        switch (abilityType) {
            // 1 = fire, 2 = ice, 3 = water, 4 = lightning, 5 = earth
            case 1: return baseDamage * fireModifier;
            case 2: return baseDamage * iceModifier;
            case 3: return baseDamage * waterModifier;
            case 4: return baseDamage * lightningModifier;
            case 5: return baseDamage * earthModifier;
            default: return baseDamage;
        }
    }

    
    public static final Battlefield Fire_Arena = new Battlefield("Fire Arena", 1.2f, 0.8f, 1.0f, 1.0f, 1.0f);

    public static final Battlefield Ice_Arena = new Battlefield("Ice Arena", 0.8f, 1.2f,1.1f,1.0f,0.9f);

    public static final Battlefield Lightning_Arena = new Battlefield("Lightning Arena",1.1f,0.9f,0.8f,1.2f,1.0f);

    public static final Battlefield Water_Arena = new Battlefield("Water Arena",0.8f, 1.1f,1.5f, 1.2f, 0.8f);

    public static final Battlefield Earth_Arena = new Battlefield("Earth Arena", 0.8f,1.1f, 1.1f,0.8f,1.2f);

    //arena randomizer
    public static Battlefield getRandomArena() 
    {
        Battlefield[] allArenas = {Fire_Arena, Ice_Arena, Lightning_Arena,  Water_Arena, Earth_Arena};

        Random rand = new Random();
        return allArenas[rand.nextInt(allArenas.length)];
    }
    
    /*
    //Recieve attack
    public void receiveAttack(Dragon attacker, Ability move,/ Dragon target) 
    {
        float modifiedDamage = applyModifier(move.getType(), move.getDamage());
        //target.takeDamage((short) modifiedDamage);
    }
    */
}

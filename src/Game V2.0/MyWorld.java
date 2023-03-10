import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyWorld is the environment that Actors live in..
 * 
 * @author (James Patrick Arellano) 
 * @version (1)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //initializing important variables
    int count = 0;
    int spawnSpeed = 50; //small value will increase spawn speed
    int randomSpawn;
    //all of these will be player's main attributes
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    
    public MyWorld()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        mainPlayer = new Player(weaponButton); 
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100); 
        addObject(healthbar, mainPlayer.getX(), mainPlayer.getY() - 50);
        addObject(weaponButton, 900, 100);
        //above lines add different objects on the world screen
    }
    
    public Player getPlayer() //function to call the player
    {
        return mainPlayer;
    }
    public void act() //these lines of code will be our actual acts on screen
    {
        count++;
        //below lines will check change the spawnSpeed based on timing
        if((count/60) >= 60 && (count/60) < 120)
        {
            spawnSpeed = 40;
        }
        if((count/60) >= 120 && (count/60) < 180)
        {
            spawnSpeed = 25;
        }
        SpawnZombies(); 
    }
    public void SpawnZombies() //this is the function that generates zombies
    {
        if (count % spawnSpeed == 0)
       {
           randomSpawn = Greenfoot.getRandomNumber(8);
           switch(randomSpawn){ //zombies will come from 8 different positions on the screen but randomly
               case 0 : addObject(new Zombie(mainPlayer,counter), 0, 0); break;
               case 1 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, 0); break;
               case 2 : addObject(new Zombie(mainPlayer,counter), getWidth(), 0); break;
               case 3 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()/2); break;
               case 4 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()/2); break;
               case 5 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()); break;
               case 6 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, getHeight()); break;
               case 7 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()); break;
            
           }
       }
    }
}

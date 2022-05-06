package src_files;

public class Main_Game 
{
    public static void main(String[] args) 
    {
        //create the players
        Player p1 = new Player("Piano");
        Player p2 = new Player("Drum");
        
        Arena gameArena = new Arena(p1, p2);
        gameArena.arena_game();


    }
}

package com.example.application.views.list;

public interface GameObject 
{
    //For now I'll put PIANO for player1
    //                 DRUM for player2
    public String player1Instrument = "piano";
    public String player2Instrument = "piano";
    public Player player1 = new Player(player1Instrument);
    public Player player2 = new Player(player2Instrument);
    public int initialHealth = 7;
    public int initialShield = 0;
    public int initialMana = 10;
    public BackGround bgForTheGame = new BackGround();

    //now I make the gameArena which will stay constant
    // I'll pass it to the next arena too
    public Arena gameArena = new Arena(player1, player2);

    // //store player1 card choice
    // public int p1ChosenCardID = -1;

    // public void changeChosenCardp1ID(int i);

}

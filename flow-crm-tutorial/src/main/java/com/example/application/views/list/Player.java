package com.example.application.views.list;
public class Player implements GameObject
{
    // variables

    int health;
    int shield;
    int mana;
    Instrument instrument;
    String strInstrument;
    User userProfile;
    Hand playerHand;


    public Player(String i)
    {
        strInstrument = i;
        health = initialHealth;
        shield = initialShield;
        mana = initialMana;
        playerHand = new Hand();
        System.out.println("Player 1's hand:");
        for(int j = 0; j < 4; j++)
        {
            givePlayerCard(strInstrument);
            System.out.println("\t\t" + playerHand.getThisHand().get(j).toString());
        }
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getShield() {
        return this.shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public String getInstrumentName() {
        return this.strInstrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public User getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }

    public Hand getPlayerHand() {
        return this.playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    // methods

    public void givePlayerCard(String instrument)
    {
        playerHand.putRandomCardIntoHand(instrument);
    }

    /**
     * Updates the health of the player.
     * @param damage damage taken by the player
     */
    public void updateHealth(int damage){
        this.health = this.health - damage;
    }

    public void healHealth(int amount)
    {
        this.health = this.health + amount;
    }
    
    /**
     * Updates the shield of the player.
     * @param damage damage taken by the player
     */
    public void updateShield(int damage)
    {
        this.shield = this.shield - damage;
    }
    public void healShield(int amount)
    {
        this.shield = this.shield + amount;
    }

    /**
     * Updates the mana of the player.
     * @param cost cost of the card used
     */
    public void updateMana(int cost){
        this.mana = this.mana - cost;
    }
    
    public String toStringForPlayer()
    {
        return "" + getInstrumentName() + " | Health: " + getHealth() + " | Shield: " + getShield() + " | Mana:" + getMana();
    }

}
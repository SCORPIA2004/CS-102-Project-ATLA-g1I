package src_files;
public class Player
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
        health = 100;
        shield = 0;
        mana = 50;
        playerHand = new Hand();
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

    public void givePlayerCard()
    {
        playerHand.putRandomCardIntoHand();
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
    public void updateShield(int amount)
    {
        this.shield = this.shield - amount;
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
    
}
package src_files;
public class Player{


    // variables

    int health;
    int sheild;
    int mana;
    Instrument instrument;
    User userProfile;
    Hand playerHand;

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSheild() {
        return this.sheild;
    }

    public void setSheild(int sheild) {
        this.sheild = sheild;
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

    /**
     * Updates the health of the player.
     * @param damage damage taken by the player
     */
    public void updateHealth(int damage){
        this.health = this.health - damage;
    }
    
    /**
     * Updates the sheild of the player.
     * @param damage damage taken by the player
     */
    public void updateSheild(int damage){
        this.sheild = this.sheild - damage;
    }

    /**
     * Updates the mana of the player.
     * @param cost cost of the card used
     */
    public void updateMana(int cost){
        this.mana = this.mana - cost;
    }
    




}
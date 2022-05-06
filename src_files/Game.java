package src_files;
import java.awt.*;

public class Game {

    // variables
    boolean win;
    User player;
    User enemy;
    Image bgImage;     //background image


    public boolean isWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public User getPlayer() {
        return this.player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public User getEnemy() {
        return this.enemy;
    }

    public void setEnemy(User enemy) {
        this.enemy = enemy;
    }

    public Image getBgImage() {
        return this.bgImage;
    }

    public void setBgImage(Image bgImage) {
        this.bgImage = bgImage;
    }

    // methods
    public void postGame(){

    }

    //TO DO
    public boolean playTurn(){
        return false;
    }
    public void playCard(Card card){

    }
}

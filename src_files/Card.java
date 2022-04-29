import java.awt.Image;

public abstract class Card{
    // variables

     Instrument instrument;
    private boolean visibility;
    private Image cardImage;

    //constructor
    public Card(int id)
    {
        setId(id);
    }

    //methods

    public int getId(){
        return this.id;
    }

    public int getMana(){
        return this.mana;
    }

    public boolean isVisible(){
        return this.visibility;
    }
  
    public void setId(){
        this.id++;
    }

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    public void setInstrument(Instrument instr){
        this.instrument = instr;
    }

    public void setCardImage(Image img){
        this.cardImage = img;
    }

}
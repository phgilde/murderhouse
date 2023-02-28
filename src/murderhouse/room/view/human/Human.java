package murderhouse.room.view.human;

import java.util.Optional;
import murderhouse.item.Item;
import murderhouse.room.view.View;

public abstract class Human extends View {
     protected int n = 0; 
    /**
     * Gibt eine Reaktion auf ein Item zurueck.
     * 
     * @param heldItem Das Item.
     * @return Reaktion auf das Item.
     */
    public abstract String talk(Optional<Item> heldItem);

    /**
     * Gibt eine Reaktion auf ein Wort zurueck.
     * 
     * 
     */
    public abstract String ask(String q);

    /**
     * Gibt zurück den Namen der Person die mit dem Gewehr getroffen wird
     * 
     * 
     */
    public String totallyNotDead (int t){
        if(t==1){
          return this.getName() + "ist nicht tot, diese Person wird nur ab jetzt komischer Weise nicht mehr ansprechbar sein und nur noch auf dem Boden rumliegen."; 
        }else{
            return null; 
        }
    }



}

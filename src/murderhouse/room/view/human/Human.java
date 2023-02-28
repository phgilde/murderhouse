package murderhouse.room.view.human;

import java.util.Optional;
import murderhouse.item.Item;
import murderhouse.room.view.View;

public abstract class Human extends View {
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
}

package room.view.human;

import java.util.Optional;
import item.Item;
import room.view.View;

public abstract class Human extends View {
    
    /**
     * Gibt eine Reaktion auf ein Item zurück.
     * 
     * @param heldItem Das Item.
     * @return Reaktion auf das Item.
     */
    public abstract String talk(Optional<Item> heldItem);
/**
     * Gibt eine Reaktion auf ein Wort zurück.
     * 
     * 
     */
    public abstract String ask(String q);


    
}

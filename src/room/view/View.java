package room.view;

import java.util.Optional;
import item.Item;
import room.Room;

public abstract class View {

    /**
     * Gibt eine Beschreibung der Ansicht zurück.
     * 
     * @return Beschreibung
     */
    public abstract String getDescription();

    /**
     * Führt eine Interaktion mit der Ansicht durch.
     * 
     * @param action Die Interaktion.
     * @return Reaktion auf die Interaktion.
     */
    public abstract Object interact(Optional<Item> heldItem);

}

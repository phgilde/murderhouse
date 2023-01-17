package room.view;

import java.util.Map;
import java.util.Optional;
import item.Item;

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
    public abstract String interact(Optional<Item> heldItem);

    public abstract Map<String, Item> getAvailableItems();
}

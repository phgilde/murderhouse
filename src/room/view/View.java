package room.view;

import java.util.List;
import java.util.Optional;
import interaction.Reaction;
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
    public abstract String interact(Optional<Item> heldItem);

    public abstract List<Item> getAvailableItems();
}

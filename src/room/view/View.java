package room.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import item.Item;

public abstract class View {
    protected Map<String, Item> items = new HashMap<>();

    public abstract String getName();

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

    /**
     * Spieler versucht, einen Gegenstand aus der Ansicht zu nehmen.
     * 
     * @param itemName Name des Gegenstands.
     * @return Der Gegenstand, falls er genommen werden konnte.
     */
    public Optional<Item> takeItem(String itemName) {
        if (items.containsKey(itemName)) {
            return Optional.of(items.get(itemName));
        } else {
            return Optional.empty();
        }
    }
}

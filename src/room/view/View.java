package room.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import interaction.Reaction;
import item.Item;

public abstract class View {
    protected Map<String, Item> items = new HashMap<>();

    public abstract String getName();

    /**
     * Gibt eine Beschreibung der Ansicht zurueck.
     * 
     * @return Beschreibung
     */

    public abstract String getDescription();

    /**
     * Fuehrt eine Interaktion mit der Ansicht durch.
     * 
     * @param action Die Interaktion.
     * @return Reaktion auf die Interaktion.
     */
    public String interact(Optional<Item> heldItem) {
        return "Es passiert nichts.";
    };

    /**
     * Fuehrt eine Interaktion mit der Ansicht durch.
     * 
     * @param action Die Interaktion.
     * @return Reaktion auf die Interaktion.
     */
    public Reaction interactReaction(Optional<Item> heldItem) {
        return new Reaction(interact(heldItem));
    }

    /**
     * Spieler versucht, einen Gegenstand aus der Ansicht zu nehmen.
     * 
     * @param itemName Name des Gegenstands.
     * @return Der Gegenstand, falls er genommen werden konnte.
     */
    public Optional<Item> takeItem(String itemName) {
        if (items.containsKey(itemName)) {
            Optional<Item> takenItem = Optional.of(items.get(itemName));
            items.remove(itemName);
            return takenItem;
        } else {
            return Optional.empty();
        }
    }
}

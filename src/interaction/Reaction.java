package interaction;

import java.util.List;

import item.Item;

public abstract class Reaction {
    /**
     * Gibt die Beschreibung der Reaktion zurück.
     * 
     * @return Beschreibung
     */
    public abstract String getDescription();

    /**
     * Gibt die Items zurück, die der Spieler durch die Interaktion findet.
     * 
     * @return Items
     */
    public abstract List<Item> getItems();

    /**
     * Gibt zurück, ob die Interaktion erfolgreich war.
     * @return Erfolg
     *
     */
    public abstract boolean wasSuccessful();
}
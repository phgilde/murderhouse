package murderhouse.room;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import murderhouse.item.Item;
import murderhouse.room.view.View;

public abstract class Room {
    /**
     * List der angrenzenden Raeume.
     */
    protected List<String> adjacentRooms = new LinkedList<String>();

    protected HashMap<String, View> views = new HashMap<String, View>();

    /**
     * Gibt den Namen des Raums zurueck.
     * 
     * @return Name.
     */
    public abstract String getName();

    /**
     * Gibt eine Beschreibung des Raums zurueck.
     * 
     * @return Beschreibung.
     */
    public abstract String getDescription();

    /**
     * Gibt die angrenzenden Raeume zurueck, in die der Spieler von diesem Raum aus gehen kann.
     * 
     * @return Angrenzende Raeume.
     */
    public List<String> getAdjacentRooms() {
        return adjacentRooms;
    };

    /**
     * Gibt die Views zurueck, die der Spieler von diesem Raum aus sehen kann.
     * 
     * @return Views.
     */
    public Map<String, View> getViews() {
        return views;
    }

    /**
     * Fuehrt eine Interaktion mit einer Ansicht im Raum durch.
     * 
     * @param view Ansicht.
     * @param heldItem Das Item, das der Spieler in der Hand haelt.
     */
    public void interact(View view, Optional<Item> heldItem) {};

}

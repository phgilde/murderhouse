package room;

import java.util.Map;
import java.util.Optional;
import item.Item;
import room.view.View;

public abstract class Room {
    /**
     * Gibt den Namen des Raums zurück.
     * 
     * @return Name.
     */
    public abstract String getName();

    /**
     * Gibt eine Beschreibung des Raums zurück.
     * 
     * @return Beschreibung.
     */
    public abstract String getDescription();

    /**
     * Gibt die angrenzenden Räume zurück, in die der Spieler von diesem Raum aus gehen kann.
     * 
     * @return Angrenzende Räume.
     */
    public abstract Map<String, Room> getAdjacentRooms();

    /**
     * Gibt die Views zurück, die der Spieler von diesem Raum aus sehen kann.
     * 
     * @return Views.
     */
    public abstract Map<String, View> getViews();

    /**
     * Führt eine Interaktion mit einer Ansicht im Raum durch.
     * @param view Ansicht.
     * @param heldItem Das Item, das der Spieler in der Hand hält.
     */
    public abstract void interact(View view, Optional<Item> heldItem);

}

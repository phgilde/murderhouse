package room;

import java.util.List;

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
     * Gibt die angrenzenden Räume zurück, in die der Spieler von diesem Raum aus
     * gehen kann.
     * 
     * @return Angrenzende Räume.
     */
    public abstract List<Room> getAdjacentRooms();
}

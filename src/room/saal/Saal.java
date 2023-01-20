import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Saal extends Room{
    private HashMap<String, View> views = new HashMap<String, View>();
    private LinkedList<String> adjacentRooms = new LinkedList<String>();

    public Saal(){
        adjacentRooms.add("Eingang");
        adjacentRooms.add("Wohnzimmer");
        adjacentRooms.add("Küche");
        adjacentRooms.add("Arbeitszimmer");
        adjacentRooms.add("Oben");
    }

    @Override
    public String getName(){
        return "Saal";    
    }

    @Override
    public String getDescription(){
        return "Du stehst in der Mitte des Saals. Von hier kommst du in fast alle Räume des Hauses."
        + "Aus der *Küche* duftet es prächtig nach deinem Lieblingsessen: Schokokuchen"
        + "Überdeckt wird dieser göttliche Duft mit einer übelriechende Fahne aus dem *Arbeitszimmers* ";

    }

    @Override
    public List<String> getAdjacentRooms(){
        return adjacentRooms;
    }

    @Override
    public Map<String, View> getViews() {
        return views;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
    }
}
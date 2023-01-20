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
        adjacentRooms.add("Schlafzimmer");
        adjacentRooms.add("Wohnzimmer");

        views.put("Aufzug", new Aufzug());
    }

    @Override
    public String getName(){
        return "Saal";    
    }

    @Override
    public String getDescription(){
        return "Du stehst in der Mitte des Saals. ";
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
        // TODO Auto-generated method stub
        
    }

}
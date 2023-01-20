import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Eingang extends Room {
    private LinkedList<String> adjacentRooms = new LinkedList<String>();
    private HashMap<String, View> views = new HashMap<>();

    public Eingang() {
        adjacentRooms.add("saal");
        adjacentRooms.add("draussen");
        views.put("schluesselkiste", new Schluesselkiste());
        views.put("schuhschrank", new Schuhschrank());
    }

    public String getName() {
        return "eingang";
    }

    @Override
    public String getDescription() {
        return "In dem *Eingang* befindet sich ein Schuhschrank, eine Zimmerplanze, eine Schlüsselbox und die Eingangstür";

    }

    @Override
    public List<String> getAdjacentRooms() {
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
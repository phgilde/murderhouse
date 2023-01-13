import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;

public class Wohnzimmer extends Room {
    private HashMap<String, View> views = new HashMap<String, View>();
    public Wohnzimmer() {
        adjacentRooms.add("Treppenhaus");
        views.put("Fernseher", new Fernseher());
    }
    private LinkedList<String> adjacentRooms = new LinkedList<String>();

    @Override
    public String getName() {
        return "Wohnzimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Wohnzimmer. Hier ist eine Sofalandschaft und ein Fernseher. "
                + "Von hier aus kannst du ins Treppenhaus gehen.";
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
    }

}

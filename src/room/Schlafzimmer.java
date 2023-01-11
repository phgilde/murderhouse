package room;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import item.Item;
import room.view.View;

public class Schlafzimmer extends Room {

    public Schlafzimmer() {
        super();
    }

    public String getName() {
        return "Schlafzimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Schlafzimmer. Es ist dunkel und du kannst nichts erkennen.";
    }

    @Override
    public List<String> getAdjacentRooms() {
        return new LinkedList<String>();
    }

    @Override
    public Map<String, View> getViews() {
        return new HashMap<>();
    }

    public void interact(View view, Optional<Item> heldItem) {
        
    }
}

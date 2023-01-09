package room;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Room> getAdjacentRooms() {
        return new HashMap<>();
    }

    @Override
    public Map<String, View> getViews() {
        return new HashMap<>();
    }


}

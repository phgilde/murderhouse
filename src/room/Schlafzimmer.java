package room;

import java.util.Map;

import view.View;

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
        return null;
    }

    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }

}

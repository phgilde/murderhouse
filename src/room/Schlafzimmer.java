package room;

import java.util.List;

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
    public List<Room> getAdjacentRooms() {
        return null;
    }

}

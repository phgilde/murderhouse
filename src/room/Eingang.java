package room;

import java.util.Map;
import room.view.View;

public class Eingang extends Room {

    @Override
    public String getName() {
        return "Eingang";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Eingang. Hier gibt es eine Garderobe, eine Topfpflanze und den Durchgang zum Flur.";
    }

    @Override
    public Map<String, Room> getAdjacentRooms() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

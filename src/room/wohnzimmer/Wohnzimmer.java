import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;

public class Wohnzimmer extends Room {
    public Wohnzimmer() {
        adjacentRooms.add("saal");
        views.put("fernseher", new Fernseher());
    }

    @Override
    public String getName() {
        return "wohnzimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Wohnzimmer. Hier ist eine Sofalandschaft und ein *Fernseher*. "
                + "Von hier aus kannst du in den *Saal* gehen.";
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
    }

}

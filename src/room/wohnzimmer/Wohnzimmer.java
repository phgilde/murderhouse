import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;

public class Wohnzimmer extends Room {
    public Wohnzimmer() {
        adjacentRooms.add("saal");
        adjacentRooms.add("garten");
        views.put("fernseher", new Fernseher());
    }

    @Override
    public String getName() {
        return "wohnzimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Wohnzimmer. Hier ist eine Sofalandschaft und ein *Fernseher*. "
                + "Von hier aus kannst du in den *Saal* und in den *Garten* gehen.";
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {}

}

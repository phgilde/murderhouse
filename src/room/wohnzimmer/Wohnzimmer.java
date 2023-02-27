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
        return "Du befindest dich im Wohnzimmer. Es ist sehr gemütlich eingerichtet und gleichzeitig durchaus elegant. "
                + "Gegenueber des *Fernseher*s stehen drei Sofas sowie ein lederner Ohrensessel "
                + "um einen schweren Holztisch, auf dem eine Obstschale steht. Der offene Kamin koennte im Winter wohlige Waerme spenden."
                + "Über dem Kamin dekonstruiert ein kubistisches Gemaelde die norwegischen Fjorde."
                + "Von hier aus kannst du in den *Saal* und in den *Garten* gehen.";
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {}

}

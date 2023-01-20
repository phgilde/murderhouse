package room.zimmer;

import java.util.Map;
import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;

public class ZimmerOle extends Room {

    public ZimmerOle() {
        adjacentRooms.add("flur");
    }
    @Override
    public String getName() {
        return "oles schlafzimmer";
    }

    @Override
    public String getDescription() {
        return "Ein helles Zimmer mit einem Doppelbett, einer Kommode und zwei Nachttischen. An der Wand hängt ein Bild von Oles Familie.\n"
                + "Es erinnert dich an das Schlafzimer deiner Eltern."
                + "Von hier aus kannst du in den *Flur* gehen.";
    }


    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub

    }

}

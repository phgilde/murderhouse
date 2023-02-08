package room.zimmer.zimmerole;

import java.util.Map;
import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;

public class ZimmerOle extends Room {

    public ZimmerOle() {
        adjacentRooms.add("flur");
        views.put("kommode", new Kommode());
        views.put("nachttisch links", new NachttischLinks());
        views.put("nachttisch rechts", new NachttischRechts());
    }

    @Override
    public String getName() {
        return "oles schlafzimmer";
    }

    @Override
    public String getDescription() {
        return "Ein helles Zimmer mit einem Doppelbett, einer Kommode und zwei Nachttischen (*Nachttisch Links* und *Nachttisch Rechts*). An der Wand haengt ein Bild von Oles Familie.\n"
                + "Es erinnert dich an das Schlafzimer deiner Eltern."
                + "Von hier aus kannst du in den *Flur* gehen.\n"
                + "Eine etwas aeltere Frau sitz aufrecht im Bett";
    }


    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {}

}

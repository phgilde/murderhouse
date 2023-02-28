package room.zimmer.schlafzimmer;

import java.util.Map;
import java.util.Optional;
import item.Item;
import room.Room;
import room.view.View;


public class Schlafzimmer extends Room {

    public Schlafzimmer() {
        adjacentRooms.add("flur");
        views.put("kommode", new Kommode());
        views.put("nachttisch links", new NachttischLinks());
        views.put("nachttisch rechts", new NachttischRechts());
        views.put("fredericke", new Fredericke()); 
    }

    @Override
    public String getName() {
        return "oles schlafzimmer";
    }

    @Override
    public String getDescription() {
        return "Ein helles Zimmer mit einem Doppelbett, einer *Kommode* und zwei Nachttischen (*Nachttisch Links* und *Nachttisch Rechts*). An der Wand haengt ein Bild von Oles Familie.\n"
                + "Es erinnert dich an das Schlafzimer deiner Eltern."
                + "Von hier aus kannst du in den *Flur* gehen.\n"
                + "Eine etwas aeltere Frau sitz aufrecht im Bett";
    }


    @Override
    public void interact(View view, Optional<Item> heldItem) {}

}


package room.arbeitszimmer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.geheimzimmer.Geheimzimmer;
import room.view.View;

public class Arbeitszimmer extends Room {

    public Arbeitszimmer() {
        adjacentRooms.add("saal");

        views.put("leiche", new Leiche());
        views.put("schrank", new Schrank());
    }

    @Override
    public String getName() {

        return "arbeitszimmmer";
    }

    @Override
    public String getDescription() {
        return "Im Arbeitszimmer angekommen siehst du die *Leiche* von Ole. Neben dir befindet sich ein schoener *Schrank*, der die gesamte Wand ausfuellt.\n"
                + "Dir wird schwindelig und du setzt dich auf den Stuhl hinter dir, um in Ruhe zu ueberlegen was du als naechstes machen willst.";
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
        if (heldItem.isPresent()) {
            if (view.getName().equals("schrank")
                    && heldItem.get().getName().equals("gruener schluessel")
                    && !adjacentRooms.contains("geheimzimmer")) {
                adjacentRooms.add("geheimzimmer");
            }
        }
    }

}

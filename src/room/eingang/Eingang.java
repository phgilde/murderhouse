import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Eingang extends Room {
   

    public Eingang() {
        adjacentRooms.add("saal");
        adjacentRooms.add("draussen");
        views.put("schluesselkiste", new Schluesselkiste());
        views.put("schuhschrank", new Schuhschrank());
        views.put("planze", new Pflanze()); 
    }

    public String getName() {
        return "eingang";
    }

    @Override
    public String getDescription() {
        return "In dem *Eingang* befindet sich ein *Schuhschrank*, eine *Pflanze*, eine *Schluesselbox* und die Eingangstuer";

    }



    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub

    }
}

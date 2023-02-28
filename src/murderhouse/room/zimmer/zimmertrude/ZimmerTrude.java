package murderhouse.room.zimmer.zimmertrude;

import murderhouse.room.Room;

public class ZimmerTrude extends Room {

    public ZimmerTrude() {
        adjacentRooms.add("flur");
        views.put("bett", new Bett());
        views.put("schreibtisch", new Schreibtisch());
        views.put("schrank", new Schrank());
        views.put("trude", new Trude()); 
    }
    @Override
    public String getName() {
        return "Trudes Zimmer";
    }

    @Override
    public String getDescription() {
        return "Du stehst in einem wirklich großen Zimmer, das irgendwie leer erscheint. Du siehst ein *Bett*, "
                + "einen *Schreibtisch* auf dem eine Frau sitzt und einen *Schrank*. "
                + "Von hier aus kannst du in den *Flur* gehen.";
    }

}

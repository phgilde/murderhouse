package room.zimmer.zimmertrude;

import room.Room;

public class ZimmerTrude extends Room {

    public ZimmerTrude() {
        adjacentRooms.add("flur");
        views.put("bett", new Bett());
        views.put("schreibtisch", new Schreibtisch());
        views.put("schrank", new Schrank());
    }
    @Override
    public String getName() {
        return "trudes zimmer";
    }

    @Override
    public String getDescription() {
        return "Du stehst in einem wirklich großen Zimmer, das irgendwie leer erscheint. Du siehst ein *Bett*,"
                + "einen *Schreibtisch* und einen *Schrank*."
                + "Von hier aus kannst du in den *Flur* gehen.";
    }

}

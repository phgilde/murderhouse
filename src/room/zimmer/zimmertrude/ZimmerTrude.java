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
        return "Du stehst in Trudes Zimmer. Es ist ziemlich eng hier. Du siehst ein *Bett*,"
                + "einen *Schreibtisch* und einen *Schrank*. Du wunderst dich, wie das alles hier hinein passt."
                + "Von hier aus kannst du in den *Flur* gehen.";
    }

}

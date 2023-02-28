package murderhouse.room.zimmer.zimmerana;

import murderhouse.room.Room;

public class ZimmerAna extends Room {

    public ZimmerAna() {
        adjacentRooms.add("flur");
        views.put("topfpflanze", new Topfpflanze());
        views.put("Ana", new Ana()); 
    }

    @Override
    public String getName() {
        return "Anas Zimmer";
    }

    @Override
    public String getDescription() {
        return "Das Zimmer ist ziemlich klein, aber es ist sehr gemuetlich."
                + "Hier ist ein Bett mit einem Schrank darunter. Am Schreibtisch sitzt Ana. Auf dem Fensterbrett steht eine *Topfpflanze*. Die Waende sind voller Kunstdrucke.";
    }

}

package room.kueche;

import java.util.Map;
import room.Room;
import room.view.View;

public class Kueche extends Room {

    public Kueche() {
        adjacentRooms.add("saal");
        views.put("herdplatte", new Herdplatte());
    }

    @Override
    public String getName() {
        return "Küche";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich in der Küche. Auf dem Tisch steht ein phantastisch duftender Schokokuchen. "
            + "Hier befindet sich eine Herdplatte mit einem Kochtopf darauf.";
    }
}

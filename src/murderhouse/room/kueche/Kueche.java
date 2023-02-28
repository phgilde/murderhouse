package murderhouse.room.kueche;

import java.util.Map;
import murderhouse.room.Room;
import murderhouse.room.view.View;

public class Kueche extends Room {

    public Kueche() {
        adjacentRooms.add("saal");
        views.put("herdplatte", new Herdplatte());
        views.put("kuehlschrank", new Kuehlschrank());
    }

    @Override
    public String getName() {
        return "Kueche";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich in der Kueche. Auf dem Tisch steht ein phantastisch duftender Schokokuchen. "
                + "Hier befindet sich eine *Herdplatte* mit einem Kochtopf darauf. Neben der Herdplatte steht ein großer *Kuehlschrank*."
                + "von hier kannst du in den *Saal* gehen.";
    }
}

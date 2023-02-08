package room.badezimmer;

import item.SimpleItem;
import room.view.View;

public class Spiegelschrank extends View {

    public Spiegelschrank() {
        items.put("ibuprofen",
                new SimpleItem("ibuprofen", "Eine Schachtel Ibuprofen 600 der Marke Bayer."));
    }

    @Override
    public String getName() {
        return "spiegelschrank";
    }

    @Override
    public String getDescription() {
        return "Im Schrank befinden sich mehrere Zahnbürsten, zwei Sorten Zahnpasta. Weiterhin liegt hier eine Schachtel *Ibuprofen*";
    }

}

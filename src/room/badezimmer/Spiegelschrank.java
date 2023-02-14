package room.badezimmer;

import item.SimpleItem;
import room.view.View;

public class Spiegelschrank extends View {

    public Spiegelschrank() {
        items.put("ibuprofen",
                new SimpleItem("ibuprofen", "Eine Schachtel Ibuprofen 600 der Marke Bayer."));
        items.put("rosa schluessel", new SimpleItem("rosa schluessel",
                "Ein Schluessel aus Rosafarbenem Metall. Dem Gewicht nach scheint es sich um Rósegold zu handeln."));
    }

    @Override
    public String getName() {
        return "spiegelschrank";
    }

    @Override
    public String getDescription() {
        return "Im Schrank befinden sich mehrere Zahnbuersten, zwei Sorten Zahnpasta. Weiterhin liegt hier eine Schachtel *Ibuprofen*."
                + "        ...         " + "        ...         "
                + "Hinter einem Zahnputzbecher bemerkst du einen *Rosa Schluessel*";
    }

}

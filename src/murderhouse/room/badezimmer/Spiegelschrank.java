package murderhouse.room.badezimmer;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Spiegelschrank extends View {

    public Spiegelschrank() {
        items.put("ibuprofen",
                new SimpleItem("Ibuprofen", "Eine Schachtel Ibuprofen 600 der Marke Bayer."));
        items.put("rosa schluessel", new SimpleItem("rosa Schluessel",
                "Ein Schluessel aus Rosafarbenem Metall. Dem Gewicht nach scheint es sich um Rósegold zu handeln."));
    }

    @Override
    public String getName() {
        return "Spiegelschrank";
    }

    @Override
    public String getDescription() {
        String str = "";
        str += "Im Schrank befinden sich mehrere Zahnbuersten, zwei Sorten Zahnpasta. ";
        if(items.containsKey("ibuprofen")){
            str += "Weiterhin liegt hier eine Schachtel *Ibuprofen*.";
        }
        if(items.containsKey("rosa schluessel")){
            str += "        ...         " + "        ...         "
            + "Hinter einem Zahnputzbecher bemerkst du einen *Rosa Schluessel*";
        }

        return str;
    }

}

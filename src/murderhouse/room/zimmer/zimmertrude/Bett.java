package murderhouse.room.zimmer.zimmertrude;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Bett extends View {
    public Bett() {
        items.put("baseballschlaeger", new SimpleItem("Baseballschlaeger",
                "Ein hölzelner Baseballschlaeger. Er ist voller roter Flecken."));
    }


    @Override
    public String getName() {
        return "bett";
    }

    @Override
    public String getDescription() {
        return "Ein riesiges Himmelbett. "
                + "Die Bettwäsche ist mit vielen kleinen Spinnen bedruckt. Unter dem Bett liegt ein *Baseballschlaeger*.";
    }

}
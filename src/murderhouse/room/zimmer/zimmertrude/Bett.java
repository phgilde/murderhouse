package murderhouse.room.zimmer.zimmertrude;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Bett extends View {
    public Bett() {
        items.put("baseballschlaeger", new SimpleItem("Baseballschlaeger",
                "Ein hoelzelner Baseballschlaeger. Er ist voller roter Flecken."));
    }


    @Override
    public String getName() {
        return "Bett";
    }

    @Override
    public String getDescription() {
        return "Ein riesiges Himmelbett. "
                + "Die Bettwaesche ist mit vielen kleinen Spinnen bedruckt. Unter dem Bett liegt ein *Baseballschlaeger*.";
    }

}

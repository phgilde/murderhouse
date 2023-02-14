package room.zimmer.zimmertrude;

import item.SimpleItem;
import room.view.View;

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
        return "Es ist ein Bett der Markenfirma 'IKEA'. Das Bett ist ziemlich schmal. "
                + "Die Bettwäsche ist mit vielen kleinen Spinnen bedruckt.Unter dem Bett liegt ein *Baseballschlaeger*.";
    }

}

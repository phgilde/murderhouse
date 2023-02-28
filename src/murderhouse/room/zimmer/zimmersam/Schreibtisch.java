package murderhouse.room.zimmer.zimmersam;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Schreibtisch extends View {
    public Schreibtisch() {
        items.put("boxhandschuhe", new SimpleItem("Boxhandschuhe",
                "Ein paar Boxhandschuhe. Sie sind ziemlich alt und sehen nicht mehr so gut aus. Bei genauerer Betrachtung fallen dir dunkelrote Flecken auf."));
    }

    @Override
    public String getName() {
        return "schreibtisch";
    }

    @Override
    public String getDescription() {
        return "Ein ziemlich aufgeräumter Schreibtisch. Auf dem Schreibtisch steht ein iMac, ein dekorativer Sukkulent und ein paar *Boxhandschuhe*.";
    }
}

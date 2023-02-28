package murderhouse.room.eingang;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner schluessel", new SimpleItem("brauner Schluessel",
                "Ein brauner Schluessel mit einem ledernen Schluesselband."));

    }

    public String getDescription() {
        return "In einer kleinen Schluesselkiste hängt ein *brauner Schluessel*.";
    }



    @Override
    public String getName() {
        return "Schluesselkiste";
    }
}

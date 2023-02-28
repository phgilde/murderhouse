package murderhouse.room.eingang;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner schluessel", new SimpleItem("brauner Schluessel",
                "Ein brauner Schluessel mit einem ledernen Schluesselband."));

    }

    public String getDescription() {
        return "Du siehts einen braunen Schluessel";
    }



    @Override
    public String getName() {
        return "Schluesselkiste";
    }
}

import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner Schluessel", new SimpleItem("brauner Schluessel",
                "Ein brauner Schluessel mit einem ledernen Schluesselband."));

    }

    public String getDescription() {
        return "du seihts zwei Schluessel";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

    @Override
    public String getName() {
        return "schluesselkiste";
    }
}

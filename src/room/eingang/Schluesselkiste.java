import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner schluessel", new SimpleItem("brauner schluessel",
                "Ein brauner Schluessel mit einem ledernen Schluesselband."));

    }

    public String getDescription() {
        return "Du siehts einen braunen Schluessel";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

    @Override
    public String getName() {
        return "Schluesselkiste";
    }
}

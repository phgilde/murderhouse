import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner Schlüssel", new SimpleItem("brauner Schlüssel",
                "Ein brauner Schlüssel mit einem ledernen Schlüsselband."));

    }

    public String getDescription() {
        return "du seihts zwei Schlüssel";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }
}

import room.view.View;
import java.util.Optional;

import item.Item;
import item.SimpleItem;

public class Schuhschrank extends View {

    public Schuhschrank() {
        items.put("rosa tanzschuhe", new SimpleItem("rosa Tanzschuhe", "Ein paar rosa Tanzschuhe aus Satin."));
        items.put("wanderschuhe", new SimpleItem("Wanderschuhe", "Orange Wanderschuhe Salomon Speedcross 3 Gradient Cherry Tomato."));
        items.put("laufschuhe", new SimpleItem("Laufschuhe", "Gelbe Laufschuhe von Nike."));

    }

    public String getDescription() {
        return "du siehst sechs Schuhe";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;

    }

    @Override
    public String getName() {
        return "schuhschrank";
    }


}

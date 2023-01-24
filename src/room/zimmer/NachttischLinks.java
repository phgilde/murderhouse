package room.zimmer;

import java.util.Optional;
import item.Item;
import room.view.View;

public class NachttischLinks extends View {

    @Override
    public String getDescription() {
        return "Ein kleiner Nachttisch aus Holz. Auf dem Nachttisch liegt ein *Buch*.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return "Es passiert nichts.";
    }
    
}

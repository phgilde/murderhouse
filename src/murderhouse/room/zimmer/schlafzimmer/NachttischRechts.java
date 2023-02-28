package murderhouse.room.zimmer.schlafzimmer;

import java.util.Optional;
import murderhouse.item.Item;
import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class NachttischRechts extends View {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Ein kleiner Nachttisch aus Holz. Auf dem Nachttisch liegt ein *Buch*. Der Nachttisch hat eine Schublade mit einem lilafarbenen Schloss.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if (heldItem.isPresent()) {
            if (heldItem.get().getName().equals("lila schluessel")) {
                return "Du findest eine Schublade voller Nachtische.";
            }
        }
        return "Du kannst die Schublade nicht oeffnen.";
    }

    @Override
    public String getName() {
        return "rechter nachttisch";
    }
}

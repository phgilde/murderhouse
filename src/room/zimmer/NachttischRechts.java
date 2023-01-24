package room.zimmer;

import java.util.Optional;
import item.Item;
import room.view.View;

public class NachttischRechts extends View {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Ein kleiner Nachttisch aus Holz. Auf dem Nachttisch liegt ein *Buch*. Der Nachttisch hat eine *Schublade* mit einem lilafarbenen Schloss.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

}

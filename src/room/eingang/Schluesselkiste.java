import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.View;

public class Schluesselkiste extends View {

    public Schluesselkiste() {
        items.put("brauner schluessel", new SimpleItem("brauner Schluessel",
                "Ein brauner Schluessel mit einem ledernen Schluesselband."));

    }

    public String getDescription() {
        if(items.size() == 2){
            return "Du siehst zwei Schluessel";
        } else if(items.size() == 1){
            return "Du siehst einen Schlüssel.";
        } else {
            return "Die Schluesselkiste ist leer";
        }
        
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

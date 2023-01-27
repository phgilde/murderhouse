package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import room.view.View;

public class Schrank extends View {

    @Override
    public String getDescription() {
        return "Du suchst nach dem nächsten Meisterwerk, das du lesen willst, als plötzlich etwas glänzendes deine Aufmerksamkeit weckt.\n"
        + "Im *Schrank* ist ein grünes Schloss versteckt. Scheinbar wollte Ole etwas verbergen";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return "";
    }
    
}

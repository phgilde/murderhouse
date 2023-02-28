package murderhouse.room.arbeitszimmer;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.View;

public class Schrank extends View {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Schrank";
    }

    @Override
    public String getDescription() {
        return "Du suchst nach dem naechsten Meisterwerk, das du lesen willst, als ploetzlich etwas glaenzendes deine Aufmerksamkeit weckt. "
                + "Im *Schrank* ist ein gruenes Schloss versteckt. Scheinbar wollte Ole etwas verbergen...";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if (heldItem.isPresent()) {
            if (heldItem.get().getName().equals("gruener schluessel")) {
                return "Der Schrank beginnt sich ploetzlich zu bewegen und du schreckst zurueck. Es oeffnet sich eine Tuer zu einem *Geheimzimmer*, dass du nun betreten kannst.";
            }

        }
        return "Das hat nicht geklappt.";
    }



}

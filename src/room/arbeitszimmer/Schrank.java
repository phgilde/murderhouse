package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import room.view.View;

public class Schrank extends View {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "schrank";
    }
    
    @Override
    public String getDescription() {
        return "Du suchst nach dem nächsten Meisterwerk, das du lesen willst, als plötzlich etwas glänzendes deine Aufmerksamkeit weckt.\n"
        + "Im *Schrank* ist ein grünes Schloss versteckt. Scheinbar wollte Ole etwas verbergen...";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if(heldItem.isPresent()){
            if(heldItem.get().getName().equals("gruener schluessel")){
                return "Der Schrant beginnt sich plötzlich zu bewegen und du schreckst zurück. *Es öffnet sich eine Tür zu einem Geheimzimmer*, dass du nun betreten kannst.";
            }

        }
        return "Das hat nicht geklappt.";
    }

    
    
}

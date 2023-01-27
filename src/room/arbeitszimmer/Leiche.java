package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.human.Human;

public class Leiche extends Human{
    boolean hatSchlüssel = true;
    boolean istTot = true;

    public Leiche(){
        items.put("gruener schlüssel", new SimpleItem("gruener schlüssel", ""));
    }

    @Override
    public String getDescription() {
        if(hatSchlüssel){
            return "Um Oles Hals hängt ein gruener Schlüssel";
        }
        return "";
    }

    @Override
    public String interact(Optional<Item> heldItem) {

    }

    @Override
    public String talk(Optional<Item> heldItem) {
        // TODO lustige Optionen
        if(istTot){
            return "Ole schweigt.";
        }
        
    }
    
}

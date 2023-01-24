package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.Human;
import room.view.View;

public class Leiche extends Human{
    boolean hatSchlüssel = true;
    boolean istTot = true;

    public Leiche(){
        items.put("grüner schlüssel", new SimpleItem("grüner schlüssel", ""));
    }

    @Override
    public String getDescription() {
        if(hatSchlüssel){
            return "Um Oles Hals hängt ein grüner Schlüssel";
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

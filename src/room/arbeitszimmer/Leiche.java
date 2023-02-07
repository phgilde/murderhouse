package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.human.Human;

public class Leiche extends Human{
    boolean hatSchlüssel = true;
    boolean istTot = true;

    public Leiche(){
        items.put("gruener schluessel", new SimpleItem("gruener schluessel", ""));
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
        return null;
    }

    @Override
    public String talk(Optional<Item> heldItem) {
        // TODO lustige Optionen
        if(istTot){
            return "Ole schweigt.";
        }
        return null;
    }

    @Override
    public String ask(String q) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

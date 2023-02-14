package room.arbeitszimmer;

import java.util.Optional;

import item.Item;
import item.SimpleItem;
import room.view.human.Human;

public class Leiche extends Human {
    boolean hatSchluessel = true;
    boolean istTot = true;

    public Leiche() {
        items.put("gruener schluessel", new SimpleItem("gruener schluessel", ""));
    }

    @Override
    public String getDescription() {
        String str = "Ole traegt eine gruene Jacke und eine graue Hose. Seine Hauschuhe sind ueberall verteilt. \n";
        if (items.containsKey("greuener schluessel")) {
            str += "Um Oles Hals haengt ein gruener Schluessel";
        }
        return str;
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

    @Override
    public String talk(Optional<Item> heldItem) {
        // TODO lustige Optionen
        if (istTot) {
            return "Ole schweigt.";
        }
        return null;
    }

    @Override
    public String getName() {
        return "leiche";
    }

    @Override
    public String ask(String q) {
        // TODO Auto-generated method stub
        return "Stille...";
    }
    
}

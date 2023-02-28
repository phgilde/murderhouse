package murderhouse.room.arbeitszimmer;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.item.SimpleItem;
import murderhouse.room.view.human.Human;

public class Leiche extends Human {
    boolean hatSchluessel = true;
    boolean istTot = true;
    private String[] replies = {"Ole schweigt.", "Ole sagt nichts.", "Ole starrt dich stumm an.", "Ole schaut dich an und sagt nichts.", "Ole bleibt liegen."};

    public Leiche() {
        items.put("gruener schluessel", new SimpleItem("gruener Schluessel", ""));
    }

    @Override
    public String getDescription() {
        String str = "Ole traegt eine gruene Jacke und eine graue Hose. Seine Hauschuhe sind ueberall verteilt.";
        if (items.containsKey("gruener schluessel")) {
            str += " Um Oles Hals haengt ein *gruener Schluessel*.";
        }
        return str;
    }

    

    @Override
    public String talk(Optional<Item> heldItem) {
        return replies[(int) Math.random() * replies.length];
    }

    @Override
    public String getName() {
        return "Leiche";
    }

    @Override
    public String ask(String q) {
        return replies[(int) Math.random() * replies.length];
    }
    
}

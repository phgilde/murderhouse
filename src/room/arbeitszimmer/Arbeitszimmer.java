
package room.arbeitszimmer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Arbeitszimmer extends Room{
    private HashMap<String, View> views = new HashMap<String, View>();

    public Arbeitszimmer(){
        adjacentRooms.add("saal");

        views.put("leiche", new Leiche());
        views.put("schrank", new Schrank());
    }

    @Override
    public String getName() {

        return "arbeitszimmmer";
    }

    @Override
    public String getDescription() {
        return "Im Arbeitszimmer angekommen siehst du die *Leiche* von Ole. Neben dir befindet sich ein schöner *Schrank*, der die gesamte Wand ausfüllt.\n"
        + "";
    }

    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return views;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        
    }
    
}

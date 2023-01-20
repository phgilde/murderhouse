import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Saal extends Room{
    private HashMap<String, View> views = new HashMap<String, View>();
    private LinkedList<String> adjacentRooms = new LinkedList<String>();

    public Saal(){
        adjacentRooms.add("eingang");
        adjacentRooms.add("wohnzimmer");
        adjacentRooms.add("küche");
        //TODO: Abzimmer gesperrt
        adjacentRooms.add("arbeitszimmer");
        adjacentRooms.add("flur");
    }

    @Override
    public String getName(){
        return "saal";    
    }

    @Override
    public String getDescription(){
        return "Du stehst in der Mitte des Saals. Von hier kommst du in fast alle Räume des Hauses."
        + "In *Wohnzimmer* brennt noch das Licht.\n"
        + "Aus der *Küche* duftet es prächtig nach deinem Lieblingsessen: Schokokuchen. \n"
        + "Überdeckt wird dieser göttliche Duft mit einer übelriechende Fahne aus dem *Arbeitszimmer*. \n"
        + "In deinem Nacken spürst du den kalten Windzug aus dem *Eingang* des Hauses."
        + "Dein Blick wandert auf die Treppe mit einem prachtvollen roten Teppich auf den Stufen, die zum oberen *Flur* führt. \n"
        + "Am Handlauf ist der Aufzug für einen Rollstuhl angebracht.";

    }

    @Override
    public List<String> getAdjacentRooms(){
        return adjacentRooms;
    }

    @Override
    public Map<String, View> getViews() {
        return views;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
    }
}
package murderhouse.room.saal;

import java.util.Map;
import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.Room;
import murderhouse.room.view.View;

public class Saal extends Room {

    public Saal() {
        adjacentRooms.add("eingang");
        adjacentRooms.add("wohnzimmer");
        adjacentRooms.add("kueche");
        adjacentRooms.add("arbeitszimmer");
        adjacentRooms.add("flur");
    }

    @Override
    public String getName() {
        return "Saal";
    }

    @Override
    public String getDescription() {
        return "Du stehst in der Mitte des Saals. Von hier kommst du in fast alle Raeume des Hauses."
                + "Im *Wohnzimmer* brennt noch das Licht. "
                + "Aus der *Kueche* duftet es praechtig nach deinem Lieblingsessen: Schokokuchen.  "
                + "ueberdeckt wird dieser goettliche Duft mit einer uebelriechende Fahne aus dem *Arbeitszimmer*.  "
                + "In deinem Nacken spuerst du den kalten Windzug aus dem *Eingang* des Hauses.  "
                + "Dein Blick wandert auf die Treppe mit einem prachtvollen roten Teppich auf den Stufen, die zum oberen *Flur* fuehrt.  "
                + "Am Handlauf ist der Aufzug fuer einen Rollstuhl angebracht.";
    }

    @Override
    public Map<String, View> getViews() {
        return views;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {}
}

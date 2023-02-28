package murderhouse.room.eingang;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.Room;
import murderhouse.room.view.View;

public class Eingang extends Room {


    public Eingang() {
        adjacentRooms.add("saal");
        adjacentRooms.add("draussen");
        views.put("schluesselkiste", new Schluesselkiste());
        views.put("schuhschrank", new Schuhschrank());
        views.put("planze", new Pflanze());
        views.put("bilderrahmen", new Bilderrahmen());
    }

    public String getName() {
        return "eingang";
    }

    @Override
    public String getDescription() {
        return "Du stehst im Eingangsbereich des Hauses. Du merkst dem Raum an, dass seine Einrichter sich der Wichtigkeit des ersten Eindruckes bewusst sind."
                + "Der Boden ist mit einem stilvollen Teppich ausgelegt, der die Eingangstuer umrahmt."
                + "Die Wande sind mit einem edlen Tapetenbehang verziert."
                + "Die Decke ist mit einem prachtvollen Kronleuchter beleuchtet."
                + "Was du zunächst für einen Picasso-Druck hältst, ist in Wirklichkeit ein goldverzierter Spiegel, der den Raum optisch vergrößert."
                + "Gegenüber des Spiegels hängt ein *Bilderrahmen*, dessen Gemaelde du nicht genau erkennen kannst."
                + "Hier befindet sich ein *Schuhschrank*, eine *Pflanze*, eine *Schluesselbox* und die Eingangstuer";

    }



    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub

    }
}

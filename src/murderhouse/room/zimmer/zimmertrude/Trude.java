package murderhouse.room.zimmer.zimmertrude;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Trude extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if (heldItem.isEmpty()) {
            return "'Er ist tot! Wie konnte das nur passieren???'";
        } else if (heldItem.get().getName().equals("baseballschlaeger")) {
            return "'Ja das ist Ben's. Oh was ist den da soviel Farbe dran? Da habe ich wohl beim Malen nicht gut aufgepasst.'";

        } else {
            return "'Darueber weiß ich leider nichts.'";
        }

    }

    @Override
    public String getDescription() {
        return "Trude ist eine etwa Mitte 20-Jahre alte Frau.";

    }

    @Override
    public String ask(String q) {
        if (q == "malsachen") {
            return "'Ich male gerne um zu entspannen'";
        } else if (q == "streit") {
            return "'Ja wir streiten uns manchmal wegen der Firma. Aber ich würde ihm nie etwas tun! Er ist mein Vater!'";
        } else {
            return "Was meinst du denn?";
        }
    }

    @Override
    public String getName() {
        return "Trude Fredericke Dödade";
    }
}

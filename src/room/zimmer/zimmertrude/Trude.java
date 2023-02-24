package room.zimmer.zimmertrude;

import java.util.Optional;

import item.Item;
import room.view.human.Human;

public class Trude extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if (n == 0) {
            if (heldItem.isEmpty()) {
                return "'Er ist tot! Wie konnte das nur passieren???'";
            } else if (heldItem.get().getName().equals("baseballschlaeger")) {
                return "'Ja das ist Ben's. Oh was ist den da soviel Farbe dran? Da habe ich wohl beim Malen nicht gut aufgepasst.'";

            } else {
                return "'Darueber weiß ich leider nichts.'";
            }
        } else {
            return null;
        }
    }

    @Override
    public String getDescription() {
        if (n == 0) {
            return "Trude ist eine etwa mitte 20-Jahre alte Frau.";
        } else {
            return "Trude scheint zu schlafen.";
        }
    }

    @Override
    public String ask(String q) {
        if (n == 0) {
            if (q == "Malsachen") {
                return "'Ich male gerne um zu entspannen'";
            } else if (q == "Streit") {
                return "'Ja wir streiten uns manchmal wegen der Firma. Aber ich würde ihm nie etwas tun! Er ist mein Vater!'";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        return "Trude Fredericke Dödade";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

}
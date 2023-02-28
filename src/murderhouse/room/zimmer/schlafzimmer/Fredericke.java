package murderhouse.room.zimmer.schlafzimmer;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Fredericke extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if (n == 0) {
            if (heldItem.isEmpty()) {
                return "'Da muss irgendein Hooligan eingebrochen sein und wollte wohl eine von Ole's teuren Uhren stehlen! Ole muss sich wohl gewaehrt haben! Der Gute!' *Schluchz* *Fredericke sinkt in vollkomender verzweiflung auf das Bett zurueck*";
            } else if (heldItem.get().getName().equals("boxhandschuhe")) {
                return "Niemals! Mein Sohn wuerde so etwas niemals machen!"
                        + " Was sind Sie den fuer ein Detektiv das Sie solche Hirngespenster in betracht ziehen! Also wirklich Dirk! Von Ihnen haette ich sowas nicht erwartet";
            } else {
                return "'Lassen Sie mich bitte in Ruhe. Mein Mann ist gerade gestorben! Ist das nicht genug?' *Schluchz*";
            }
        } else {
            return null;
        }
    }

    @Override
    public String getDescription() {
        if (n == 0) {
            return "Fredericke ist eine mitte 50-Jahre alte Frau. Ihr Haar beginnt zu grauen, und sie ist querschnitzgelaehmt";
        } else {
            return "Fredericke ist eine mitte 50-Jahre alte Frau. Ihr Haar beginnt zu grauen, und sie ist querschnitzgelaehmt und liegt bewegungslos am boden und scheint zu schlafen.";
        }
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

    @Override
    public String ask(String q) {
        return null;
    }

    @Override
    public String getName() {
        return "Fredericke Hildegart Dödade";
    }

}
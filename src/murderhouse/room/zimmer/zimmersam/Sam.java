package murderhouse.room.zimmer.zimmersam;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Sam extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if (n == 0) {
            if (heldItem.isEmpty()) {
                return "'Geh weg!'";
            } else if (heldItem.get().getName().equals("boxhandschuhe")) {
                return "'Ich boxe in meiner Freizeit. Ich mache manchmal bei Boxkaempfen mit die ... naja die nur so quasi legal sind'";

            } else {
                return "'Ich will nicht mit dir reden'";
            }
        } else {
            return null;
        }
    }

    @Override
    public String getDescription() {
        if (n == 0) {
            return "Sam ist etwa 18-Jahre alt, er hat eine sportlliche Figur.";
        } else {
            return "Sam liegt auf dem Boden. Er sieht ein wenig blass aus.";
        }
    }

    @Override
    public String ask(String q) {
        if (n == 0) {
            if (q == "Knall") {
                return "'Knall, welcher Knall? Papa hat nur die Kuehlschranktuer zugeworfen, sonst war da nichts'";
            } else if (q == "Streit") {
                return "'Er nervt -- Hat immer rumgenervt wegen meinen Verhaftungen, er glaubt das ich mein Leben nicht auf die Reihe kriege.'";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        return "Samuel Ole Doedade";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;
    }

}
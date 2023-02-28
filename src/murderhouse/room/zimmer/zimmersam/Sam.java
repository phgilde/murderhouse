package murderhouse.room.zimmer.zimmersam;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Sam extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if (heldItem.isEmpty()) {
            return "'Geh weg!'";
        } else if (heldItem.get().getName().equals("boxhandschuhe")) {
            return "'Ich boxe in meiner Freizeit. Ich mache manchmal bei Boxkaempfen mit die ... naja die nur so quasi legal sind'";

        } else {
            return "'Ich will nicht mit dir reden'";
        }
    }

    @Override
    public String getDescription() {
        return "Sam ist etwa 18-Jahre alt, er hat eine sportliche Figur.";
    }

    @Override
    public String ask(String q) {
        if (q == "knall") {
            return "'Knall, welcher Knall? Papa hat nur die Kuehlschranktuer zugeworfen, sonst war da nichts'";
        } else if (q == "streit") {
            return "'Er nervt -- Hat immer rumgenervt wegen meinen Verhaftungen, er glaubt das ich mein Leben nicht auf die Reihe kriege.'";
        } else {
            return "'Keine Ahnung wovon du redest.'";
        }
    }

    @Override
    public String getName() {
        return "Sam";
    }



}

package room.zimmer.zimmerole;

import java.util.Optional;
import item.Item;
import item.SimpleItem;
import room.view.View;

public class Kommode extends View {


    public Kommode() {
        items.put("goldkette", new SimpleItem("goldkette",
                "Eine kleine Goldkette mit einem Anhaenger: Ein Loewe, der einen roten Stein im Maul hat."));
        items.put("zigarre", new SimpleItem("zigarre",
                "Eine sehr teuer anmutende Zigarre. Auf dem goldenen Siegel steht 'Montecristo Classic Series'"));
    }

    @Override
    public String getDescription() {
        return "Eine Kommode aus bronzefarbenem Holz. Die Marmorierung beeindruckt dich sehr."
                + "Auf der Kommode liegt eine *Goldkette* sowie eine *Zigarre*.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return "Es passiert nichts.";
    }

    @Override
    public String getName() {
        return "kommode";
    }

}

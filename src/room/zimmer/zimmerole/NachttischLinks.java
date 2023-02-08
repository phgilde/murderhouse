package room.zimmer.zimmerole;

import java.util.Optional;
import item.Item;
import item.SimpleItem;
import room.view.View;

public class NachttischLinks extends View {

    @Override
    public String getDescription() {
        return "Ein kleiner Nachttisch aus Holz. Auf dem Nachttisch steht ein Nachtisch. Der Nachttisch hat eine Schublade mit einem rosafarbenden Schloss.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if (heldItem.isPresent()) {
            if (heldItem.get().getName().equals("rosa schluessel")) {
                items.put("brief", new SimpleItem("brief",
                        "Ein Brief an Frederike: 'Liebe Frederike, auch wenn es dir Sorgen bereitet: Ein neuer Lebensabschnitt beginnt. Mit dem Weggeben deiner"
                                + " Tanzschuhe schliesst du entgueltig mit dem alten ab. Ich denke, dass sich das Waisenkind sehr ueber sie freuen wird."
                                + " Mach dir garkeine Sorgen. Deine Hildegaard von Rôusenbusch III., Rosenheim, den 12. Mai 1998'"));
                items.put("blister", new SimpleItem("morphin",
                        "Ein Blister mit der Aufschrift: 'Morixon. Wirkstoff: 10 mg Morphinhydrochlorid'"));
                return "Du oeffnest die Schublade und findest darin einen *Brief*. Sowie ein Tablettenblister.";
            }
        }
        return "Es passiert nichts.";
    }

    @Override
    public String getName() {
        return "linker nachttisch";
    }
}

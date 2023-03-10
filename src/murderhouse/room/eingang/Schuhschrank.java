package murderhouse.room.eingang;

import murderhouse.room.view.View;
import murderhouse.item.SimpleItem;

public class Schuhschrank extends View {

    public Schuhschrank() {
        items.put("tanzschuhe",
                new SimpleItem("Tanzschuhe", "Ein paar rosa Tanzschuhe aus Satin."));
        items.put("wanderschuhe", new SimpleItem("Wanderschuhe",
                "Orange Wanderschuhe Salomon Speedcross 3 Gradient Cherry Tomato."));
        items.put("laufschuhe", new SimpleItem("Laufschuhe", "Gelbe Laufschuhe von Nike."));

    }

    public String getDescription() {
        return "Ein Holzschrank mit mehreren Klappschubladen. Auf dem Schrank liegt ein seidenes Tuch, auf dem in Glaesern verschiedene schoene Steine und Kristalle liegen."
                + (items.size() != 0
                        ? " In den Schubladen befinden sich "
                                + (items.containsKey("tanzschuhe") ? "*Tanzschuhe*, " : "")
                                + (items.containsKey("wanderschuhe") ? "*Wanderschuhe*, " : "")
                                + (items.containsKey("laufschuhe") ? "*Laufschuhe*. " : "")
                        : "");
    }


    @Override
    public String getName() {
        return "schuhschrank";
    }


}

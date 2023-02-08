package room.badezimmer;

import java.util.Optional;
import interaction.Reaction;
import item.Item;
import room.view.View;

public class Toilettenschüssel extends View {

    @Override
    public String getName() {
        return "toilettenschüssel";
    }

    @Override
    public String getDescription() {
        return "Ja, das ist eine Toilettenschüssel. Was kann man dazu noch besonders sagen?"
                + " Sie ist rund, aus weißem Porzellan und hat einen Rand. In der Mitte ist ein Loch mit Wasser drin.";
    }

    @Override
    public Reaction interactReaction(Optional<Item> heldItem) {
        if (heldItem.isPresent()) {
            return new Reaction("Du spülst " + heldItem.get().getName() + " in der Toilette herunter.", true);
        }
        return new Reaction("Du spülst die Toilette ab");
    }
}

package murderhouse.room.wohnzimmer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import murderhouse.item.Item;
import murderhouse.room.view.View;

public class Fernseher extends View {
    private boolean isOn = false;

    @Override
    public String getDescription() {
        if (isOn) {
            return "Ein alter Roehrenfernseher, der sicherlich mal sehr teuer war, aber hier nur noch fehl am Platz wirkt. Der Fernseher ist an. Ein Nachrichtensprecher"
            + " erzählt neben einer Aufnahme eines Skigebietes ohne Schnee, etwas, du kannst aber nichts verstehen, weil der Ton aus ist.";
        } else {
            return "Ein alter Roehrenfernseher, der sicherlich mal sehr teuer war, aber hier nur noch fehl am Platz wirkt. Der Fernseher ist aus.";
        }
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if (isOn) {
            isOn = false;
            return "Du schaltest den Fernseher aus.";
        } else {
            isOn = true;
            return "Du schaltest den Fernseher an.";
        }
    }

    @Override
    public String getName() {
        return "Fernseher";
    }


}

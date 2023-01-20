import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import item.Item;
import room.view.View;

public class Fernseher extends View {
    private boolean isOn = false;

    @Override
    public String getDescription() {
        if (isOn) {
            return "Ein alter Röhrenfernseher. Der Fernseher ist an. Du siehst eine Nachrichtensendung.";
        } else {
            return "Ein alter Röhrenfernseher. Der Fernseher ist aus.";
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

    
}

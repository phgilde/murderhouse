import room.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import item.Item;
import item.Schuhe;

public class Schuhschrank extends View {
    private HashMap<String, Item> items = new HashMap<>();

    public Schuhschrank() {
        items.put("Schuhrosa", new Schuhe("rosa"));
        items.put("Schuhbraun", new Schuhe("braun"));
        items.put("Schuhblau", new Schuhe("blau"));
        items.put("Schuhschwarz", new Schuhe("schwarz"));
        items.put("Schuhweiß", new Schuhe("weiß"));
        items.put("Schuhgrau", new Schuhe("grau"));

    }

    public String getDescription() {
        return "du siehst sechs Schuhe";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;

    }

    @Override
    public Map<String, Item> getAvailableItems() {

        return items;
    }
}

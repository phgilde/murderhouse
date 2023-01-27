import room.view.View;
import java.util.Optional;

import item.Item;
import item.Schuhe;

public class Schuhschrank extends View {

    public Schuhschrank() {
        items.put("schuhrosa", new Schuhe("rosa"));
        items.put("schuhbraun", new Schuhe("braun"));
        items.put("schuhblau", new Schuhe("blau"));
        items.put("schuhschwarz", new Schuhe("schwarz"));
        items.put("schuhweiß", new Schuhe("weiß"));
        items.put("schuhgrau", new Schuhe("grau"));

    }

    public String getDescription() {
        return "du siehst sechs Schuhe";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        return null;

    }


}

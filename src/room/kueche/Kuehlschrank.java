package room.kueche;

import item.SimpleItem;
import room.view.View;

public class Kuehlschrank extends View {

    public Kuehlschrank() {
        items.put("steak", new SimpleItem("Steak", "Ein riesiges Steak. Es ist ziemlich roh."));
    }
    @Override
    public String getName() {
        return "kuehlschrank";
    }

    @Override
    public String getDescription() {
        return "Ein ziemlich großer Kuehlschrank. Der Kuehlschrank ist komplett leer, bis auf ein riesiges *Steak*.";
    }

}

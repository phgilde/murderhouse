package murderhouse.room.kueche;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

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
        String str = "Ein ziemlich großer Kuehlschrank. Der Kuehlschrank ist komplett leer";
        if(items.containsKey("steak")){
            str += ", bis auf ein riesiges *Steak*";
        }
        return str + ".";
    }

}

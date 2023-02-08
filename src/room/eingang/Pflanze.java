import java.util.Optional;

import item.Item;
import room.view.View;

public class Pflanze extends View {

    @Override
    public String getDescription() {

        return "Das ist eine GrOßE gRüNe ZiMmErPlAnZe";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return "pflanze";
    }

}

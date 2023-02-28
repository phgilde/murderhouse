package murderhouse.room.eingang;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.View;

public class Pflanze extends View {
    public Pflanze(){}

    @Override
    public String getDescription() {

        return "Das ist eine GrOssE gRueNe ZiMmErPlAnZe";
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

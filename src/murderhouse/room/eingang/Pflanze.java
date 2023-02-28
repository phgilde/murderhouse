package murderhouse.room.eingang;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.View;

public class Pflanze extends View {
    public Pflanze(){}

    @Override
    public String getDescription() {

        return "Das ist ein sehr gut gepflegter Gummibaum. Er ist sehr hoch und hat viele Blaetter.";
    }


    @Override
    public String getName() {
        return "Pflanze";
    }

}

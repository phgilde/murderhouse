package room.view.human;

import java.util.Optional;

import item.Item;

public class svaeltande extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        return "'woof'";
    }

    @Override
    public String ask(String q) {
        
        return "'wooooooff, wau wau, wouuuuuuoooofff'";
    }

    @Override
    public String getName() {
        return "svaeltande";
    }

    @Override
    public String getDescription() {
        
        return "Svaeltande ist ein struppiger irischer Wolfshund.";
    }
    
}

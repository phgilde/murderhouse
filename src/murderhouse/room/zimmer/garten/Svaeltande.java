package murderhouse.room.zimmer.garten;

import java.util.Optional;

import murderhouse.interaction.Reaction;
import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Svaeltande extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if(heldItem.isPresent() && heldItem.get().getName().equals("Steak")){
                return "'Wau! Wau! wooof!!!'" ;
           
            }else{
                return "'woof'";    
        }
        
    }
    @Override
    public Reaction interactReaction(Optional<Item> heldItem) {
        if (heldItem.isPresent()){
        if (heldItem.get().getName().equals("Steak")) {
            return new Reaction("Du fuetterst den Hund mit " + heldItem.get().getName() , true);
            
        }
        return new Reaction("");
    }else{
        return new Reaction("Du streichelst den Hund.");
    }
    }
    
    @Override
    public String ask(String q) {
        
        return "'wooooooff, wau wau, wouuuuuuoooofff'";
    }

    @Override
    public String getName() {
        return "Svaeltande";
    }

    @Override
    public String getDescription() {
        
        return "Svaeltande ist ein struppiger irischer Wolfshund.";
    }
    
}

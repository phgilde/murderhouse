package room.view.human;

import java.util.Optional;

import interaction.Reaction;
import item.Item;

public class svaeltande extends Human {

    @Override
    public String talk(Optional<Item> heldItem) {
        if(heldItem.get().getName().equals("steak")){
            return "'Wau! Wau! wooof!!!'" ;
       
        }else{
            return "'woof'";
        }
    }
    @Override
    public Reaction interactReaction(Optional<Item> heldItem) {
        if (heldItem.isPresent()){
        if (heldItem.get().getName().equals("steak")) {
            return new Reaction("Du fütterst den Hund mit " + heldItem.get().getName() , true);
            
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

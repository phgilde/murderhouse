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
            return new Reaction("Du spuelst " + heldItem.get().getName() + " in der Toilette herunter.", true);
        }
        return new Reaction("Du spuelst die Toilette ab");
    }else{
        return new Reaction("");
    }
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

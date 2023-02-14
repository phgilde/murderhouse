package room.view.human;

import java.util.Optional;

import item.Item;
import room.view.human.Human;

public class Trude extends Human {
    
    @Override
    public String talk(Optional<Item> heldItem) {
        if(heldItem.isEmpty()){
        return "'Er ist tot! Wie konnte das nur passieren???'";
        }else if(heldItem.get().getName().equals("baseballschlaeger")){
            return "'Ja das ist Ben's. Oh was ist den da soviel Farbe dran? Da habe ich wohl beim Malen nicht gut aufgepasst.'" ;
        }else{
            return "'Lassen Sie mich bitte in Ruhe. Mein Mann ist gerade gestorben! Ist das nicht genug?' *Schluchz*";
        }

    }

    @Override
    public String getDescription() {
        
        return "Fredericke ist eine mitte 50-Jahre alte Frau. Ihr Haar beginnt zu grauen, und sie ist querschnitzgelähmt";
    }



    @Override
    public String ask(String q) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

}
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
            return "'Darueber weiß ich leider nichts.'";
        }

    }

    @Override
    public String getDescription() {
        
        return "Trude ist eine etwa mitte 20-Jahre alte Frau.";
    }



    @Override
    public String ask(String q) {
    if(q =="Malsachen"){
        return "'Ich male gerne um zu entspannen'" ;
    }else{
        return null; 
    }
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
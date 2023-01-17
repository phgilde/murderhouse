import java.util.HashMap;
import java.util.Optional;

import item.Item;
import item.Schluessel;
import room.view.View;

public class Schluesselkiste extends View {
    private HashMap<String, Item> items = new HashMap<>();

    public Schluesselkiste(){
     items.put("Schluesselbraun", new Schluessel("braun"));
     
    }

    public String getDescription(){
      return "du seihts zwei Schlüssel"; 
    }
    @Override
    public Object interact(Optional<Item> heldItem){
        return null; 
    }
}
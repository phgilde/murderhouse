import room.view.View;
import java.util.HashMap;
import java.util.Optional;

import item.Item;
import item.Schuhe;

public class Schuhschrank extends View{
    private HashMap<String, Item> items = new HashMap<>();

    public Schuhschrank(){
     items.put("Schluesselbraun", new Schuhe("rosa"));
     
    }

    public String getDescription(){
      return "du seihts zwei Schlüssel"; 
    }
    @Override
    public Object interact(Optional<Item> heldItem){
        return null; 
    }
}
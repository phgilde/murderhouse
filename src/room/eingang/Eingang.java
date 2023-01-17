import java.util.HashMap;
import java.util.LinkedList;
import room.Room;
import room.view.View;

public class Eingang extends Room{
    private LinkedList<String> adjacentRooms = new LinkedList<String>();
    private HashMap<String, View> views = new HashMap<>();

    public Eingang(){
      adjacentRooms.add("Treppenhaus");
      adjacentRooms.add("Draussen");
      views.put("Schluesselkiste", new Schluesselkiste());
      views.put("Schuhschrank", new Schuhschrank()); 
    }


    public getName(){
        return "Eingang";
    }

    @Override
    public getDescription(){
          return "In dem Eingang befindet sich ein Schuhschrank, eine Zimmerplanze, eine Schlüsselbox und die Eingangstür";


    }

    @Override
    public List<String> getAdjacentRooms() {
        return adjacentRooms ;
    }

    @Override
    public Map<String, View> getViews() {
        return views;

    }

    public void interact(View view, Optional<Item> heldItem) {
        
    }
}
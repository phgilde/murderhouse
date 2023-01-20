package room.oben;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Oben extends Room{
    private LinkedList<String> adjacentRooms = new LinkedList<String>(); 
    
    public Oben(){
        adjacentRooms.add("RaumOle");
    }

    @Override
    public String getName() {
        return "Oben";
    }

    @Override
    public String getDescription() {
        return "Völlig außer Atem überlegst du in welchen der verschiedenen Räume du gehen willst"
        + "Du siehst das Zimmer von Ole";
    }

    @Override
    public List<String> getAdjacentRooms() {
        return null;
    }

    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        
    }
    
}



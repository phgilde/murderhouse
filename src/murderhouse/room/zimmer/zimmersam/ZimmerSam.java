package murderhouse.room.zimmer.zimmersam;

import murderhouse.room.Room;

public class ZimmerSam extends Room {

    public ZimmerSam() {
        adjacentRooms.add("flur");
        views.put("schreibtisch", new Schreibtisch());
        views.put("sam", new Sam()); 
    }
    @Override
    public String getName() {
        return "Sams Zimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich in Sams Zimmer. Sam hat ein riesiges Bett auf dem er ein Buch zu lesen scheint, ein Regal mit vielen Buechern und ein *Schreibtisch* mit einem Computer. Von hier kannst den *Flur* gehen.";
    }
    
}

package room.zimmer.zimmersam;

import room.Room;

public class ZimmerSam extends Room {

    public ZimmerSam() {
        views.put("schreibtisch", new Schreibtisch());
    }
    @Override
    public String getName() {
        return "sams zimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich in Sams Zimmer. Sam hat ein riesiges Bett, ein Regal mit vielen Büchern und ein *Schreibtisch* mit einem Computer. Von hier kannst den *Flur* gehen.";
    }
    
}

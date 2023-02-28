package murderhouse.room.zimmer.zimmersam;

import murderhouse.room.Room;

public class ZimmerSam extends Room {

    public ZimmerSam() {
        views.put("schreibtisch", new Schreibtisch());
        views.put("sam", new Sam()); 
    }
    @Override
    public String getName() {
        return "sams zimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich in Sams Zimmer. Sam hat ein riesiges Bett auf dem er ein Buch zulesen scheint, ein Regal mit vielen Büchern und ein *Schreibtisch* mit einem Computer. Von hier kannst den *Flur* gehen.";
    }
    
}

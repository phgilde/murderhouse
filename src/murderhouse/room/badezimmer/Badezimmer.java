package murderhouse.room.badezimmer;

import murderhouse.room.Room;

public class Badezimmer extends Room {

    public Badezimmer() {
        adjacentRooms.add("flur");
        views.put("spiegelschrank", new Spiegelschrank());
        views.put("toilettenschuessel", new Toilettenschuessel());
    }
    @Override
    public String getName() {
        return "Badezimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Badezimmer. Es ist ziemlich warm und feucht hier. ueber dem Waschbecken haengt ein *Spiegelschrank*. "
                + "Unter dem Fenster ist ist ein Whirlpool. Gegenueber der Duschkabine befindet sich eine kleine Sauna."
                + " Die *Toilettenschuessel* scheint dir irgendwie unpraktisch platziert."
                + "Von hier aus kannst du in den *Flur* gehen.";
    }

}

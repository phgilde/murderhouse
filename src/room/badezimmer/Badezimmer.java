package room.badezimmer;

import room.Room;

public class Badezimmer extends Room {

    public Badezimmer() {
        adjacentRooms.add("flur");
        views.put("spiegelschrank", new Spiegelschrank());
        views.put("toilettenschüssel", new Toilettenschüssel());
    }
    @Override
    public String getName() {
        return "badezimmer";
    }

    @Override
    public String getDescription() {
        return "Du befindest dich im Badezimmer. Es ist ziemlich warm und feucht hier. Über dem Waschbecken hängt ein *Spiegelschrank*."
                + "Unter dem Fenster ist ist ein Whirlpool. Gegenüber der Duschkabine befindet sich eine kleine Sauna."
                + " Die *Toilettenschüssel* scheint dir irgendwie unpraktisch platziert."
                + "Von hier aus kannst du in den *Flur* gehen.";
    }

}

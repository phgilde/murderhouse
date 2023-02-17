package room.geheimzimmer;

import java.util.Map;

import room.Room;
import room.view.View;

public class Geheimzimmer extends Room {


    public Geheimzimmer(){

        adjacentRooms.add("saal");
        views.put("tisch", new Tisch());
        views.put("computer", new Computer());
    }   

    @Override
    public String getName() {
        return "geheimzimmer";
    }

    @Override
    public String getDescription() {
        return "Im Geheimzimmer siehst du den Arbeitsplatz von Ole vor dir. Der *Tisch* ist überfuellt mit jeglichen Sachen: Dokumente, Zettel und Elektronik. \n"
        + "In der Mitte des Tisches steht der *Computer* von Ole. Du wanderst hin und her und ueberlegst was du als naechstes machen willst";
    }

}

package murderhouse.room.geheimzimmer;

import java.util.Map;

import murderhouse.room.Room;
import murderhouse.room.view.View;

public class Geheimzimmer extends Room {


    public Geheimzimmer(){
        adjacentRooms.add("arbeitszimmer");
        views.put("tisch", new Tisch());
        views.put("computer", new Computer());
    }   

    @Override
    public String getName() {
        return "Geheimzimmer";
    }

    @Override
    public String getDescription() {
        return "Das Geheimzimmer ist ein kleiner dunkler Raum, der sehr unaufgeraeumt ist. Ein Regal mit Konservendosen und Wasserkanistern steht neben einem kleinen Bett. "
        + "Im Geheimzimmer siehst du den Arbeitsplatz von Ole vor dir. Der *Tisch* ist überfuellt mit jeglichen Sachen: Dokumente, Zettel und Elektronik.  "
        + "In der Mitte des Tisches steht der *Computer* von Ole. Du wanderst hin und her und ueberlegst was du als naechstes machen willst. Von Hier aus kannst du wieder ins *Arbeitszimmer* zurueckkehren.";
    }

}

package murderhouse.room.draussen;

import murderhouse.room.Room;

public class Draussen extends Room {

    public Draussen() {
        adjacentRooms.add("eingang");
        adjacentRooms.add("garten");
    }

    @Override
    public String getName() {
        return "Draussen";
    }

    @Override
    public String getDescription() {
        return "Du stehst vor dem Eingang des Hauses. Das Haus steht auf einer kleinen Insel. Um dich herum ist nur Wasser. "
                + "In der Ferne siehst du Festland, und kleine Boote, die sich auf die Insel zu bewegen. "
                + "Vor dir ist eine Klippe zum Wasser hin. Ein gepflasterer Pfad fuehrt zu einer in den Stein gehauenen"
                + " Treppe fuehrt zu einem Steg, seltsamerweise siehst du an diesem aber kein Boot."
                + "Vor hier kannst du wieder in den *Eingang* gehen. Ein Weg durch das Gestruepp fuehrt in den *Garten*.";
    }
}

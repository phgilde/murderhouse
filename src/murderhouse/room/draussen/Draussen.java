package murderhouse.room.draussen;

import murderhouse.room.Room;

public class Draussen extends Room {

    @Override
    public String getName() {
        return "Draussen";
    }

    @Override
    public String getDescription() {
        return "Du stehst vor dem Eingang des Hauses. Das Haus steht auf einer kleinen Insel. Um dich herum ist nur Wasser. "
                + "In der Ferne siehst du Festland, und kleine Boote, die sich auf die Insel zu bewegen. "
                + "Vor dir ist eine Klippe zum Wasser hin. Ein gepflasterer Pfad führt zu einer in den Stein gehauenen"
                + " Treppe führt zu einem Steg, seltsamerweise siehst du an diesem aber kein Boot."
                + "Vor hier kannst du wieder in den *Eingang* gehen. Ein Weg durch das Gestrüpp führt in den *Garten*.";
    }
}

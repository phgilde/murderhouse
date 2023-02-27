package room.draussen;

import room.Room;

public class Draussen extends Room {

    @Override
    public String getName() {
        return "draussen";
    }

    @Override
    public String getDescription() {
        return "Du stehst vor dem Eingang des Hauses. Das Haus steht inmitten einer kleinen Insel. Um dich herum ist nur Wasser. "
                + "In der Ferne siehst du Festland, und kleine Boote, die sich auf die Insel zu bewegen. "
                + "Vor dir ist eine Klippe zum Wasser hin. Eine in den Stein gehauene Treppe führt zu einem kleinen Strand."
                + "Vor hier kannst du wieder in den *Eingang* gehen.";
    }

}

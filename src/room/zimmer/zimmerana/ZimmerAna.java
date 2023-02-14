package room.zimmer.zimmerana;

import room.Room;

public class ZimmerAna extends Room {

    @Override
    public String getName() {
        return "anas zimmer";
    }

    @Override
    public String getDescription() {
        return "Das Zimmer ist ziemlich klein, aber es ist sehr gemütlich."
                + "Hier ist ein Bett mit einem Schrank darunter. Auf dem Fensterbrett steht eine *Topfpflanze*. Die Wände sind voller Kunstdrucke.";
    }

}

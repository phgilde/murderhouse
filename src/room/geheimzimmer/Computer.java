package room.geheimzimmer;

import item.SimpleItem;
import room.view.View;

public class Computer extends View{

    public Computer(){
        items.put("USB-Stick", new SimpleItem("USB-Stick", "Auf dem USB-Stick steht die Aufschrift: STRENG GEHEIM!!"));
    }
    @Override
    public String getName() {
        return "computer";
    }

    @Override
    public String getDescription() {
        return "Auf dem Monitor siehst du echt ekelhafte Bilder und einen *USB-Stick* in der Seite stecken.";
    }
    
}

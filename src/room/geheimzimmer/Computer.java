package room.geheimzimmer;

import item.SimpleItem;
import room.view.View;

public class Computer extends View{

    public Computer(){
        items.put("usb-stick", new SimpleItem("USB-Stick", "Auf dem USB-Stick steht die Aufschrift: STRENG GEHEIM!!"));
    }
    @Override
    public String getName() {
        return "computer";
    }

    @Override
    public String getDescription() {
        String str = "Auf dem Monitor siehst du echt ekelhafte Bilder";
        if(items.containsKey("usb-stick")){
            str += " und einen *USB-Stick* in der Seite stecken";
        }
        return str + ".";
    }
    
}

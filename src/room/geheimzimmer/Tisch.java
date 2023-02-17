package room.geheimzimmer;

import item.SimpleItem;
import room.view.View;

public class Tisch extends View {

    public Tisch(){
        items.put("notizbuch", new SimpleItem("notizbuch", 
        "Notizbuchinhalt"
        ));

        items.put("bueste", new SimpleItem("bueste", 
        "Du hebst die Bueste an und bemerkst, dass sie gar nicht so schwer ist wie erwartet. Du gugckst dir die Blutflecken genauer an.\n"
        + "Du bemerkst das auf der Büste gar nicht der Name Shakespeer steeht, sonder eine Gravur: Für Fredericke."
        ));
    }

    @Override
    public String getName() {
        return "tisch";
    }

    @Override
    public String getDescription() {
        String str = "Der Tisch ist komplett verwüstet. \n";
        if(items.containsKey("notizbuch")){
            str += "Die findest ein *Notizbuch* mit deinem Namen drauf. Das Buch ist mit einem Zahlenschloss versiegelt.\n";
        }
        
        if(items.containsKey("bueste")){
        str += "Dein Blick wandert in die Ecke, wo die *Bueste* von Shakespeer steht. Dich wundert warum diese hier ist und vor allem, warum Blutspuren an der scharfen Kante erkennbar sind. \n";
        }
        
        if(items.containsKey("gewehr")){
        str += "Über dem Tisch hängt ein *Gewehr*. Es hängt schief, als hätte es jemand bewegt. ";
        }
        
        return str;
    }
    
}

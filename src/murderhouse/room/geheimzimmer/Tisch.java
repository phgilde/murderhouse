package murderhouse.room.geheimzimmer;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Tisch extends View {

    public Tisch(){
        items.put("notizbuch", new SimpleItem("Notizbuch", 
        "----- Notizbuch von Detektiv Dieter ----- "
        +"3. Juli 2019: "
        +"Der Auftrag fuer mich besteht darin, belastende Inhalte gegen meinen Arbeitgeber von Objekt Ole zurueckzuholen. "
        +"Fuer die Ausfuehrung dieses Auftrages sind die entstehenden Schaeden nicht von Bedeutung. "
        +"Private Notiz: Scheint so als haette da jemand vergessen seinen Browserverlauf zu loeschen. "
        +" "
        +"19. Juli 2019: "
        +"Ich erhielt eine Einladung von Ole zu seinem 60. Geburtstag am 26.Juli. Es scheint so als wuerde er nichts wittern und  "
        +"und mir sein vollstes Vertrauen zu schenken."
        +" "
        +"26. Juli 2019: "
        +"Ich habe den belastenden USB-Stick gefunden. Jetzt muss ich nur noch spurlos verschwinden. Sollte das nicht klappen  "
        +"muss Ole von der Bildflaeche entfernt werden. Der Mord liesse sich eventuell mithilfe der Shakespeare Bueste auf die Fredericke schieben. "
        +"------ Ende -------"


        ));

        items.put("bueste", new SimpleItem("bueste", 
        "Du hebst die Bueste an und bemerkst, dass sie gar nicht so schwer ist wie erwartet. Du gugckst dir die Blutflecken genauer an. "
        + "Du bemerkst das auf der Bueste gar nicht der Name Shakespeare steeht, sonder eine Gravur: Fuer Fredericke."
        ));

        items.put("gewehr", new SimpleItem("Gewehr", "Das Gewehr ist voll geladen und hat an der Schulterstuetze ein paar Kratzer"));
    }

    @Override
    public String getName() {
        return "tisch";
    }

    @Override
    public String getDescription() {
        String str = "Der Tisch ist komplett verwuestet.  ";
        if(items.containsKey("notizbuch")){
            str += "Die findest ein *Notizbuch* mit deinem Namen drauf. Das Buch ist mit einem Zahlenschloss versiegelt. ";
        }
        
        if(items.containsKey("bueste")){
        str += "Dein Blick wandert in die Ecke, wo die *Bueste* von Shakespeare steht. Dich wundert warum diese hier ist und vor allem, warum Blutspuren an der scharfen Kante erkennbar sind.  ";
        }
        
        if(items.containsKey("gewehr")){
        str += "ueber dem Tisch haengt ein *Gewehr*. Es haengt schief, als haette es jemand bewegt. ";
        }
        
        return str;
    }
}
    


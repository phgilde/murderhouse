package murderhouse.room.geheimzimmer;

import murderhouse.item.SimpleItem;
import murderhouse.room.view.View;

public class Tisch extends View {

    public Tisch(){
        items.put("notizbuch", new SimpleItem("notizbuch", 
        "----- Notizbuch von Detektiv Dieter ----- "
        +"3. Juli 2019: "
        +"Der Auftrag für mich besteht darin, belastende Inhalte gegen meinen Arbeitgeber von Objekt Ole zurückzuholen. "
        +"Für die Ausführung dieses Auftrages sind die entstehenden Schäden nicht von Bedeutung. "
        +"Private Notiz: Scheint so als hätte da jemand vergessen seinen Browserverlauf zu löschen. "
        +" "
        +"19. Juli 2019: "
        +"Ich erhielt eine Einladung von Ole zu seinem 60. Geburtstag am 26.Juli. Es scheint so als würde er nichts wittern und  "
        +"und mir sein vollstes Vertrauen zu schenken."
        +" "
        +"26. Juli 2019: "
        +"Ich habe den belastenden USB-Stick gefunden. Jetzt muss ich nur noch spurlos verschwinden. Sollte das nicht klappen  "
        +"muss Ole von der Bildflaeche entfernt werden. Der Mord ließe sich eventuell mithilfe der Shakespeare Bueste auf die Fredericke schieben. "
        +"------ Ende -------"


        ));

        items.put("bueste", new SimpleItem("bueste", 
        "Du hebst die Bueste an und bemerkst, dass sie gar nicht so schwer ist wie erwartet. Du gugckst dir die Blutflecken genauer an. "
        + "Du bemerkst das auf der Büste gar nicht der Name Shakespeare steeht, sonder eine Gravur: Für Fredericke."
        ));

        items.put("gewehr", new SimpleItem("gewehr", "Das Gewehr ist voll geladen und hat an der Schulterstütze ein paar Kratzer"));
    }

    @Override
    public String getName() {
        return "tisch";
    }

    @Override
    public String getDescription() {
        String str = "Der Tisch ist komplett verwüstet.  ";
        if(items.containsKey("notizbuch")){
            str += "Die findest ein *Notizbuch* mit deinem Namen drauf. Das Buch ist mit einem Zahlenschloss versiegelt. ";
        }
        
        if(items.containsKey("bueste")){
        str += "Dein Blick wandert in die Ecke, wo die *Bueste* von Shakespeare steht. Dich wundert warum diese hier ist und vor allem, warum Blutspuren an der scharfen Kante erkennbar sind.  ";
        }
        
        if(items.containsKey("gewehr")){
        str += "Über dem Tisch hängt ein *Gewehr*. Es hängt schief, als hätte es jemand bewegt. ";
        }
        
        return str;
    }
}
    


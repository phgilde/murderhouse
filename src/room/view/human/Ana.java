package room.view.human;

import java.util.Optional;

import item.Item;

public class Ana extends Human {
    int n = 0;  
    @Override
    public String talk(Optional<Item> heldItem) {
        if(heldItem.isEmpty()){
        return "'Ich weiß gar nicht was ich denken soll! Der arme Mann ist einfach Tod!'" + "'Das tut mir ja wahnsinnig leid für ihn. Und er hatte gerade erst einen |Streit| mit beiden Kindern. Ach gottchen'";
        }else if(heldItem.get().getName().equals("baseballschlaeger")){
            return "'Ach das ist doch der von Trudes Freund! Tja Ben, der Gute, ist leider sehr vergesslich. Der würde seinen eigenen Kopf vergessen wäre er nicht angeschraubt!'" + 
            "'Was sind denn diese roten Spritzer? Da muss Trude den Schläger wohl auf ihrem Maltisch gehabt haben!'"; 
        }else if(heldItem.get().getName().equals("brief")){
            if (n == 0){
                return "'Was ist das denn?'"; 
            }else{
            return "'Ahhhhh... Ich sehe Sie haben eins und eins zusammen gezählt. Ja das ist eine recht unangenehme Angelegenheit. Sie sehen seit dem Unfall war Fredericke verständlicher Weise nicht mehr Sie selbst.'"
            + "'Naja und da hat sich Ole nach einer anderen Umgeschaut...Bella ist eine Tanzlehrerin an der selben Tanzschule an der auch Fredericke lehrte.'" + 
            "'Seit dem Unfall vor 6 Monaten war Bella bereits mehrere Male hier im Haus. Sie ist Freitag erst kurz bevor Sie gekommen sind abgefahren.'"+
            "'Ich bin, um ehrlich mit Ihnen zu sein, erstaunt dass Fredericke noch nichts von Ole's Affäre mitbekommen hat. Sie ist eigentlich sehr aufmerksam.'"; 
            }
        }else if(heldItem.get().getName().equals("schuhrosa")){
            n = n +1; 
            return "'Das sind die Tanzschuhe von Fredericke oder nicht?? Hahaha. '"; 
        }else if(heldItem.get().getName().equals("morphin")){
            return "'Morphin ist in hohen Menge tödlich! Aber es wurde Fredericke wegen dem Autounfall verschrieben' ";
        }else{
            return "'Ach, Hallo Dieter, sind Sie schon weiter mit dem Fall?'";
        }

    }

    @Override
    public String getDescription() {
        
        return "Ana Blurr ist eine etwa 30-jährige Frau";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String ask(String q) {
        if(q == "Streit"){
        return "'Naja, erst hatte der Alte sich am Freitag mit Trude gestritten, sie ist sehr involviert in die Zukunft der Famillien-Firma. Und eigentlich immer was anderes vor als Ole." +
        "Dann am gestern stritt er sich mit Sam: Der Sam, müssen Sie Wissen, ist kein Musterjunge. Er wurde schon zweimal verhaftet, gestern sind sie dann nocheinmal aneinader gefahren...  "
        + "Das war so um 21 Uhr... Oh nein kurz danach habe ich ein Schlag gehört. Ich dachte das wäre die Kühlschranktür, aber was wenn Sam seinen Vater erschlagen hat?'";
        }else if(q == "Fingerhut"){
            return "'Finden Sie nicht auch der Fingerhut ist eine faszinierende Pflanze? Sie ist hochgiftig und trotzdem wunderschön. Ich hab mich schon als kleines Mädchen dafür interessiert."
            + "Ich studiere auch gerade online Arznei. Ich möchte nämlich später eine Apotheke eröffnen'";
        }else{
            return null; 
        }
    }

}

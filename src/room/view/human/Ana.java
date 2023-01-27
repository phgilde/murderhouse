package room.view.human;

import java.util.Optional;

import item.Item;

public class Ana extends Human {
    int n = 0;  
    @Override
    public String talk(Optional<Item> heldItem) {
        if(heldItem.isEmpty()){
        return "'Ich weiß gar nicht was ich denken soll! Der arme Mann ist einfach Tod!'" + "'Das tut mir ja wahnsinnig leid für ihn. Und er hatte gerade erst einen *Streit* mit beiden Kindern. Ach gottchen'";
        }else if(heldItem.get().getName().equals("baseballschlaeger")){
            return "'Ach das ist doch der von Trudes Freund! Tja Ben, der Gute, ist leider sehr vergesslich. Der würde seinen eigenen Kopf vergessen wäre er nicht angeschraubt!'" + 
            "'Was sind denn diese roten Spritzer? Da muss Trude den Schläger wohl auf ihrem Maltisch gehabt haben!'"; 
        }else if(heldItem.get().getName().equals("brief")){
            if (n == 0){
                return "'Was ist das denn?'"; 
            }else{
            return "'Ahhhhh.... Ich sehe Sie haben eins und eins zusammen gezählt. Ja das ist eine recht unangenehme Angelegenheit. Sie sehen seit dem Unfall war Fredericke verständlicher Weise nicht mehr Sie selbst.'"
            + "'Naja und da hat sich Ole nach einer anderen Umgeschaut...Bella ist eine Tanzlehrerin an der selben Tanzschule an der auch Fredericke lehrte.'" + 
            "'Seit dem Unfall vor 6 Monaten war Bella bereits mehrere Male hier im Haus. Sie ist Freitag erst kurz bevor Sie gekommen sind abgefahren.'"+
            "'Ich bin, um ehrlich mit Ihnen zu sein, erstaunt dass Fredericke noch nichts von Ole's Affäre mitbekommen hat. Sie ist eigentlich sehr aufmerksam.'"; 
            }
        }else if(heldItem.get().getName().equals("schuhrosa")){
            n = n +1; 
            return "'Das sind die Tanzschuhe von Fredericke oder nicht?? Hahaha. '"; 
        }else{
            return "Lassen Sie mich bitte in Ruhe. Mein Mann ist gerade gestorben! Ist das nicht genug? *Schluchz*";
        }

    }

    @Override
    public String getDescription() {
        
        return "Fredericke ist eine mitte 50-Jahre alte Frau. Ihr Haar beginnt zu grauen, und sie ist querschnitzgelähmt";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

}

package room.zimmer.zimmerana;

import java.util.Optional;

import item.Item;
import room.view.human.Human;

public class Ana extends Human {
    int n = 0;

    @Override
    public String talk(Optional<Item> heldItem) {
        if (n == 0) {
        if (heldItem.isEmpty()) {
            return "'Ich weiss gar nicht was ich denken soll! Der arme Mann ist einfach Tod!'"
                    + "'Das tut mir ja wahnsinnig leid fuer ihn. Und er hatte gerade erst einen |Streit| mit beiden Kindern. Ach gottchen'";
        } else if (heldItem.get().getName().equals("baseballschlaeger")) {
            return "'Ach das ist doch der von Trudes Freund! Tja Ben, der Gute, ist leider sehr vergesslich. Der wuerde seinen eigenen Kopf vergessen waere er nicht angeschraubt!'"
                    + "'Was sind denn diese roten Spritzer? Da muss Trude den Schlaeger wohl auf ihrem Maltisch gehabt haben!'";
        } else if (heldItem.get().getName().equals("brief")) {
            if (n == 0) {
                return "'Was ist das denn?'";
            } else {
                return "'Ahhhhh... Ich sehe Sie haben eins und eins zusammen gezaehlt. Ja das ist eine recht unangenehme Angelegenheit. Sie sehen seit dem Unfall war Fredericke verstaendlicher Weise nicht mehr Sie selbst.'"
                        + "'Naja und da hat sich Ole nach einer anderen Umgeschaut...Bella ist eine Tanzlehrerin an der selben Tanzschule an der auch Fredericke lehrte.'"
                        + "'Seit dem Unfall vor 6 Monaten war Bella bereits mehrere Male hier im Haus. Sie ist Freitag erst kurz bevor Sie gekommen sind abgefahren.'"
                        + "'Ich bin, um ehrlich mit Ihnen zu sein, erstaunt dass Fredericke noch nichts von Ole's Affaere mitbekommen hat. Sie ist eigentlich sehr aufmerksam.'";
            }
        } else if (heldItem.get().getName().equals("rosa Tanzschuhe")) {
            n = n + 1;
            return "'Das sind die Tanzschuhe von Fredericke oder nicht?? Hahaha. '";
        } else if (heldItem.get().getName().equals("morphin")) {
            return "'Morphin ist in hohen Menge toedlich! Aber es wurde Fredericke wegen dem Autounfall verschrieben' ";
        } else {
            return "'Ach, Hallo Dieter, sind Sie schon weiter mit dem Fall?'";
        }
    } else{
        return null; 
    }
    }

    @Override
    public String getDescription() {
        if (n == 0) {
        return "Ana Blurr ist eine etwa 30-jaehrige Frau";
        }else{
            return "Ana Blurr ist eine etwa 30-jaehrige Frau. Gerade liegt sie ohne sich zu bewegen auf dem Boden";
        }
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String ask(String q) {
        if (n == 0) {
        if (q == "Streit") {
            return "'Naja, erst hatte der Alte sich am Freitag mit Trude gestritten, sie ist sehr involviert in die Zukunft der Famillien-Firma. Und eigentlich immer was anderes vor als Ole."
                    + "Dann am gestern stritt er sich mit Sam: Der Sam, muessen Sie Wissen, ist kein Musterjunge. Er wurde schon zweimal verhaftet, gestern sind sie dann nocheinmal aneinader gefahren...  "
                    + "Das war so um 21 Uhr... Oh nein kurz danach habe ich ein |Knall| gehoert. Ich dachte das waere die Kuehlschranktuer, aber was wenn Sam seinen Vater erschlagen hat?'";
        } else if (q == "Fingerhut") {
            return "'Finden Sie nicht auch der Fingerhut ist eine faszinierende Pflanze? Sie ist hochgiftig und trotzdem wunderschoen. Ich hab mich schon als kleines Maedchen dafuer interessiert."
                    + "Ich studiere auch gerade online Arznei. Ich moechte naemlich spaeter eine Apotheke eroeffnen'";
        } else {
            return null;
        }
    }else {
        return null; 
    }
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Anabell Blurr";
    }

}

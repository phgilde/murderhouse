package murderhouse.room.zimmer.zimmerana;

import java.util.Optional;

import murderhouse.item.Item;
import murderhouse.room.view.human.Human;

public class Ana extends Human {
    boolean tanzschuheGesehen = false;

    @Override
    public String talk(Optional<Item> heldItem) {
        if (heldItem.isEmpty()) {
            return "'Ich weiss gar nicht was ich denken soll! Der arme Mann ist einfach Tod!'"
                    + "'Das tut mir ja wahnsinnig leid fuer ihn. Und er hatte gerade erst einen |Streit| mit beiden Kindern. Ach gottchen'";
        } else if (heldItem.get().getName().equals("baseballschlaeger")) {
            return "'Ach das ist doch der von Trudes Freund! Tja Ben, der Gute, ist leider sehr vergesslich. Der wuerde seinen eigenen Kopf vergessen waere er nicht angeschraubt!"
                    + " Was sind denn diese roten Spritzer? Da muss Trude den Schlaeger wohl auf ihrem Maltisch gehabt haben!'";
        } else if (heldItem.get().getName().equals("brief")) {
            if (tanzschuheGesehen) {
                return "'Was ist das denn?'";
            } else {
                return "'Ahhhhh... Ich sehe Sie haben eins und eins zusammen gezaehlt. Ja das ist eine recht unangenehme Angelegenheit. Sie sehen seit dem Unfall war Fredericke verstaendlicher Weise nicht mehr Sie selbst.'"
                        + " Naja und da hat sich Ole nach einer anderen Umgeschaut...Bella ist eine Tanzlehrerin an der selben Tanzschule an der auch Fredericke lehrte."
                        + " Seit dem Unfall vor 6 Monaten war Bella bereits mehrere Male hier im Haus. Sie ist Freitag erst kurz bevor Sie gekommen sind abgefahren."
                        + " Ich bin, um ehrlich mit Ihnen zu sein, erstaunt dass Fredericke noch nichts von Ole's Affaere mitbekommen hat. Sie ist eigentlich sehr aufmerksam.'";
            }
        } else if (heldItem.get().getName().equals("rosa Tanzschuhe")) {
            tanzschuheGesehen = true;
            return "'Das sind die Tanzschuhe von Fredericke oder nicht?? Hahaha. '";
        } else if (heldItem.get().getName().equals("morphin")) {
            return "'Morphin ist in hohen Mengen toedlich! Aber es wurde Fredericke wegen dem Autounfall verschrieben' ";
        } else {
            return "'Ach, Hallo Dieter, sind Sie schon weiter mit dem Fall?'";
        }
    }

    @Override
    public String getDescription() {
        return "Ana Blurr ist eine etwa 30-jaehrige Frau";
    }



    @Override
    public String ask(String q) {
        q.toLowerCase();
        if (q.equals("streit")) {
            return "'Naja, erst hatte der Alte sich am Freitag mit Trude gestritten, sie ist sehr involviert in die Zukunft der Familien-Firma. Und eigentlich immer was anderes vor als Ole."
                    + " Dann am gestern stritt er sich mit Sam: Der Sam, muessen Sie Wissen, ist kein Musterjunge. Er wurde schon zweimal verhaftet, gestern sind sie dann noch einmal aneinander gefahren...  "
                    + " Das war so um 21 Uhr... Oh nein kurz danach habe ich ein |Knall| gehoert. Ich dachte das waere die Kuehlschranktuer, aber was wenn Sam seinen Vater erschlagen hat?'";
        } else if (q.equals("fingerhut")) {
            return "'Finden Sie nicht auch der Fingerhut ist eine faszinierende Pflanze? Sie ist hochgiftig und trotzdem wunderschoen. Ich hab mich schon als kleines Maedchen dafuer interessiert."
                    + " Ich studiere auch gerade online Arznei. Ich moechte naemlich spaeter eine Apotheke eroeffnen'";
        } else if (q.equals("Knall")) {
            return "Ich hab keine Ahnung woher der Knall genau kam. Frag Sam...";
        } else {
            return "Ich weiss leider nicht was du meinst.";
        }
    }

    @Override
    public String getName() {
        return "Ana";
    }

}

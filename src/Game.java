import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.LinkedList;

import control.Parser;
import interaction.Reaction;
import item.Item;
import room.Room;
import room.arbeitszimmer.Arbeitszimmer;
import room.badezimmer.Badezimmer;
import room.flur.Flur;
import room.geheimzimmer.Geheimzimmer;
import room.kueche.Kueche;
import room.view.View;
import room.view.human.Human;
import room.zimmer.schlafzimmer.Fredericke;
import room.zimmer.schlafzimmer.Schlafzimmer;
import room.zimmer.zimmerana.ZimmerAna;
import room.zimmer.zimmersam.ZimmerSam;
import room.zimmer.zimmertrude.ZimmerTrude;
import util.SlowPrint;
import room.wohnzimmer.Wohnzimmer;
import room.saal.Saal;
import room.eingang.Eingang;

class Game {
    Optional<View> currentView = Optional.empty();
    Room currentRoom;
    HashMap<String, Item> inventory = new HashMap<String, Item>();
    Scanner scanner = new Scanner(System.in);
    Parser parser = new Parser();
    Optional<Item> heldItem = Optional.empty();
    HashMap<String, Room> rooms = new HashMap<String, Room>();
    HashMap<String, Integer> preisliste = new HashMap<String, Integer>();
    LinkedList<String> amLeben = new LinkedList<String>();

    private boolean notOver = true;
    private double startTime = System.currentTimeMillis() / 1000.0;

    public Game() {
        currentRoom = new Wohnzimmer();
        rooms.put("wohnzimmer", currentRoom);
        rooms.put("saal", new Saal());
        rooms.put("flur", new Flur());
        rooms.put("eingang", new Eingang());
        rooms.put("arbeitszimmer", new Arbeitszimmer());
        rooms.put("schlafzimmer", new Schlafzimmer());
        rooms.put("geheimzimmer", new Geheimzimmer());
        rooms.put("kueche", new Kueche());
        rooms.put("badezimmer", new Badezimmer());
        rooms.put("trudes zimmer", new ZimmerTrude());
        rooms.put("anas zimmer", new ZimmerAna());
        rooms.put("sams zimmer", new ZimmerSam());
        amLeben.push("Fredericke");
        amLeben.push("Sam");
        amLeben.push("Trude");
        amLeben.push("Ana");
        parser.setSimpleCommand("umsehen", () -> SlowPrint.slowPrint(currentRoom.getDescription()));
        parser.setSimpleCommand("inventar", () -> {
            if (inventory.size() != 0) {
                SlowPrint.slowPrint("Du hast folgende Gegenstaende im Inventar:");
                for (Item item : inventory.values()) {
                    SlowPrint.slowPrint(item.getName());
                }
            } else {
                SlowPrint.slowPrint("Du hast keine Gegenstaende im Inventar.");
            }
        });
        parser.setSimpleCommand("quit", () -> System.exit(0));
        parser.setSimpleCommand("hilfe", () -> {
            SlowPrint.slowPrint("Du kannst folgende Befehle eingeben:");
            SlowPrint.slowPrint("umsehen: Beschreibt den Raum");
            SlowPrint.slowPrint("inventar: Zeigt das Inventar an");
            SlowPrint.slowPrint("gehe <Richtung>: Geht in die angegebene Richtung");
            SlowPrint.slowPrint("quit: Beendet das Spiel");
            SlowPrint.slowPrint("hilfe: Zeigt diese Hilfe an");
            SlowPrint.slowPrint("inspiziere <Ansicht>: Inspiziert die angegebene Ansicht");
            SlowPrint.slowPrint("halte <Gegenstand>: Gegenstand aus dem Inventar halten");
            SlowPrint.slowPrint("ansehen: Beschreibt den gehaltenen Gegenstand");
            SlowPrint.slowPrint("interagiere: Interagiert mit der Ansicht");
            SlowPrint.slowPrint("nimm <Gegenstand>: Nimm den angegebenen Gegenstand");
        });
        parser.setParamCommand("gehe", (String direction) -> {
            if (currentRoom.getAdjacentRooms().contains(direction)) {
                currentRoom = rooms.get(direction);
                currentView = Optional.empty();
                // Erster Buchstabe gross
                String str = currentRoom.getName();
                SlowPrint.slowPrint(
                        "Du bist in " + str.substring(0, 1).toUpperCase() + str.substring(1));
            } else {
                SlowPrint.slowPrint("Du kannst nicht in diese Richtung gehen.");
            }
        });
        parser.setParamCommand("inspiziere", (String view) -> {
            if (currentRoom.getViews().containsKey(view)) {
                currentView = Optional.of(currentRoom.getViews().get(view));
                SlowPrint.slowPrint(currentView.get().getDescription());
            } else {
                SlowPrint.slowPrint("Du kannst das nicht inspizieren.");
            }
        });

        parser.setParamCommand("insp", (String view) -> {
            parser.parse("inspiziere " + view);
        });

        parser.setParamCommand("halte", (String item) -> {
            if (inventory.containsKey(item)) {
                heldItem = Optional.of(inventory.get(item));
                SlowPrint.slowPrint("Du haeltst " + heldItem.get().getName() + ".");
            } else {
                SlowPrint.slowPrint("Du hast das nicht im Inventar.");
            }
        });
        parser.setSimpleCommand("ansehen", () -> {
            if (heldItem.isPresent()) {
                SlowPrint.slowPrint(heldItem.get().getDescription());
            } else {
                SlowPrint.slowPrint("Du haeltst nichts.");
            }
        });
       
        parser.setParamCommand("frage", (String frage) -> {
            HumanDa();

            if (currentView.get() instanceof Human) {
                ((Human) currentView.get()).ask(frage);

            }

        });

        parser.setSimpleCommand("rede",() -> {
            HumanDa();

            if (currentView.get() instanceof Human) {
                ((Human) currentView.get()).talk(heldItem);

            }

        });

        parser.setSimpleCommand("treffe", () -> {
            if (heldItem.get().getName() == "gewehr") {
                if (currentView.isPresent()) {
                    if (currentView.get() instanceof Human) {

                        if (((Human) currentView.get()).getName().equals("svaeltande")) {

                            System.out.println("Was ist falsch mit dir????????");
                            endGame();
                        } else {
                            amLeben.remove(currentView.get().getName());
                            ((Human) currentView.get()).totallyNotDead(1);
                            if (amLeben.isEmpty()) {
                                killGame();
                            }
                        }
                    }
                }
            } else {

            }

        });
        parser.setSimpleCommand("interagiere", () -> {
            if (currentView.isPresent()) {
                currentRoom.interact(currentView.get(), heldItem);
                Reaction reaction = currentView.get().interactReaction(heldItem);
                if (currentView.get().getName().equals("svaeltande") && heldItem.get().getName().equals("steak")) {
                    killGame();
                }
                if (reaction.consumesItem()) {
                    if (heldItem.isPresent()) {
                        inventory.remove(heldItem.get().getName());
                        heldItem = Optional.empty();
                    }
                }
                SlowPrint.slowPrint(reaction.getText());
            } else {
                SlowPrint.slowPrint("Du kannst nicht interagieren.");
            }
        });

        parser.setSimpleCommand("inter", () -> {
            parser.parse("interagiere");
        });

        parser.setParamCommand("nimm", (String item) -> {
            if (currentView.isPresent()) {
                Optional<Item> takenItem = currentView.get().takeItem(item);
                if (takenItem.isPresent()) {
                    inventory.put(takenItem.get().getName().toLowerCase(), takenItem.get());
                    SlowPrint.slowPrint("Du hast " + takenItem.get().getName() + " genommen.");
                } else {
                    SlowPrint.slowPrint("Du kannst das nicht nehmen.");
                }
            } else {
                SlowPrint.slowPrint("Du kannst nichts nehmen.");
            }
        });
        parser.setSimpleCommand("einstecken", () -> {
            if (heldItem.isPresent()) {
                SlowPrint.slowPrint("Du steckst " + heldItem.get().getName() + " wieder ein.");
                heldItem = Optional.empty();
            } else {
                SlowPrint.slowPrint("Du haeltst nichts.");
            }
        });
        parser.setSimpleCommand("trinken", () -> {
            if (heldItem.isPresent() && heldItem.get().getName().equals("Zaubertrank")) {
                notOver = false;
                SlowPrint.slowPrint("Du trinkst den Zaubertrank.");
                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Du wachst auf und bist in einem Wald.");
                SlowPrint.slowPrint(
                        "Um dich stehen die sieben Götter des Olymp. 'WO IST MEIN GELD???' ruft Zeus."
                                + " Du versuchst zu antworten, aber du kannst nicht. Du bist gelähmt.");
                SlowPrint.slowPrint(
                        "Tutanchamun erscheint und sagt: 'Du hast es nicht verdient.' Daraufhin wird "
                                + "er von einem Blitz getroffen und du spürst einen stechenden Schmerz.");
                SlowPrint.slowPrint(
                        "Während die Götter besprechen, was sie mit dir machen sollen, wirst du"
                                + " von einem schwarzen Vogel gefressen.              ");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "'Endlich bist du wach. Jemand hat Ole umgebracht. Wir haben schon die Polizei"
                                + " verständigt.' Ana, die Aushilfe steht vor dir."
                                + " Dein Schädel brummt und du kannst dich an nichts erinnern. 'Sie sind"
                                + " in ungefähr 30 Minuten da. Aber vielleicht kannst du vorher rausfinden,"
                                + " wer Ole das angetan hat. Ich gehe mal lieber auf mein Zimmer, nicht dass"
                                + " mir noch was passiert.'");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "Als du versuchst, aufzustehen. Erscheint eine 3 Meter große, dunkle Gestalt vor dir. "
                                + "'DIETER DER DETEKTIV! DU SCHULDEST ZEUS GELD! DU WIRST ZAHLEN!'"
                                + " Du versuchst zu fliehen, aber es ist zu spät. Die Gestalt holt einen merkwürdigen "
                                + "Gegenstand aus ihrer Tasche und hält ihn dir vor die Nase. Du spürst einen stechenden Schmerz und fällst zu Boden."
                                + " Ein Stimmenchor flüstert aus den Ecken des Zimmers: 'Deine Seele. Deine Seele,"
                                + " sie wird, wird vom Seelenklempner geholt.' Die Stimmen verschwinden, "
                                + "doch du fühlst dich innerlich leer. Es ist, als hätte die Gestalt alle Emotionen "
                                + "und alle Liebe aus deinem Körper gezogen. Die Gestalt steht noch immer vor dir und beobachtet dich aufmerksam.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "Plötzlich verschwindet der Boden unter dir. Du fällst in eine tiefe, schwarze Schlucht."
                                + " Du versuchst, dich zu retten, aber du kannst nicht schwimmen. Du versinkst im Wasser.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Um dich herum ist nichts als Kälte und unendliche Schwärze.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Du hast verloren.");
            }
        });
        parser.setCatch((command) -> SlowPrint.slowPrint(command
                + " ist kein gueltiger Befehl. Gib 'hilfe' ein, um eine Liste der Befehle zu erhalten."));
        SlowPrint.slowPrint("'Endlich bist du wach. Jemand hat Ole umgebracht. Wir haben"
                + " schon die Polizei verständigt.' Ana, die Aushilfe steht vor dir."
                + " Dein Schädel brummt und du kannst dich an kaum etwas erinnern. 'Sie sind"
                + " in ungefähr 30 Minuten da. Aber vielleicht kannst du vorher rausfinden,"
                + " wer Ole das angetan hat. Ich gehe mal lieber auf mein Zimmer, nicht dass "
                + "mir noch was passiert.'");
    }
    private void HumanDa(){
        String view1 = "fredericke";
        String view2 = "ana";
        String view3 = "sam";
        String view4 = "trude";
        if (currentRoom.getViews().containsKey(view1)) {
            currentView = Optional.of(currentRoom.getViews().get(view1));
        } else if (currentRoom.getViews().containsKey(view2)) {
            currentView = Optional.of(currentRoom.getViews().get(view2));
        } else if (currentRoom.getViews().containsKey(view3)) {
            currentView = Optional.of(currentRoom.getViews().get(view3));
        } else if (currentRoom.getViews().containsKey(view4)) {
            currentView = Optional.of(currentRoom.getViews().get(view4));
        }
    }

    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        parser.parse(input);
        if (System.currentTimeMillis() / 1000 - startTime > 30 * 60) {
            endGame();
        }
    }

    private void killGame() {
        if (itemExists("steak")) {
            System.out.println(
                    "Das Haus ist still. Nur der Hund bellt im Garten. Du solltest dich beeilen, vielleicht hat Ana auch schon die Polizei gerufen");
            System.out.println(
                    "Du solltest jemanden finden der sich auf der Insel auskennt. Der Hund bellt draußen weiter");
            System.out.println(
                    "Vielleicht kannst du jemanden dazu bewegen dir den Weg zum Boot zu zeigen. Vielleicht mit etwas zu essen...");
        } else if (!itemExists("steak") && inventory.containsKey("brauner schluessel")) {
            notOver = false;
            System.out.println(" Der Hund kommt angelaufen und zeigt dir den Weg zum Boot und deiner Freiheit.");
            System.out.println(
                    "Du hast das Spiel erfolgreich abgeschlossen. Nachdem du am Ufer angekommen bist, berichtest du deinen Arbeitgeber von deiner Mission");

        } else {
            System.out.println(
                    "Der Hund kommt zur Tuer und will anscheinend nach draußen. Wenn du versuchst die Tür aufzumachen bemerkst du das diese geschlossen ist.");
        }

    }

    private void endGame() {
        notOver = false;
        SlowPrint.slowPrint(
                "Die Polizei ist angekommen. Sie befragen alle und durchsuchen das Haus und die Personen akribisch.");
        if (inventory.containsKey("rosa Tanzschuhe") && inventory.containsKey("bueste")
                && !itemExists("notizbuch") && !itemExists("gewehr")
                && inventory.containsKey("brief")) {
            SlowPrint.slowPrint(
                    "Die Polizei informiert dich, dass sie Friederieke als schuldig befunden haben und sie inhaftiert wurde. Alle Beweise sprechen gegen sie.");
            SlowPrint.slowPrint(
                    "Auf dem Weg nach Hause ruft dich dein Arbeitgeber an und bedankt sich für deine Hilfe.");
            SlowPrint.slowPrint("Du hast das Spiel gewonnen! 🥳🎉");
        } else {
            SlowPrint.slowPrint(
                    "Die Polizei verhaftet dich. Es wurden belastende Beweise gegen dich gefunden.");
            SlowPrint.slowPrint(
                    "Du planst, in der Hoffnung auf Strafminderung gegen den Auftraggeber auszusagen. "
                            + "Auf dem Weg zum Gericht ruft er dich an. Bevor du ans Telefon gehen kannst, wird der Gefangenentransporter gerammt und explodiert.");
            SlowPrint.slowPrint("Du hast das Spiel verloren. 😢");
        }
    }

    private boolean itemExists(String item) {
        for (String key : inventory.keySet()) {
            if (key.equals(item)) {
                return true;
            }
        }
        for (Room room : rooms.values()) {
            for (View view : room.getViews().values()) {
                if (view.takeItem(item).isPresent()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void initPreisliste() {
        preisliste.put("usb-stick", 300);
        preisliste.put("goldkette", 200);
        preisliste.put("bueste", 100);
        preisliste.put("zigarre", 20);
    }

    private void claculateScore() {
        int score = 0;
        for (Map.Entry<String, Item> set : inventory.entrySet()) {
            if (preisliste.containsKey(set.getKey())) {
                SlowPrint.slowPrint(set.getValue().getName() + ": (+ " + preisliste.get(set.getKey()) + ")");
                score += preisliste.get(set.getKey());
            } else {
                SlowPrint.slowPrint(set.getValue().getName() + ": (+ 10)");
                score += 10;
            }
        }
        SlowPrint.slowPrint("Du hast " + score + "Punkte erspielt.");
    }

    public boolean notOver() {
        return notOver;
    }

}

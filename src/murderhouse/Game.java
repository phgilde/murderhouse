package murderhouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.LinkedList;

import murderhouse.control.Parser;
import murderhouse.interaction.Reaction;
import murderhouse.item.Item;
import murderhouse.room.Room;
import murderhouse.room.arbeitszimmer.Arbeitszimmer;
import murderhouse.room.badezimmer.Badezimmer;
import murderhouse.room.draussen.Draussen;
import murderhouse.room.flur.Flur;
import murderhouse.room.geheimzimmer.Geheimzimmer;
import murderhouse.room.kueche.Kueche;
import murderhouse.room.view.View;
import murderhouse.room.view.human.Human;
import murderhouse.room.zimmer.schlafzimmer.Schlafzimmer;
import murderhouse.room.zimmer.zimmerana.ZimmerAna;
import murderhouse.room.zimmer.zimmersam.ZimmerSam;
import murderhouse.room.zimmer.zimmertrude.ZimmerTrude;
import murderhouse.util.SlowPrint;
import murderhouse.room.wohnzimmer.Wohnzimmer;
import murderhouse.room.saal.Saal;
import murderhouse.room.eingang.Eingang;
import murderhouse.room.zimmer.garten.Garten;

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
    private int maxTime = 30 * 60;

    public Game() {
        currentRoom = new Wohnzimmer();
        rooms.put("wohnzimmer", currentRoom);
        rooms.put("garten", new Garten());
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
        rooms.put("draussen", new Draussen());
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
            SlowPrint.slowPrint("--- Zum Bewegen ---");
            SlowPrint.slowPrint("umsehen: Beschreibt den Raum");
            SlowPrint.slowPrint("gehe <Raum>: Geht in den angegebenen Raum");
            SlowPrint.slowPrint("inspiziere <Ansicht>: Inspiziert die angegebene Ansicht");
            SlowPrint.slowPrint("--- Fuer Items ---");
            SlowPrint.slowPrint("inventar: Zeigt das Inventar an");
            SlowPrint.slowPrint("nimm <Gegenstand>: Nimm den angegebenen Gegenstand");
            SlowPrint.slowPrint("ansehen: Beschreibt den gehaltenen Gegenstand");
            SlowPrint.slowPrint("interagiere: Interagiert mit der Ansicht");
            SlowPrint.slowPrint("halte <Gegenstand>: Gegenstand aus dem Inventar halten");
            SlowPrint.slowPrint("einstecken: Legt den gehaltenen Gegenstand ins Inventar");
            SlowPrint.slowPrint("--- Reden und Befragen ---");
            SlowPrint.slowPrint("rede : Redet mit der Person im Raum (gehaltenes Item spielt eine Rolle)");
            SlowPrint.slowPrint("frage <Stichwort>: Befragt die Person nach einem Stichwort");
            SlowPrint.slowPrint("--- Nuetzlich ---");
            SlowPrint.slowPrint("hilfe: Zeigt diese Hilfe an");
            SlowPrint.slowPrint("quit: Beendet das Spiel");
            
        });
        parser.setParamCommand("gehe", (String direction) -> {
            if (currentRoom.getAdjacentRooms().contains(direction)) {
                currentRoom = rooms.get(direction);
                currentView = Optional.empty();
                SlowPrint.slowPrint("Du bist in " + currentRoom.getName());
            } else if(currentRoom.getName().toLowerCase().equals(direction)){
                SlowPrint.slowPrint("Du bist bereits in " + currentRoom.getName());
            } else{
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
            if (getHumanInRoom().isPresent()) {
                if (!amLeben.contains(getHumanInRoom().get().getName())) {
                    SlowPrint.slowPrint("Du kannst " + getHumanInRoom().get().getName() + " nicht mehr befragen.");
                    return;
                }
                currentView = Optional.of(getHumanInRoom().get());
                SlowPrint.slowPrint(((Human) currentView.get()).ask(frage.toLowerCase()));

            } else {
                SlowPrint.slowPrint("Hier gibt es niemanden zum Befragen.");
            }
        });

        parser.setSimpleCommand("rede", () -> {
            if (getHumanInRoom().isPresent()) {
                if (!amLeben.contains(getHumanInRoom().get().getName())) {
                    SlowPrint.slowPrint("Du kannst nicht mehr mit " + getHumanInRoom().get().getName() + " sprechen.");
                    return;
                }
                currentView = Optional.of(getHumanInRoom().get());
                SlowPrint.slowPrint(((Human) currentView.get()).talk(heldItem));
            } else {
                SlowPrint.slowPrint("Hier gibt es niemanden zum Reden.");
            }

        });

        parser.setSimpleCommand("treffe", () -> {
            if (heldItem.isPresent() && heldItem.get().getName().equals("Gewehr")) {
                if (getHumanInRoom().isPresent()) {
                    currentView = Optional.of(getHumanInRoom().get());
                    if (((Human) currentView.get()).getName().equals("svaeltande")) {
                        System.out.println("Was ist falsch mit dir????????");
                        policeEnd();
                    } else {
                        SlowPrint.slowPrint(
                            "Ein ohrenbetaeubender Knall erschuettert das Haus. Der Rueckstoss haut dich aus den Socken. Du hast "
                                    + ((Human) currentView.get()).getName()
                                    + " getroffen.");
                        amLeben.remove(currentView.get().getName());
                        if (amLeben.isEmpty()) {
                            killGame();
                        }
                    }
                } else {
                    SlowPrint.slowPrint(
                            "Mit einem lauten Knall wirst du ein paar Meter zurueckgeschleudert. In der Wand ist ein Loch.");
                }
            } else {
                SlowPrint.slowPrint(
                        "Du bildest mit deiner Hand eine Fingerpistole und schreist laut \"PENG\"");
            }
        });
        parser.setSimpleCommand("interagiere", () -> {
            if (currentView.isPresent()) {
                currentRoom.interact(currentView.get(), heldItem);
                Reaction reaction = currentView.get().interactReaction(heldItem);

                if (currentView.get().getName().equals("Svaeltande")
                        && heldItem.get().getName().equals("Steak")) {
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
                        "Um dich stehen die sieben Goetter des Olymp. 'WO IST MEIN GELD???' ruft Zeus."
                                + " Du versuchst zu antworten, aber du kannst nicht. Du bist gelaehmt.");
                SlowPrint.slowPrint(
                        "Tutanchamun erscheint und sagt: 'Du hast es nicht verdient.' Daraufhin wird "
                                + "er von einem Blitz getroffen und du spuerst einen stechenden Schmerz.");
                SlowPrint.slowPrint(
                        "Waehrend die Goetter besprechen, was sie mit dir machen sollen, wirst du"
                                + " von einem schwarzen Vogel gefressen.              ");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "'Endlich bist du wach. Jemand hat Ole umgebracht. Wir haben schon die Polizei"
                                + " verstaendigt.' Ana, die Aushilfe steht vor dir."
                                + " Dein Schaedel brummt und du kannst dich an nichts erinnern. 'Sie sind"
                                + " in ungefaehr 30 Minuten da. Aber vielleicht kannst du vorher rausfinden,"
                                + " wer Ole das angetan hat. Ich gehe mal lieber auf mein Zimmer, nicht dass"
                                + " mir noch was passiert.'");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "Als du versuchst, aufzustehen. Erscheint eine 3 Meter grosse, dunkle Gestalt vor dir. "
                                + "'DIETER DER DETEKTIV! DU SCHULDEST ZEUS GELD! DU WIRST ZAHLEN!'"
                                + " Du versuchst zu fliehen, aber es ist zu spaet. Die Gestalt holt einen merkwuerdigen "
                                + "Gegenstand aus ihrer Tasche und haelt ihn dir vor die Nase. Du spuerst einen stechenden Schmerz und faellst zu Boden."
                                + " Ein Stimmenchor fluestert aus den Ecken des Zimmers: 'Deine Seele. Deine Seele,"
                                + " sie wird, wird vom Seelenklempner geholt.' Die Stimmen verschwinden, "
                                + "doch du fuehlst dich innerlich leer. Es ist, als haette die Gestalt alle Emotionen "
                                + "und alle Liebe aus deinem Koerper gezogen. Die Gestalt steht noch immer vor dir und beobachtet dich aufmerksam.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint(
                        "Ploetzlich verschwindet der Boden unter dir. Du faellst in eine tiefe, schwarze Schlucht."
                                + " Du versuchst, dich zu retten, aber du kannst nicht schwimmen. Du versinkst im Wasser.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Um dich herum ist nichts als Kaelte und unendliche Schwaerze.");

                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Du hast verloren.");
            }
        });
        parser.setSimpleCommand("schlafe", () -> {
            if (currentRoom.getViews().containsKey("bett")) {
                SlowPrint.slowPrint(
                        "Du merkst, wie du sehr muede wirst. Du legst dich ins Bett und schlaefst ein.");
                SlowPrint.slowPrint(
                        "...                             ...                             ...                      ");
                SlowPrint.slowPrint("Ein Klingeln an der Tuer weckt dich.");
                policeEnd();
            } else {
                SlowPrint.slowPrint("Du kannst nicht schlafen.");
            }
        });
        parser.setCatch((command) -> SlowPrint.slowPrint(command
                + " ist kein gueltiger Befehl. Gib 'hilfe' ein, um eine Liste der Befehle zu erhalten."));
        SlowPrint.slowPrint("'Endlich bist du wach. Jemand hat Ole umgebracht. Wir haben"
                + " schon die Polizei verstaendigt.' Ana, die Aushilfe steht vor dir."
                + " Dein Schaedel brummt und du kannst dich an kaum etwas erinnern. 'Sie sind"
                + " in ungefaehr 30 Minuten da. Aber vielleicht kannst du vorher rausfinden,"
                + " wer Ole das angetan hat. Ich gehe mal lieber auf mein Zimmer, nicht dass "
                + "mir noch was passiert.'");
        
        initPreisliste();
    }

    private Optional<Human> getHumanInRoom() {
        for (View view : currentRoom.getViews().values()) {
            if (view instanceof Human) {
                return Optional.of((Human) view);
            }
        }
        return Optional.empty();
    }

    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        parser.parse(input);
        if (System.currentTimeMillis() / 1000 - startTime > maxTime) {
            policeEnd();
        }
    }

    private void killGame() {
        if (itemExists("steak")) {
            SlowPrint.slowPrint(
                    "Das Haus ist still. Nur der Hund bellt im Garten. Du solltest dich beeilen, vielleicht hat Ana auch schon die Polizei gerufen");
            SlowPrint.slowPrint(
                    "Du solltest jemanden finden der sich auf der Insel auskennt. Der Hund bellt draussen weiter");
            SlowPrint.slowPrint(
                    "Vielleicht kannst du jemanden dazu bewegen dir den Weg zum Boot zu zeigen. Vielleicht mit etwas zu essen...");
        } else if (!itemExists("steak") && inventory.containsKey("brauner schluessel")) {
            notOver = false;
            SlowPrint.slowPrint(
                    " Der Hund kommt angelaufen und zeigt dir den Weg zum Boot und deiner Freiheit.");
            SlowPrint.slowPrint(
                    "Du hast das Spiel erfolgreich abgeschlossen. Nachdem du am Ufer angekommen bist, berichtest du deinen Arbeitgeber von deiner Mission");

        } else {
            SlowPrint.slowPrint(
                    "Der Hund kommt zur Tuer und will anscheinend nach draussen. Wenn du versuchst die Tuer aufzumachen bemerkst du das diese geschlossen ist.");
        }

    }

    private void policeEnd() {
        notOver = false;
        SlowPrint.slowPrint(
                "Die Polizei ist angekommen. Sie befragen alle und durchsuchen das Haus und die Personen akribisch.");
        if (inventory.containsKey("tanzschuhe") && inventory.containsKey("bueste")
                && !itemExists("notizbuch") && !itemExists("gewehr")
                && inventory.containsKey("brief")) {
            SlowPrint.slowPrint(
                    "Die Polizei informiert dich, dass sie Friederieke als schuldig befunden haben und sie inhaftiert wurde. Alle Beweise sprechen gegen sie.");
            SlowPrint.slowPrint(
                    "Auf dem Weg nach Hause ruft dich dein Arbeitgeber an und bedankt sich fuer deine Hilfe.");
            SlowPrint.slowPrint("Du hast das Spiel gewonnen! 🥳🎉");
            calculateScore();
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
                if (view.hasItem(item)) {
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
        preisliste.put("tanzschuhe", 50);
        preisliste.put("oelgemaelde", 743000);
    }

    private void calculateScore() {
        int score = 0;
        for (Map.Entry<String, Item> set : inventory.entrySet()) {
            if (preisliste.containsKey(set.getKey())) {
                SlowPrint.slowPrint(
                        set.getValue().getName() + ": (+ " + preisliste.get(set.getKey()) + ")");
                score += preisliste.get(set.getKey());
            } else {
                SlowPrint.slowPrint(set.getValue().getName() + ": (+ 10)");
                score += 10;
            }
        }
        SlowPrint.slowPrint("Bezahlung vom Auftraggeber: (+ 20000)");
        score += 20000;
        SlowPrint.slowPrint("Du hast Gegenstaende im Wert von " + score + " Euro eingesackt.");
    }

    public boolean notOver() {
        return notOver;
    }

}

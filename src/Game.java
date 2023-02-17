import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import control.Parser;
import interaction.Reaction;
import item.Item;
import room.Room;
import room.arbeitszimmer.Arbeitszimmer;
import room.badezimmer.Badezimmer;
import room.saal.Saal;
import room.flur.Flur;
import room.geheimzimmer.Geheimzimmer;
import room.kueche.Kueche;
import room.view.View;
import room.view.human.Human;
import room.zimmer.zimmerana.ZimmerAna;
import room.zimmer.zimmerole.ZimmerOle;
import room.zimmer.zimmersam.ZimmerSam;
import room.zimmer.zimmertrude.ZimmerTrude;
import util.SlowPrint;

class Game {
    Optional<View> currentView = Optional.empty();
    Room currentRoom;
    HashMap<String, Item> inventory = new HashMap<String, Item>();
    Scanner scanner = new Scanner(System.in);
    Parser parser = new Parser();
    Optional<Item> heldItem = Optional.empty();
    HashMap<String, Room> rooms = new HashMap<String, Room>();

    private boolean notOver = true;
    private double startTime = System.currentTimeMillis() / 1000.0;

    public Game() {
        currentRoom = new Wohnzimmer();
        rooms.put("wohnzimmer", currentRoom);
        rooms.put("saal", new Saal());
        rooms.put("flur", new Flur());
        rooms.put("eingang", new Eingang());
        rooms.put("arbeitszimmer", new Arbeitszimmer());
        rooms.put("oles zimmer", new ZimmerOle());
        rooms.put("geheimzimmer", new Geheimzimmer());
        rooms.put("kueche", new Kueche());
        rooms.put("badezimmer", new Badezimmer());
        rooms.put("trudes zimmer", new ZimmerTrude());
        rooms.put("anas zimmer", new ZimmerAna());
        rooms.put("sams zimmer", new ZimmerSam());
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
            if (currentView.isPresent()) {
                if (currentView.get() instanceof Human) {
                    ((Human) currentView.get()).ask(frage);

                }
            }


        });

        parser.setSimpleCommand("interagiere", () -> {
            if (currentView.isPresent()) {
                currentRoom.interact(currentView.get(), heldItem);
                Reaction reaction = currentView.get().interactReaction(heldItem);
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
        parser.setCatch((command) -> SlowPrint.slowPrint(command
                + " ist kein gueltiger Befehl. Gib 'hilfe' ein, um eine Liste der Befehle zu erhalten."));
    }

    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        parser.parse(input);
        if (System.currentTimeMillis() / 1000 - startTime > 30 * 60) {
            endGame();
        }
    }

    private void endGame() {
        notOver = false;
        SlowPrint.slowPrint(
                "Die Polizei ist angekommen. Sie befragen alle und durchsuchen das Haus und die Personen akribisch.");
        // TODO prüfen ob notizbuch in raum liegt
        if (inventory.containsKey("schuhrosa") && inventory.containsKey("bueste")
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
                    "Du planst, in der Hoffnung auf Strafminderung gegen den Auftraggeber auszusagen. Auf dem Weg zum Gericht ruft er dich an. Bevor du ans Telefon gehen kannst, wird der Gefangenentransporter gerammt und explodiert.");
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

    public boolean notOver() {
        return notOver;
    }

}

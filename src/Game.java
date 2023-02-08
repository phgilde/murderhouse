import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import control.Parser;
import interaction.Reaction;
import item.Item;
import room.Room;
import room.arbeitszimmer.Arbeitszimmer;
import room.flur.Flur;
import room.geheimzimmer.Geheimzimmer;
import room.kueche.Kueche;
import room.view.View;
import room.zimmer.zimmerole.ZimmerOle;
import util.SlowPrint;

class Game {
    Optional<View> currentView = Optional.empty();
    Room currentRoom;
    HashMap<String, Item> inventory = new HashMap<String, Item>();
    Scanner scanner = new Scanner(System.in);
    Parser parser = new Parser();
    Optional<Item> heldItem = Optional.empty();
    HashMap<String, Room> rooms = new HashMap<String, Room>();

    public Game() {
        currentRoom = new Wohnzimmer();
        rooms.put("wohnzimmer", currentRoom);
        rooms.put("saal", new Saal());
        rooms.put("flur", new Flur());
        rooms.put("arbeitszimmer", new Arbeitszimmer());
        rooms.put("oles zimmer", new ZimmerOle());
        rooms.put("geheimzimmer", new Geheimzimmer());
        rooms.put("küche", new Kueche());
        parser.setSimpleCommand("umsehen", () -> SlowPrint.slowPrint(currentRoom.getDescription()));
        parser.setSimpleCommand("inventar", () -> {
            if (inventory.size() != 0) {
                SlowPrint.slowPrint("Du hast folgende Gegenstände im Inventar:");
                for (String item : inventory.keySet()) {
                    SlowPrint.slowPrint(item);
                }
            } else {
                SlowPrint.slowPrint("Du hast keine Gegenstände im Inventar.");
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
                // Erster Buchstabe groß
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
                SlowPrint.slowPrint("Du hältst " + heldItem.get().getName() + ".");
            } else {
                SlowPrint.slowPrint("Du hast das nicht im Inventar.");
            }
        });
        parser.setSimpleCommand("ansehen", () -> {
            if (heldItem.isPresent()) {
                SlowPrint.slowPrint(heldItem.get().getDescription());
            } else {
                SlowPrint.slowPrint("Du hältst nichts.");
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
                    inventory.put(takenItem.get().getName(), takenItem.get());
                    SlowPrint.slowPrint("Du hast " + takenItem.get().getName() + " genommen.");
                } else {
                    SlowPrint.slowPrint("Du kannst das nicht nehmen.");
                }
            } else {
                SlowPrint.slowPrint("Du kannst nichts nehmen.");
            }
        });
        parser.setCatch((command) -> SlowPrint.slowPrint(command
                + " ist kein gültiger Befehl. Gib 'hilfe' ein, um eine Liste der Befehle zu erhalten."));
    }

    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        parser.parse(input);
    }

}

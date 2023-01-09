import java.util.LinkedList;
import java.util.Scanner;

import control.Parser;
import item.Item;
import room.Room;
import room.Schlafzimmer;
import view.View;

class Game {
    View currentView;
    Room currentRoom;
    LinkedList<Item> inventory;
    Scanner scanner = new Scanner(System.in);
    Parser parser = new Parser();
    public Game() {
        currentRoom = new Schlafzimmer();
        inventory = new LinkedList<Item>();
        parser.setSimpleCommand("umsehen", () -> System.out.println(currentRoom.getDescription()));
        parser.setSimpleCommand("inventar", () -> {
            if (inventory.size()!=0) {
                System.out.println("Du hast folgende Gegenstände im Inventar:");
                for (Item item : inventory) {
                    System.out.println(item.getName());
                }
            } else {
                System.out.println("Du hast keine Gegenstände im Inventar.");
            }
        });
        parser.setSimpleCommand("quit", () -> System.exit(0));
        parser.setSimpleCommand("hilfe", () -> {
            System.out.println("Du kannst folgende Befehle eingeben:");
            System.out.println("umsehen: Beschreibt den Raum");
            System.out.println("inventar: Zeigt das Inventar an");
            System.out.println("gehe <Richtung>: Geht in die angegebene Richtung");
            System.out.println("quit: Beendet das Spiel");
            System.out.println("hilfe: Zeigt diese Hilfe an");
        });
        parser.setParamCommand("gehe", (String direction) -> {
            if (currentRoom.getAdjacentRooms().containsKey(direction)) {
                currentRoom = currentRoom.getAdjacentRooms().get(direction);
                System.out.println(currentRoom.getDescription());
            } else {
                System.out.println("Du kannst nicht in diese Richtung gehen.");
            }
        });
    }
    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        parser.parse(input);
    }

}
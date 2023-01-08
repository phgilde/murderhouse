import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

import item.Item;
import room.Room;
import room.Schlafzimmer;
import view.View;

class Game {
    View currentView;
    Room currentRoom;
    LinkedList<Item> inventory;
    Scanner scanner = new Scanner(System.in);
    public Game() {
        currentRoom = new Schlafzimmer();
        inventory = new LinkedList<Item>();
    }
    public void mainLoop() {
        System.out.print(">>> ");
        String input = scanner.nextLine();
        if (input.equals("umsehen")) {
            System.out.println(currentRoom.getDescription());
        } else if (input.equals("inventar")) {
            if (inventory.size()!=0) {
                System.out.println("Du hast folgende Gegenstände im Inventar:");
                for (Item item : inventory) {
                    System.out.println(item.getName());
                }
            } else {
                System.out.println("Du hast keine Gegenstände im Inventar.");
            }
            
        } else if (input.equals("quit")) {
            System.exit(0);
        } else if (input.equals("hilfe")) {
            System.out.println("Du kannst folgende Befehle eingeben:");
            System.out.println("umsehen: Beschreibt den Raum");
            System.out.println("inventar: Zeigt das Inventar an");
            System.out.println("quit: Beendet das Spiel");
            System.out.println("hilfe: Zeigt diese Hilfe an");
        } else {
            System.out.println("Unbekannter Befehl. Gib 'hilfe' ein, um eine Liste der Befehle zu erhalten.");
        }
    }

}
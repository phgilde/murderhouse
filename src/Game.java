import java.util.LinkedList;

import item.Item;
import room.Room;
import view.View;

class Game {
    static View currentView;
    static Room currentRoom;
    static LinkedList<Item> inventory;
    
    public static void main(String[] args) {
        System.out.println("Willkommen bei Murder House!");
    }
    
}
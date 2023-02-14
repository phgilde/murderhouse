package room.flur;

import java.util.Map;
import java.util.Optional;

import item.Item;
import room.Room;
import room.view.View;

public class Flur extends Room {

    public Flur() {
        adjacentRooms.add("oles zimmer");
        adjacentRooms.add("saal");
        adjacentRooms.add("badezimmer");
    }

    @Override
    public String getName() {
        return "flur";
    }

    @Override
    public String getDescription() {
        return "Du bist im *Flur* angekommen. Voellig ausser Atem ueberlegst du in welchen der verschiedenen Raeume du gehen willst"
                + "Du siehst *Oles Zimmer*, welches von weitem nach sehr guenstigem Parfuem und eckelhaften Socken mueffelt."
                + "Die Tuer des *Badezimmer*s ist geschlossen. ueber die Treppe kommst du zurueck in den *Saal* \n"
                + "*Hinweis: Wenn du ein Zimmer betreten willst, dann kannst du den Namen und das Zimmer nach dem gehe-Command schreiben. Beispiel: gehe Oles Zimmer*";
    }


    @Override
    public Map<String, View> getViews() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void interact(View view, Optional<Item> heldItem) {
        // TODO Auto-generated method stub

    }

}



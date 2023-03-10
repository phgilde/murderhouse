package murderhouse.room.flur;

import murderhouse.room.Room;

public class Flur extends Room {

    public Flur() {
        adjacentRooms.add("schlafzimmer");
        adjacentRooms.add("saal");
        adjacentRooms.add("badezimmer");
        adjacentRooms.add("trudes zimmer");
        adjacentRooms.add("anas zimmer");
        adjacentRooms.add("sams zimmer");
    }

    @Override
    public String getName() {
        return "Flur";
    }

    @Override
    public String getDescription() {
        return "Du bist im *Flur* angekommen. Voellig ausser Atem ueberlegst du in welchen der verschiedenen Raeume du gehen willst. "
                + "Du siehst das *Schlafzimmer*, welches von weitem nach sehr guenstigem Parfuem und eckelhaften Socken mueffelt."
                + "Die Tuer des *Badezimmer*s ist geschlossen. ueber die Treppe kommst du zurueck in den *Saal*. Von hier kannst "
                + "du auch in *Anas Zimmer* sowie *Trudes Zimmer*. Gegenueber liegt *Sams Zimmer*. "
                + "*Hinweis: Wenn du ein Zimmer betreten willst, dann kannst du den Namen und das Zimmer nach dem gehe-Command schreiben. Beispiel: gehe Oles Zimmer*";
    }
}



package murderhouse.room.zimmer.garten;




import murderhouse.room.Room;


public class Garten extends Room{
    
    public Garten(){
    adjacentRooms.add("draussen");
    adjacentRooms.add("wohnzimmer");
    views.put("svaeltande", new Svaeltande());
    }
    @Override
    public String getName() {
        return "Garten";
    }

    @Override
    public String getDescription() {
        
        return "Du bist in einem kleinen Garten von einer Mauer vom Rest der Insel getrennt ist. Im Mitten der Rosenbuesche liegt ein Struppiger Hund."
        + " Es ist der Familien Hund *Svaeltande*. Von hier aus kannst du in nach *Draussen* und ins *Wohnzimmer* gehen.";
    }
}

package room.zimmer.garten;




import room.Room;


public class Garten extends Room{
    
    public Garten(){
    adjacentRooms.add("wohnzimmer");
    adjacentRooms.add("arbeitszimmer"); 
    }
    @Override
    public String getName() {
        return "garten";
    }

    @Override
    public String getDescription() {
        
        return "Du bist in einem kleinen Garten von einer Mauer vom Rest der Insel getrennt ist. Im Mitten der Rosenbüsche liegt ein Struppiger Hund. Es ist der Familien Hund *Svaeltande*.";
    }
}

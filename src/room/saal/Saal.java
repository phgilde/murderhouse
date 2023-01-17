public class Saal extends Room{
    private HashMap<String, View> views = new HashMap<String, View>();
    private LinkedList<String> adjacentRooms = new LinkedList<String>();

    public Saal(){
        adjacentRooms.add("Eingang");
        adjacentRooms.add("Wohnzimmer");
        adjacentRooms.add("Schlafzimmer");
        adjacentRooms.add("Wohnzimmer");

        
    }

    @Override
    public String getName(){
        return "Saal";    
    }

    @Override
    public String getDescription(){
        return "Du stehst in der Mitte des Saals. "
    }

    @Override
    public String List<String> getAdjacentRooms(){
        

    }
}
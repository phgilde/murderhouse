package item;

public class Schuhe extends Item {
   
private String farbe; 
   public Schuhe (String f){
    farbe = f; 
   }


    @Override
    public String getName() {
        
        return farbe;
    }

    @Override
    public String getDescription() {
        
        return null;
    }
    
}

package item;

public class Schluessel extends Item {
private String farbe; 
   public Schluessel (String f){
    farbe = f; 
   }

    @Override
    public String getName() {
      return farbe ;
    }

    @Override
    public String getDescription() {
        
        return farbe;
    }
    
}

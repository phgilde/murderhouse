package view;


public abstract class View {

    /**
     * Gibt eine Beschreibung der Ansicht zurück.
     * 
     * @return Beschreibung
     */
    public abstract String getDescription();

    /**
     * Führt eine Interaktion mit der Ansicht durch.
     * 
     * @param action Die Interaktion.
     * @return Beschreibung der Reaktion auf die Interaktion.
     */
    public abstract String interact(String action);

}

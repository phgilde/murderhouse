package room.view;

import java.util.Optional;
import interaction.Action;
import interaction.Reaction;

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
     * @return Reaktion auf die Interaktion.
     */
    public abstract Optional<Reaction> interact(Action action);

}

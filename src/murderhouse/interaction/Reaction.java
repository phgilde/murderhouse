package murderhouse.interaction;

/**
 * Eine Reaktion auf eine Interaktion mit einem View.
 */
public class Reaction {
    private String text;
    private boolean consumesItem;

    /**
     * Erstellt eine neue Reaktion.
     * @param text Beschreibung der Reaktion.
     * @param consumesItem Ob das Item, das der Spieler in der Hand haelt, verbraucht wird.
     */
    public Reaction(String text, boolean consumesItem) {
        this.text = text;
        this.consumesItem = consumesItem;
    }

    public Reaction(String text) {
        this(text, false);
    }

    public String getText() {
        return text;
    }

    public boolean consumesItem() {
        return consumesItem;
    }

}

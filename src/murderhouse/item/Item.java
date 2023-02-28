package item;

public abstract class Item {
    public abstract String getName();

    public abstract String getDescription();

    /**
     * @return Wert des Items in Cent.
     */
    public abstract int getValue();
}

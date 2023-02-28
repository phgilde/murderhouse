package item;

public class SimpleItem extends Item {
    private String name;
    private String description;
    private int value = 0;

    public SimpleItem(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public SimpleItem(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getValue() {
        return value;
    }
}

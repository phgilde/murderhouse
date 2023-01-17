package item;

public class SimpleItem extends Item {
    private String name;
    private String description;

    public SimpleItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

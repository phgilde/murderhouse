package room.kueche;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import item.Item;
import item.SimpleItem;
import room.view.View;

public class Herdplatte extends View {

    public Herdplatte() {
        medicine.add("aspirin");
        medicine.add("morphin");
        medicineRequired.add("aspirin");
    }

    private boolean isOn = false;
    private Set<String> medicine = new HashSet<String>();
    private Set<String> medicineRequired = new HashSet<String>();
    private Set<String> medicineFound = new HashSet<>();
    private boolean cookingDone = false;

    @Override
    public String getDescription() {
        if (isOn) {
            return "Ein alter Gasherd mit einem großen Kochtopf darauf. Der Herd ist eingeschaltet.";
        }
        return "Ein alter Gasherd mit einem großen Kochtopf darauf. Der Herd ist ausgeschaltet.";
    }

    @Override
    public String interact(Optional<Item> heldItem) {
        if (heldItem.isEmpty()) {
            if (isOn) {
                if (medicineRequired.equals(medicineFound) && !cookingDone) {
                    items.put("Zaubertrank", new SimpleItem("Zaubertrank",
                            "Eine dunkle, zähe Flüssigkeit mit einem unangenehmen Geruch. Sie scheint zu glitzern."));
                    cookingDone = true;
                    return "Du schaltest den Herd aus. Der Kochtopf ist heiß."
                            + " Du nimmst den Kochtopf vom Herd und öffnest ihn. Darin befindet sich ein Zaubertrank.";
                }
                isOn = false;
                return "Du schaltest den Herd aus.";
            } else {
                isOn = true;
                return "Du schaltest den Herd an.";
            }
        } else {
            if (medicine.contains(heldItem.get().getName())) {
                medicineFound.add(heldItem.get().getName());
                return "Du wirfst das " + heldItem.get().getName() + " in den Kochtopf.";
            }
        }
        return "Du kannst das nicht mit dem Herd machen.";
    }
}

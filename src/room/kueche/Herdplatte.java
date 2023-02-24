package room.kueche;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import interaction.Reaction;
import item.Item;
import item.SimpleItem;
import room.view.View;

public class Herdplatte extends View {

    public Herdplatte() {
        medicine.add("ibuprofen");
        medicine.add("morphin");
        medicineRequired.add("ibuprofen");
    }

    private boolean isOn = false;
    private Set<String> medicine = new HashSet<String>();
    private Set<String> medicineRequired = new HashSet<String>();
    private Set<String> medicineFound = new HashSet<>();
    private boolean cookingDone = false;

    @Override
    public String getDescription() {
        if (isOn) {
            return "Ein alter Gasherd mit einem grossen Kochtopf darauf. Der Herd ist eingeschaltet.";
        }
        return "Ein alter Gasherd mit einem grossen Kochtopf darauf. Der Herd ist ausgeschaltet.";
    }

    @Override
    public Reaction interactReaction(Optional<Item> heldItem) {
        if (heldItem.isEmpty()) {
            if (isOn) {
                if ((medicineFound.containsAll(medicineRequired)) && !cookingDone) {
                    items.put("zaubertrank", new SimpleItem("Zaubertrank",
                            "Eine dunkle, zaehe Fluessigkeit mit einem unangenehmen Geruch. Sie scheint zu glitzern."));
                    cookingDone = true;
                    return new Reaction("Du schaltest den Herd aus. Der Kochtopf ist heiss."
                            + " Du nimmst den Kochtopf vom Herd und oeffnest ihn. Darin befindet sich ein Zaubertrank.");
                }
                isOn = false;
                return new Reaction("Du schaltest den Herd aus.");
            } else {
                isOn = true;
                return new Reaction("Du schaltest den Herd an.");
            }
        } else {
            if (medicine.contains(heldItem.get().getName())) {
                medicineFound.add(heldItem.get().getName());
                return new Reaction("Du wirfst das " + heldItem.get().getName() + " in den Kochtopf.", true);
            }
        }
        return new Reaction("Du kannst das nicht mit dem Herd machen.");
    }

    @Override
    public String getName() {
        return "herdplatte";
    }
}

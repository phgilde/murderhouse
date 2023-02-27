import item.SimpleItem;
import room.view.View;

public class Bilderrahmen extends View {

    public Bilderrahmen() {
        items.put("oelgemaelde", new SimpleItem("Oelgemaelde",
                "Eine weiß bemalte Leinwand. Auf der Leinwand ist ein Schneesturm zu sehen. "
                        + "Es handelt sich um das Gemaelde 'Der Schneesturm' von Arnfast Anderberg."));
    }

    @Override
    public String getName() {
        return "oelgemaelde";
    }

    @Override
    public String getDescription() {
        if (items.containsKey("oelgemaelde"))
            return "Ein Oelgemaelde. Du kannst zunächst nicht erkennen, was es zeigt. Auf einer bronzenen Plakette unter dem Rahmen steht: 'Der Schneesturm'."
                    + " Nachdem du das Gemaelde erneut ansiehst, erkennst du wirklich einen Schneesturm, denn das gesamte Bild ist in Weiß gehalten.";
        else
            return "Ein Bilderrahmen. Darin scheint ein Gemaelde einer Sperrholzplatte zu haengen. Auf einer bronzenen Plakette unter dem Rahmen steht: 'Der Schneesturm'.";
    }

}

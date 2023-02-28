package murderhouse.control;

import java.util.HashMap;
import java.util.function.Consumer;

public class Parser {
    private HashMap<String, Runnable> simpleCommands;
    private HashMap<String, Consumer<String>> paramCommands;
    private Consumer<String> catcher;

    public Parser() {
        simpleCommands = new HashMap<>();
        paramCommands = new HashMap<>();
    }

    public void setSimpleCommand(String command, Runnable action) {
        simpleCommands.put(command, action);
    }

    public void setParamCommand(String command, Consumer<String> action) {
        paramCommands.put(command, action);
    }

    public void setCatch(Consumer<String> action) {
        catcher = action;
    }

    public void parse(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        String argument = "";
        for (int i = 1; i < parts.length; i++) {
            argument += parts[i] + " ";
        }
        argument = argument.trim().toLowerCase();

        if (simpleCommands.containsKey(command)) {
            simpleCommands.get(command).run();
        } else if (paramCommands.containsKey(command)) {
            paramCommands.get(command).accept(argument);
        } else if (catcher != null) {
            catcher.accept(input);
        } else {
            System.out.println("Unbekannter Befehl.");
        }
    }
}

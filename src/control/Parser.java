package control;

import java.util.HashMap;
import java.util.function.Consumer;

public class Parser {
    private HashMap<String, Runnable> simpleCommands;
    private HashMap<String, Consumer<String>> paramCommands;

    public Parser() {
        simpleCommands = new HashMap<>();
        paramCommands = new HashMap<>();
    }

    public void addSimple(String command, Runnable action) {
        simpleCommands.put(command, action);
    }

    public void addParamCommand(String command, Consumer<String> action) {
        paramCommands.put(command, action);
    }

    public void parse(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : null;

        if (argument == null) {
            simpleCommands.get(command).run();
        } else {
            paramCommands.get(command).accept(argument);
        }
    }
}

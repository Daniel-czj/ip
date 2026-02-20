package jeff.parser;

import jeff.command.*;
import jeff.exception.JeffException;

public class Parser {

    public static Command parseCommand(String userInput) throws JeffException {
        if (userInput == null) {
            throw new JeffException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        String trimmed = userInput.trim();
        if (trimmed.isEmpty()) {
            throw new JeffException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        String[] inputArray = trimmed.split("\\s+", 2);
        String commandWord = inputArray[0];
        String arguments = inputArray.length > 1 ? inputArray[1] : "";

        return switch (commandWord) {
        case "bye" -> new ByeCommand();
        case "list" -> new ListCommand();
        case "mark" -> new MarkCommand(arguments, true);
        case "unmark" -> new MarkCommand(arguments, false);
        case "todo" -> new TodoCommand(arguments);
        case "deadline" -> new DeadlineCommand(arguments);
        case "event" -> new EventCommand(arguments);
        default -> throw new JeffException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        };
    }
}
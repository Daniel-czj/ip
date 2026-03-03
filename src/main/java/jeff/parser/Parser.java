package jeff.parser;

import jeff.command.*;
import jeff.exception.JeffException;

/**
 * Parses user input and returns the corresponding {@link Command} object.
 */
public class Parser {

    /**
     * Parses the given user input string and returns the matching command.
     *
     * @param userInput The raw input string from the user.
     * @return The {@link Command} corresponding to the user input.
     * @throws JeffException If the input is null, empty, or an unrecognised command.
     */
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
        case "delete" -> new DeleteCommand(arguments);
        case "find" -> new FindCommand(arguments);
        default -> throw new JeffException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        };
    }
}
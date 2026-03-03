package jeff.storage;

import jeff.exception.JeffException;
import jeff.task.*;
import jeff.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to and from a file.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a Storage instance pointing to the specified file.
     *
     * @param folder   The folder containing the data file.
     * @param fileName The name of the data file.
     */
    public Storage(String folder, String fileName) {
        this.filePath = folder + File.separator + fileName; 
    }

    /**
     * Loads tasks from the data file.
     * Creates the file and its parent directories if they do not exist.
     *
     * @return An {@code ArrayList} of tasks loaded from the file.
     * @throws JeffException If the file cannot be read.
     */
    public ArrayList<Task> loadTasks() throws JeffException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    System.out.println("Warning: Failed to create directory " + parentDir.getAbsolutePath());
                }
            }

            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Warning: Failed to create file " + file.getAbsolutePath());
                }
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                Task t = parseLine(line);
                if (t != null) {
                    tasks.add(t);
                }
              
            }
            sc.close();

        } catch (IOException e) {
            throw new JeffException("Error loading file: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Saves all tasks in the given TaskList to the data file.
     *
     * @param tasks The TaskList whose tasks should be saved.
     * @throws IOException If the file cannot be written.
     */
    public void saveTasks(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        for (Task task : tasks.getAll()) {
            fw.write(serialize(task));
            fw.write(System.lineSeparator());
        }

        fw.close();
    }

    

    private String serialize(Task task) {
        String done = task.getStatus() ? "1" : "0";

        if (task instanceof Todo) {
            return "T | " + done + " | " + task.getTask();
        } else if (task instanceof Deadline d) {
            return "D | " + done + " | " + d.getTask() + " | " + d.getBy();
        } else if (task instanceof Event e) {
            return "E | " + done + " | " + e.getTask() + " | " + e.getFrom() + " | " + e.getTo();
        } else {
            return "T | " + done + " | " + task.getTask();
        }
    }


    private Task parseLine(String line) {
        
        String[] parts = line.split("\\|");
        if (parts.length < 3) return null;

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String type = parts[0];
        String doneStr = parts[1];
        String desc = parts[2];

        boolean isDone;
        if ("1".equals(doneStr)) isDone = true;
        else if ("0".equals(doneStr)) isDone = false;
        else return null;

        try {
            Task task;
            switch (type) {
                case "T" -> task = new Todo(desc);
                case "D" -> {
                    if (parts.length < 4) return null;
                    task = new Deadline(desc, parts[3]);
                }
                case "E" -> {
                    if (parts.length < 5) return null;
                    task = new Event(desc, parts[3], parts[4]);
                }
                default -> {
                    return null; 
                }
            }

            task.setStatus(isDone);
            return task;

        } catch (Exception e) {
            return null;
        }
    }
}
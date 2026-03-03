# Jeff User Guide

```
 (_)     / _|/ _|  
  _  ___| |_| |_  
 | |/ _ \  _|  _| 
 | |  __/ | | |  
 | |\___|_| |_|   
_/ |             
|__/         
```

Jeff is a simple, interactive task manager chatbot that helps you keep track of tasks such as Todos, Deadlines, and Events. Add tasks, mark them as done, search, and save them for the next session

---

## Quick Start

1. Ensure you have Java `17` or above installed.
2. Download the latest release of Jeff.
3. Copy the JAR file to the folder you want to use as the home folder.
4. Open a terminal, `cd` into that folder, and run:
   ```
   java -jar jeff.jar
   ```
5. You should see the Jeff welcome message. Type a command and press Enter to begin.

---

## Features

### Adding a Todo task: `todo`

Adds a simple task without any date or time.

**Format:** `todo DESCRIPTION`

**Example:** `todo read book`

**Expected Output:**
```
______________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list
______________________________________________
```

---

### Adding a Deadline task: `deadline`

Adds a task that must be completed by a specified time.

**Format:** `deadline DESCRIPTION /by TIME`

**Example:** `deadline return book /by June 6th`

**Expected Output:**
```
______________________________________________
Got it. I've added this task:
  [D][ ] return book (by: June 6th)
Now you have 2 tasks in the list
______________________________________________
```

---

### Adding an Event task: `event`

Adds a task that occurs over a specified time range.

**Format:** `event DESCRIPTION /from START /to END`

**Example:** `event project meeting /from Mon 2pm /to Mon 4pm`

**Expected Output:**
```
______________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: Mon 2pm to: Mon 4pm)
Now you have 3 tasks in the list
______________________________________________
```

---

### Listing all tasks: `list`

Displays all tasks currently in the task list.

**Format:** `list`

**Expected Output:**
```
______________________________________________
Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] return book (by: June 6th)
3. [E][ ] project meeting (from: Mon 2pm to: Mon 4pm)
______________________________________________
```

---

### Marking a task as done: `mark`

Marks a task as completed. You can specify the task by its 1-based index or by its name.

**Format:** `mark INDEX` or `mark TASK_NAME`

**Examples:**
- `mark 1`
- `mark read book`

**Expected Output:**
```
______________________________________________
Nice! I've marked this task as done:
  [T][X] read book
______________________________________________
```

---

### Unmarking a task: `unmark`

Marks a task as not done. You can specify the task by its 1-based index or by its name.

**Format:** `unmark INDEX` or `unmark TASK_NAME`

**Examples:**
- `unmark 1`
- `unmark read book`

**Expected Output:**
```
______________________________________________
OK, I've marked this task as not done yet:
  [T][ ] read book
______________________________________________
```

---

### Deleting a task: `delete`

Removes a task from the list. You can specify the task by its 1-based index or by its name.

**Format:** `delete INDEX` or `delete TASK_NAME`

**Examples:**
- `delete 2`
- `delete return book`

**Expected Output:**
```
______________________________________________
Noted. I've removed this task:
  [D][ ] return book (by: June 6th)
Now you have 2 tasks in the list.
______________________________________________
```

---

### Finding tasks by keyword: `find`

Searches for tasks whose descriptions contain the given keyword (case-insensitive).

**Format:** `find KEYWORD`

**Example:** `find book`

**Expected Output:**
```
______________________________________________
Here are the matching tasks in your list:
1.[T][X] read book
2.[D][ ] return book (by: June 6th)
______________________________________________
```

---

### Exiting Jeff: `bye`

Exits the Jeff program.

**Format:** `bye`

**Expected Output:**
```
______________________________________________
 Bye. Hope to see you again soon!
______________________________________________
```

---

## Saving the Data

Jeff automatically saves your tasks to a file after every change (adding, marking, unmarking, or deleting).

- The save file is located at: `data/jeff.txt` (relative to where the JAR is run).
- Tasks are loaded automatically the next time you start Jeff.

---

## Command Summary

| Action        | Format                                          |
|---------------|-------------------------------------------------|
| Add Todo      | `todo DESCRIPTION`                              |
| Add Deadline  | `deadline DESCRIPTION /by TIME`                 |
| Add Event     | `event DESCRIPTION /from START /to END`         |
| List          | `list`                                          |
| Mark          | `mark INDEX` or `mark TASK_NAME`                |
| Unmark        | `unmark INDEX` or `unmark TASK_NAME`            |
| Delete        | `delete INDEX` or `delete TASK_NAME`            |
| Find          | `find KEYWORD`                                  |
| Exit          | `bye`                                           |
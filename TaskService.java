import java.util.HashMap;
import java.util.Map;

// Task Service class where alterations to task happen
public class TaskService {

    // Creates a hash map for tasks
    private Map<String, Task> tasks = new HashMap<>();

    // Adds tasks
    public void addTask(Task task) {

        // If the task is null or the task ID is null throw exception
        if (task == null || task.getTaskId() == null) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }

        // Otherwise, if the task contains the same task ID, throw exception
        else if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task already exists");
        }

        // If neither is true then add the task
        tasks.put(task.getTaskId(), task);
    }

    // Removes the task using the task ID
    public void deleteTask(String taskID) {
        tasks.remove(taskID);
    }

    // Gets the task using the taskID
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }

    // Updates the task name using the task ID
    public void updateTaskName(String taskID, String newName) {
        Task task = tasks.get(taskID);
        task.setName(newName);
    }

    // Updates the task description using the task ID
    public void updateTaskDescription(String taskID, String newDescription) {
        Task task = tasks.get(taskID);
        task.setDesc(newDescription);
    }
}

// Task class, the home of the getters and setters
public class Task {
    private String taskID;
    private boolean taskIdSet = false;

    private String name;
    private String desc;

    // Constructor for tasks using setters
    public Task(String taskID, String name, String desc) {
        setTaskId(taskID);
        setName(name);
        setDesc(desc);
    }

    // Gets the task ID
    public String getTaskId() {
        return taskID;
    }

    // Sets the task ID
    public void setTaskId(String taskID) {

        // If the task ID is already used, throw exception
        if (taskIdSet) {
            throw new IllegalArgumentException("Task ID cannot be updated once set");
        }

        // If the task ID is null or longer then 10 characters, throw exception
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null or more than 10 characters");
        }

        // Otherwise add task ID
        this.taskID = taskID;
        this.taskIdSet = true;
    }

    // Gets task name
    public String getName() {
        return name;
    }

    // Sets task name
    public void setName(String name) {

        // If name is null or longer then 20, throw exception
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null or more than 20 characters");
        }
        this.name = name;
    }

    // Gets description
    public String getDesc() {
        return desc;
    }

    // Sets the description
    public void setDesc(String desc) {

        // If the description is null or more than 50 characters, throw exception
        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null or more than 50 characters");
        }

        // Otherwise set description
        this.desc = desc;
    }
}

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    // Tests if a duplicate ID throws an exception
    @Test
    public void testAddTaskDuplicateIdFail() {
        TaskService service = new TaskService();
        Task task1 = new Task("123457","Laundry","Wash the clothes");
        Task task2 = new Task("123457","Mop","Wash the floors");

        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    // Tests if tasks are added successfully
    @Test
    public void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234","Laundry","Wash the clothes");

        service.addTask(task1);

        assertEquals(task1, service.getTask(task1.getTaskId()));
    }

    // Tests if tasks are deleted successfully
    @Test
    public void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234","Laundry","Wash the clothes");

        service.addTask(task1);
        service.deleteTask(task1.getTaskId());
        assertNull(service.getTask(task1.getTaskId()));
    }

    // Tests if task updates task name using task ID
    @Test
    public void testUpdateTaskNameSuccess() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234","Laundry","Wash the clothes");
        service.addTask(task1);

        service.updateTaskName(task1.getTaskId(), "Break Time!");
        assertEquals("Break Time!", task1.getName());
    }

    // Tests if task updates task description using task ID
    @Test
    public void testUpdateTaskDescriptionSuccess() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234","Laundry","Wash the clothes");
        service.addTask(task1);

        service.updateTaskDescription(task1.getTaskId(), "Eat pizza");
        assertEquals("Eat pizza", task1.getDesc());
    }
}

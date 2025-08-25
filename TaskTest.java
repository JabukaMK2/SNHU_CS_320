import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    // Tests if task creation fails with invalid information
    @Test
    public void testCreateTaskFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901","Laundry","Wash the clothes");
        });
    }

    // Tests that a task can be created with all information successfully
    @Test
    public void testCreateTaskSuccess() {
        Assertions.assertDoesNotThrow(() -> {
            Task task = new Task("123456","Laundry","Wash the clothes");

            assertNotNull(task);

            assertEquals("123456", task.getTaskId());
            assertEquals("Laundry", task.getName());
        });
    }

    // Tests if task ID creation fails if the task ID is too long
    @Test
    public void testCreateTaskIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901","Laundry","Wash the clothes");
        });
    }

    // Tests if name creation fails if the task name is too long
    @Test
    public void testCreateTaskNameFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("123456","Laundryismyleastfavoritethingintheentireworld","Wash the clothes");
        });
    }

    // Tests if description fails if the description is too long
    @Test
    public void testCreateTaskDescriptionFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("123456","Laundry","Wash the clothes because I want to and no one can tell me otherwise, I would be so happy to wash them as I love watching the washing machine spin");
        });
    }

    // Tests if the ID set fails if it is null
    @Test
    public void testSetTaskIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(null,"Laundry","Wash the clothes");
        });
    }
}

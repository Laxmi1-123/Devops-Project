import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceStatusTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1,"Study",2));
    }

    @Test
    void shouldMarkTaskDone() {

        boolean result = service.markDone(1);

        assertTrue(result);
        assertTrue(service.getTask(1).isDone());
    }

    @Test
    void markDoneOnInvalidTaskShouldReturnFalse() {

        boolean result = service.markDone(99);

        assertFalse(result);
    }

    @Test
    void newTaskShouldBePending() {

        Task task = service.getTask(1);

        assertFalse(task.isDone());
    }
}
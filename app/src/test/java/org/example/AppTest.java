package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void appHasAGreeting() {
        App app = new App();
        assertNotNull(app.getGreeting());
    }

    // test Cutie
    static class TestCutie implements Cutie {
        private String name;

        TestCutie(String name) {
            this.name = name;
        }

        public String description() {
            return name;
        }

        public Integer cutenessRating() {
            return 10;
        }
    }

    @Test
    void testQueueFunctionality() {
        App.CutieQueue queue = new App.CutieQueue(2);

        queue.enqueue(new TestCutie("A"));
        queue.enqueue(new TestCutie("B"));

        assertEquals(2, queue.size());

        Cutie removed = queue.dequeue();
        assertEquals("A", removed.description());

        assertEquals(1, queue.size());
    }

    @Test
    void testQueueFull() {
        App.CutieQueue queue = new App.CutieQueue(1);

        queue.enqueue(new TestCutie("A"));
        queue.enqueue(new TestCutie("B")); // should not be added

        assertEquals(1, queue.size());
    }

    @Test
    void testEmptyQueue() {
        App.CutieQueue queue = new App.CutieQueue(1);

        Cutie result = queue.dequeue();

        assertNull(result);
    }
}

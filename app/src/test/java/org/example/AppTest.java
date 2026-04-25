package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void appHasAGreeting() {
        App app = new App();
        assertNotNull(app.getGreeting());
    }

    // simple Cutie for testing
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
    void testEnqueueAndSize() {
        CutieQueue queue = new CutieQueue(2);

        queue.enqueue(new TestCutie("A"));
        queue.enqueue(new TestCutie("B"));

        assertEquals(2, queue.size());
    }

    @Test
    void testDequeueFIFO() {
        CutieQueue queue = new CutieQueue(2);

        TestCutie a = new TestCutie("A");
        TestCutie b = new TestCutie("B");

        queue.enqueue(a);
        queue.enqueue(b);

        Cutie removed = queue.dequeue();

        assertEquals("A", removed.description());
        assertEquals(1, queue.size());
    }

    @Test
    void testQueueFull() {
        CutieQueue queue = new CutieQueue(1);

        queue.enqueue(new TestCutie("A"));
        queue.enqueue(new TestCutie("B")); // should not be added

        assertEquals(1, queue.size());
    }

    @Test
    void testEmptyDequeue() {
        CutieQueue queue = new CutieQueue(2);

        Cutie result = queue.dequeue();

        assertNull(result);
    }
}

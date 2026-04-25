package org.example;

import java.util.ArrayList;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    // Queue implementation INSIDE App
    static class CutieQueue {
        private ArrayList<Cutie> queue;
        private int capacity;

        public CutieQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new ArrayList<>();
        }

        public void enqueue(Cutie item) {
            if (queue.size() >= capacity) {
                System.out.println("Queue is full");
                return;
            }
            queue.add(item);
        }

        public Cutie dequeue() {
            if (queue.isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }
            return queue.remove(0);
        }

        public int size() {
            return queue.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}

//Name: Rohit Katkar
//Id: c0908798

//4. **The Queue of Explorers (20 points)**
//   Implement a `ExplorerQueue` class using a circular queue. The queue should:
//   - Enqueue new explorers
//   - Dequeue explorers when they enter the temple
//   - Display the next explorer in line
//   - Check if the queue is full or empty


package ExplorerQueue;
import java.util.Scanner;

public class ExplorerQueue {
    private String[] queue; // Array to store explorer names
    private int front;      // Points to the front of the queue
    private int rear;       // Points to the rear of the queue
    private int size;       // Maximum size of the queue
    private int count;      // Number of elements in the queue

    // Constructor to initialize the queue with a given size
    public ExplorerQueue(int size) {
        this.size = size;
        queue = new String[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == size;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Enqueue a new explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add " + explorer);
            return;
        }
        rear = (rear + 1) % size; // Circular increment
        queue[rear] = explorer;
        count++;
        System.out.println(explorer + " added to the queue.");
    }

    // Dequeue the next explorer
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No explorer to remove.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % size; // Circular increment
        count--;
        System.out.println(explorer + " entered the temple and was removed from the queue.");
        return explorer;
    }

    // Peek at the next explorer in line
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No explorer at the front.");
            return null;
        }
        System.out.println("Next explorer in line is: " + queue[front]);
        return queue[front];
    }

    // Display all explorers currently in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Explorers in the queue: ");
        int tempFront = front;
        for (int i = 0; i < count; i++) {
            System.out.print(queue[tempFront] + " ");
            tempFront = (tempFront + 1) % size; // Circular increment
        }
        System.out.println();
    }

    // Main method to test the ExplorerQueue class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the explorer queue: ");
        int maxSize = scanner.nextInt();
        ExplorerQueue explorerQueue = new ExplorerQueue(maxSize);
        scanner.nextLine(); // Consume the newline

        int choice;
        String explorerName;

        do {
            System.out.println("\n1. Add an explorer");
            System.out.println("2. Remove the next explorer");
            System.out.println("3. Peek at the next explorer");
            System.out.println("4. Display all explorers in the queue");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the explorer to add: ");
                    explorerName = scanner.nextLine();
                    explorerQueue.enqueue(explorerName);
                    break;
                case 2:
                    explorerQueue.dequeue();
                    break;
                case 3:
                    explorerQueue.peek();
                    break;
                case 4:
                    explorerQueue.displayQueue();
                    break;
                case 5:
                    System.out.println("Exiting the explorer queue program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
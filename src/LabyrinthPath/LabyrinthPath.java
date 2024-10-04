//Name: Rohit Katkar
//Id: c0908798

//2. **The Linked List Labyrinth (20 points)**
//   Create a `LabyrinthPath` class using a singly linked list. Implement methods to:
//   - Add a new location to the path
//   - Remove the last visited location
//   - Check if the path contains a loop (trap)
//   - Print the entire path

package LabyrinthPath;
import java.util.Scanner;

public class LabyrinthPath {
    // Node class representing a location in the labyrinth
    class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head;  // Head of the linked list (start of the path)
    private Node tail;  // Tail of the linked list (end of the path)

    // Constructor
    public LabyrinthPath() {
        this.head = null;
        this.tail = null;
    }

    // Add a new location to the path (at the end)
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {  // Empty list
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(location + " added to the path.");
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("Path is empty. Nothing to remove.");
            return;
        }
        if (head == tail) {  // Only one element in the list
            System.out.println(head.location + " removed from the path.");
            head = null;
            tail = null;
            return;
        }
        // Traverse the list to find the second-to-last node
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        System.out.println(tail.location + " removed from the path.");
        current.next = null;  // Remove the last node
        tail = current;  // Update the tail
    }

    // Check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null) return false;
        
        Node slow = head;
        Node fast = head;

        // Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop detected in the path!");
                return true;
            }
        }
        System.out.println("No loop detected in the path.");
        return false;
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("Path is empty.");
            return;
        }

        Node current = head;
        System.out.print("Labyrinth Path: ");
        while (current != null) {
            System.out.print(current.location);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Test the LabyrinthPath class
    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int choice;

        do {
            System.out.println("\n1. Add a new location");
            System.out.println("2. Remove the last location");
            System.out.println("3. Print the path");
            System.out.println("4. Check for loops");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the location to add: ");
                    userInput = scanner.nextLine();
                    path.addLocation(userInput);
                    break;
                case 2:
                    path.removeLastLocation();
                    break;
                case 3:
                    path.printPath();
                    break;
                case 4:
                    path.containsLoop();
                    break;
                case 5:
                    System.out.println("Exiting the labyrinth path program!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}

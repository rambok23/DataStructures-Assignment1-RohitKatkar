//Name: Rohit Katkar
//Id: c0908798

//3. **The Stack of Ancient Texts (20 points)**
//   Develop a `ScrollStack` class that uses a stack to manage ancient scrolls. Include operations to:
//   - Push a new scroll onto the stack
//   - Pop the top scroll off the stack
//   - Peek at the top scroll without removing it
//   - Check if a specific scroll title exists in the stack


package ScrollStack;
import java.util.Stack;
import java.util.Scanner;

public class ScrollStack {
    // Stack to store the scrolls
    private Stack<String> scrollStack;

    // Constructor
    public ScrollStack() {
        scrollStack = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void pushScroll(String scrollTitle) {
        scrollStack.push(scrollTitle);
        System.out.println(scrollTitle + " added to the stack.");
    }

    // Pop the top scroll off the stack
    public String popScroll() {
        if (scrollStack.isEmpty()) {
            System.out.println("The stack is empty. No scroll to remove.");
            return null;
        }
        String removedScroll = scrollStack.pop();
        System.out.println(removedScroll + " removed from the stack.");
        return removedScroll;
    }

    // Peek at the top scroll without removing it
    public String peekScroll() {
        if (scrollStack.isEmpty()) {
            System.out.println("The stack is empty. No scroll to peek at.");
            return null;
        }
        String topScroll = scrollStack.peek();
        System.out.println("Top scroll is: " + topScroll);
        return topScroll;
    }

    // Check if a specific scroll title exists in the stack
    public boolean containsScroll(String scrollTitle) {
        boolean exists = scrollStack.contains(scrollTitle);
        if (exists) {
            System.out.println("The scroll \"" + scrollTitle + "\" is in the stack.");
        } else {
            System.out.println("The scroll \"" + scrollTitle + "\" is not in the stack.");
        }
        return exists;
    }

    // Display all scrolls in the stack (for debugging purposes)
    public void displayStack() {
        if (scrollStack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Scrolls in the stack: " + scrollStack);
        }
    }

    // Test the ScrollStack class
    public static void main(String[] args) {
        ScrollStack scrolls = new ScrollStack();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int choice;

        do {
            System.out.println("\n1. Add a new scroll");
            System.out.println("2. Remove the top scroll");
            System.out.println("3. Peek at the top scroll");
            System.out.println("4. Check for a specific scroll");
            System.out.println("5. Display all scrolls");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the scroll title to add: ");
                    userInput = scanner.nextLine();
                    scrolls.pushScroll(userInput);
                    break;
                case 2:
                    scrolls.popScroll();
                    break;
                case 3:
                    scrolls.peekScroll();
                    break;
                case 4:
                    System.out.print("Enter the scroll title to check: ");
                    userInput = scanner.nextLine();
                    scrolls.containsScroll(userInput);
                    break;
                case 5:
                    scrolls.displayStack();
                    break;
                case 6:
                    System.out.println("Exiting the scroll stack program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }
}

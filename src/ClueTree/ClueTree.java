//Name: Rohit Katkar
//Id: c0908798

//5. **The Binary Tree of Clues (20 points)**
//   Create a `ClueTree` class representing a binary tree of clues. Implement methods to:
//   - Insert a new clue
//   - Perform in-order, pre-order, and post-order traversals
//   - Find a specific clue in the tree
//   - Count the total number of clues in the tree

package ClueTree;
import java.util.Scanner;

class ClueNode {
    String clue;
    ClueNode left, right;

    // Constructor for creating a new ClueNode
    public ClueNode(String clue) {
        this.clue = clue;
        left = right = null;
    }
}

public class ClueTree {
    private ClueNode root;

    // Constructor for initializing the ClueTree
    public ClueTree() {
        root = null;
    }

    // Insert a new clue into the binary tree
    public void insertClue(String clue) {
        root = insertRecursive(root, clue);
        System.out.println("Clue \"" + clue + "\" inserted.");
    }

    // Helper method to insert a new clue recursively
    private ClueNode insertRecursive(ClueNode root, String clue) {
        if (root == null) {
            root = new ClueNode(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRecursive(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRecursive(root.right, clue);
        }
        return root;
    }

    // Perform in-order traversal (Left, Root, Right)
    public void inOrderTraversal() {
        System.out.print("In-order traversal: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(ClueNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.clue + " ");
            inOrderRecursive(root.right);
        }
    }

    // Perform pre-order traversal (Root, Left, Right)
    public void preOrderTraversal() {
        System.out.print("Pre-order traversal: ");
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(ClueNode root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    // Perform post-order traversal (Left, Right, Root)
    public void postOrderTraversal() {
        System.out.print("Post-order traversal: ");
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(ClueNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the binary tree
    public boolean findClue(String clue) {
        return findClueRecursive(root, clue);
    }

    private boolean findClueRecursive(ClueNode root, String clue) {
        if (root == null) {
            return false;
        }
        if (root.clue.equals(clue)) {
            return true;
        }
        if (clue.compareTo(root.clue) < 0) {
            return findClueRecursive(root.left, clue);
        } else {
            return findClueRecursive(root.right, clue);
        }
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRecursive(root);
    }

    private int countCluesRecursive(ClueNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRecursive(root.left) + countCluesRecursive(root.right);
    }

    // Main method to test the ClueTree class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClueTree clueTree = new ClueTree();
        int choice;
        
        do {
            System.out.println("\n1. Insert a clue");
            System.out.println("2. In-order traversal");
            System.out.println("3. Pre-order traversal");
            System.out.println("4. Post-order traversal");
            System.out.println("5. Find a clue");
            System.out.println("6. Count total clues");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the clue to insert: ");
                    String clueToInsert = scanner.nextLine();
                    clueTree.insertClue(clueToInsert);
                    break;
                case 2:
                    clueTree.inOrderTraversal();
                    break;
                case 3:
                    clueTree.preOrderTraversal();
                    break;
                case 4:
                    clueTree.postOrderTraversal();
                    break;
                case 5:
                    System.out.print("Enter the clue to find: ");
                    String clueToFind = scanner.nextLine();
                    boolean found = clueTree.findClue(clueToFind);
                    System.out.println("Clue \"" + clueToFind + "\" found: " + found);
                    break;
                case 6:
                    System.out.println("Total number of clues in the tree: " + clueTree.countClues());
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
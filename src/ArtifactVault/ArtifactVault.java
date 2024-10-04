//Name: Rohit Katkar
//Id: c0908798

//1. **The Array Artifact (20 points)**
//   Implement a class `ArtifactVault` that uses an array to store ancient artifacts. Include methods to:
//   - Add an artifact to the first empty slot
//   - Remove an artifact by its name
//   - Find an artifact using linear search
//   - Find an artifact using binary search (assume the array is kept sorted by artifact age)


package ArtifactVault;
import java.util.Arrays;
import java.util.Scanner;

public class ArtifactVault {
	private Artifact[] artifacts; // Array to store artifacts
    private int size;             // Number of artifacts currently stored

    // Constructor
    public ArtifactVault(int capacity) {
        artifacts = new Artifact[capacity]; // Initialize the array with a given capacity
        size = 0;
    }
    // Artifact class to hold information
    class Artifact implements Comparable<Artifact> {
        String name;
        int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Artifact{name='" + name + "', age=" + age + "}";
        }

        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age); // Compare artifacts by age
        }
    }
 // Add an artifact to the first empty slot
    public boolean addArtifact(String name, int age) {
        if (size == artifacts.length) {
            System.out.println("Vault is full. Cannot add more artifacts.");
            return false;
        }
        artifacts[size] = new Artifact(name, age); // Add new artifact
        size++;
        Arrays.sort(artifacts, 0, size); // Keep array sorted by age
        return true;
    }
    
 // Remove an artifact by its name
    public boolean removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].name.equals(name)) {
                // Shift elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    artifacts[j] = artifacts[j + 1];
                }
                artifacts[size - 1] = null; // Remove the last artifact
                size--;
                return true;
            }
        }
        System.out.println("Artifact not found.");
        return false;
    }

 // Find an artifact using linear search
    public Artifact findArtifactLinear(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].name.equals(name)) {
                return artifacts[i];
            }
        }
        System.out.println("Artifact not found.");
        return null;
    }
    
    // Find an artifact using binary search (assume the array is sorted by artifact age)
    public Artifact findArtifactBinary(String name) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Artifact midArtifact = artifacts[mid];
            int compareResult = midArtifact.name.compareTo(name);

            if (compareResult == 0) {
                return midArtifact; // Artifact found
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Artifact not found.");
        return null;
    }
    
 // For debugging purposes: Display all artifacts
    public void displayArtifacts() {
        for (int i = 0; i < size; i++) {
            System.out.println(artifacts[i]);
        }
    }
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the vault capacity: ");
        int capacity = scanner.nextInt();
        ArtifactVault vault = new ArtifactVault(capacity);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an artifact");
            System.out.println("2. Remove an artifact");
            System.out.println("3. Find an artifact (Linear Search)");
            System.out.println("4. Find an artifact (Binary Search)");
            System.out.println("5. Display all artifacts");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter artifact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter artifact age: ");
                    int age = scanner.nextInt();
                    if (vault.addArtifact(name, age)) {
                        System.out.println("Artifact added successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter artifact name to remove: ");
                    String removeName = scanner.nextLine();
                    if (vault.removeArtifact(removeName)) {
                        System.out.println("Artifact removed successfully!");
                    }
                    break;

                case 3:
                    System.out.print("Enter artifact name to find (Linear Search): ");
                    String linearSearchName = scanner.nextLine();
                    Artifact foundArtifactLinear = vault.findArtifactLinear(linearSearchName);
                    if (foundArtifactLinear != null) {
                        System.out.println("Artifact found: " + foundArtifactLinear);
                    }
                    break;

                case 4:
                    System.out.print("Enter artifact name to find (Binary Search): ");
                    String binarySearchName = scanner.nextLine();
                    Artifact foundArtifactBinary = vault.findArtifactBinary(binarySearchName);
                    if (foundArtifactBinary != null) {
                        System.out.println("Artifact found: " + foundArtifactBinary);
                    }
                    break;

                case 5:
                    System.out.println("All artifacts in the vault:");
                    vault.displayArtifacts();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting! Goodbye");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }

        scanner.close();
    }
}

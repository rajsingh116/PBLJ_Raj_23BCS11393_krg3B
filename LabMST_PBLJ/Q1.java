import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class StudentList {
    private ArrayList<String> students = new ArrayList<>();

    public void addName(String name) {
        students.add(name);
    }

    public void removeName(String name) {
        if (students.contains(name)) {
            students.remove(name);
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println(name + " not found in the list.");
        }
    }

    public void displayNames() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList sl = new StudentList();
        int choice;

        do {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name to add: ");
                        String addName = sc.nextLine();
                        sl.addName(addName);
                        System.out.println(addName + " added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter name to remove: ");
                        String removeName = sc.nextLine();
                        sl.removeName(removeName);
                        break;

                    case 3:
                        sl.displayNames();
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (EmptyStudentListException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 4);

        sc.close();
    }
}

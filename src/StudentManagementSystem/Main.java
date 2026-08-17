
import java.util.Scanner;

/**
 * Entry poin1t of the Student Management System.
 */
public class Main {

    public static void main(String[] args) {

        // Create Scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Create input helper.
        InputHelper input = new InputHelper(scanner);

        // Create student service.
        StudentService studentService = new StudentService();

        // Controls whether the application continues running.
        boolean running = true;

        System.out.println("====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");

        // Keep showing the menu until the user chooses Exit.
        while (running) {

            displayMenu();

            int choice = input.readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent(input, studentService);
                    break;

                case 2:
                    studentService.displayAllStudents();
                    break;

                case 3:
                    searchStudent(input, studentService);
                    break;

                case 4:
                    updateStudent(input, studentService);
                    break;

                case 5:
                    deleteStudent(input, studentService);
                    break;

                case 6:
                    running = false;
                    System.out.println(
                            "\nExiting application..."
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please select 1-6."
                    );
            }
        }

        // Close Scanner after the application finishes.
        scanner.close();

        System.out.println(
                "Thank you for using Student Management System!"
        );
    }

    /**
     * Displays the main menu.
     */
    private static void displayMenu() {

        System.out.println("\n====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("====================================");
    }

    /**
     * Reads student information and adds a new student.
     */
    private static void addStudent(
            InputHelper input,
            StudentService studentService) {

        System.out.println("\n===== Add Student =====");

        int id = input.readInt("Enter Student ID: ");

        String name = input.readString(
                "Enter Student Name: "
        );

        int age = input.readInt(
                "Enter Student Age: "
        );

        double marks = input.readDouble(
                "Enter Student Marks: "
        );

        try {

            Student student
                    = new Student(id, name, age, marks);

            studentService.addStudent(student);

        } catch (InvalidStudentDataException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    /**
     * Searches for a student using the student ID.
     */
    private static void searchStudent(
            InputHelper input,
            StudentService studentService) {

        System.out.println("\n===== Search Student =====");

        int id = input.readInt(
                "Enter Student ID: "
        );

        studentService.searchStudent(id);
    }

    /**
     * Updates an existing student's information.
     */
    private static void updateStudent(
            InputHelper input,
            StudentService studentService) {

        System.out.println("\n===== Update Student =====");

        int id = input.readInt(
                "Enter Student ID: "
        );

        Student student
                = studentService.findStudentById(id);

        if (student == null) {

            System.out.println(
                    "Student with ID " + id + " not found."
            );

            return;
        }

        System.out.println("\nCurrent Student Details:");

        System.out.println(student);

        System.out.println("\nEnter New Details:");

        String name = input.readString(
                "Enter New Name: "
        );

        int age = input.readInt(
                "Enter New Age: "
        );

        double marks = input.readDouble(
                "Enter New Marks: "
        );

        try {

            studentService.updateStudent(
                    id,
                    name,
                    age,
                    marks
            );

        } catch (InvalidStudentDataException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    /**
     * Deletes a student using the student ID.
     */
    private static void deleteStudent(
            InputHelper input,
            StudentService studentService) {

        System.out.println("\n===== Delete Student =====");

        int id = input.readInt(
                "Enter Student ID: "
        );

        Student student
                = studentService.findStudentById(id);

        if (student == null) {

            System.out.println(
                    "Student with ID " + id + " not found."
            );

            return;
        }

        System.out.println("\nStudent Found:");

        System.out.println(student);

        boolean deleted
                = studentService.deleteStudent(id);

        if (deleted) {

            System.out.println(
                    "\nStudent deleted successfully!"
            );
        }
    }
}


/**
 * Represents a student in the Student Management System.
 *
 * This class demonstrates:
 * - Encapsulation
 * - Constructor
 * - Getters and Setters
 * - Data validation
 * - Custom exception handling
 */
public class Student {

    // Private fields to achieve encapsulation.
    private int id;
    private String name;
    private int age;
    private double marks;

    /**
     * Parameterized constructor.
     *
     * @param id student ID
     * @param name student name
     * @param age student age
     * @param marks student marks
     * @throws InvalidStudentDataException if data is invalid
     */
    public Student(
            int id,
            String name,
            int age,
            double marks)
            throws InvalidStudentDataException {

        // Validate student ID.
        if (id <= 0) {
            throw new InvalidStudentDataException(
                    "Student ID must be greater than 0."
            );
        }

        // Validate student name.
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException(
                    "Student name cannot be empty."
            );
        }

        // Validate student age.
        if (age <= 0 || age > 100) {
            throw new InvalidStudentDataException(
                    "Student age must be between 1 and 100."
            );
        }

        // Validate student marks.
        if (marks < 0 || marks > 100) {
            throw new InvalidStudentDataException(
                    "Student marks must be between 0 and 100."
            );
        }

        // Initialize object fields.
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // =========================
    // GETTERS
    // =========================
    /**
     * Returns the student ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the student age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the student marks.
     */
    public double getMarks() {
        return marks;
    }

    // =========================
    // SETTERS
    // =========================
    /**
     * Updates the student name.
     */
    public void setName(String name)
            throws InvalidStudentDataException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException(
                    "Student name cannot be empty."
            );
        }

        this.name = name;
    }

    /**
     * Updates the student age.
     */
    public void setAge(int age)
            throws InvalidStudentDataException {

        if (age <= 0 || age > 100) {
            throw new InvalidStudentDataException(
                    "Student age must be between 1 and 100."
            );
        }

        this.age = age;
    }

    /**
     * Updates the student marks.
     */
    public void setMarks(double marks)
            throws InvalidStudentDataException {

        if (marks < 0 || marks > 100) {
            throw new InvalidStudentDataException(
                    "Student marks must be between 0 and 100."
            );
        }

        this.marks = marks;
    }

    // =========================
    // DISPLAY METHOD
    // =========================
    /**
     * Displays student details.
     */
    public void displayDetails() {

        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Marks  : " + marks);
    }
}

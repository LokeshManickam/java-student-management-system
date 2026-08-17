/**
 * Represents a student in the Student Management System.
 *
 * This class demonstrates:
 * - Class and Object
 * - Encapsulation
 * - Constructor
 * - Getters and Setters
 * - Data validation
 * - Custom exception handling
 * - toString() method
 */
public class Student {

    // Private fields provide encapsulation.
    private int id;
    private String name;
    private int age;
    private double marks;

    /**
     * Creates a student after validating all input values.
     *
     * @param id     student ID
     * @param name   student name
     * @param age    student age
     * @param marks  student marks
     * @throws InvalidStudentDataException if any value is invalid
     */
    public Student(
            int id,
            String name,
            int age,
            double marks)
            throws InvalidStudentDataException {

        validateId(id);
        validateName(name);
        validateAge(age);
        validateMarks(marks);

        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // =========================
    // VALIDATION METHODS
    // =========================

    /**
     * Validates the student ID.
     */
    private void validateId(int id)
            throws InvalidStudentDataException {

        if (id <= 0) {
            throw new InvalidStudentDataException(
                    "Student ID must be greater than 0."
            );
        }
    }

    /**
     * Validates the student name.
     */
    private void validateName(String name)
            throws InvalidStudentDataException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException(
                    "Student name cannot be empty."
            );
        }
    }

    /**
     * Validates the student age.
     */
    private void validateAge(int age)
            throws InvalidStudentDataException {

        if (age <= 0 || age > 100) {
            throw new InvalidStudentDataException(
                    "Student age must be between 1 and 100."
            );
        }
    }

    /**
     * Validates student marks.
     */
    private void validateMarks(double marks)
            throws InvalidStudentDataException {

        if (marks < 0 || marks > 100) {
            throw new InvalidStudentDataException(
                    "Student marks must be between 0 and 100."
            );
        }
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

        validateName(name);

        this.name = name;
    }

    /**
     * Updates the student age.
     */
    public void setAge(int age)
            throws InvalidStudentDataException {

        validateAge(age);

        this.age = age;
    }

    /**
     * Updates the student marks.
     */
    public void setMarks(double marks)
            throws InvalidStudentDataException {

        validateMarks(marks);

        this.marks = marks;
    }

    // =========================
    // TOSTRING
    // =========================

    /**
     * Returns a formatted string containing student details.
     *
     * @return student information as a String
     */
    @Override
    public String toString() {

        return "ID     : " + id +
                "\nName   : " + name +
                "\nAge    : " + age +
                "\nMarks  : " + marks;
    }
}
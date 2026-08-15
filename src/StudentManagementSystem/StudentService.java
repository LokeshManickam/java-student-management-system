
import java.util.ArrayList;

/**
 * Provides business operations for students.
 *
 * This class is responsible for: - Adding students - Finding students -
 * Displaying students - Updating students - Deleting students
 */
public class StudentService {

    // Stores all students in memory.
    private ArrayList<Student> students;

    /**
     * Constructor initializes the student list.
     */
    public StudentService() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student after checking for duplicate ID.
     *
     * @param student student to add
     * @throws InvalidStudentDataException if the ID already exists
     */
    public void addStudent(Student student)
            throws InvalidStudentDataException {

        // Check whether the ID already exists.
        if (findStudentById(student.getId()) != null) {

            throw new InvalidStudentDataException(
                    "Student ID " + student.getId() + " already exists."
            );
        }

        // Add the student to the list.
        students.add(student);

        System.out.println("Student added successfully!");
    }

    /**
     * Finds a student using the student ID.
     *
     * @param id student ID to search
     * @return student object if found, otherwise null
     */
    public Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    /**
     * Displays all students.
     */
    public void displayAllStudents() {

        // Check whether the list is empty.
        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;
        }

        System.out.println("\n===== Student List =====");

        // Display every student.
        for (Student student : students) {

            student.displayDetails();

            System.out.println("--------------------");
        }
    }

    /**
     * Searches for a student and displays the student's details.
     *
     * @param id student ID to search
     */
    public void searchStudent(int id) {

        Student student = findStudentById(id);

        // Student doesn't exist.
        if (student == null) {

            System.out.println(
                    "Student with ID " + id + " not found."
            );

            return;
        }

        // Student exists.
        System.out.println("\n===== Student Found =====");

        student.displayDetails();
    }

    /**
     * Updates an existing student's information.
     *
     * All new values are validated before changing the existing object.
     *
     * @param id existing student ID
     * @param name new student name
     * @param age new student age
     * @param marks new student marks
     * @throws InvalidStudentDataException if the student doesn't exist or new
     * data is invalid
     */
    public void updateStudent(
            int id,
            String name,
            int age,
            double marks)
            throws InvalidStudentDataException {

        // Find the existing student.
        Student student = findStudentById(id);

        // Stop if the student doesn't exist.
        if (student == null) {

            throw new InvalidStudentDataException(
                    "Student with ID " + id + " not found."
            );
        }

        /*
         * Create a temporary Student object.
         *
         * The constructor validates ALL new values first.
         *
         * If any value is invalid, the existing student
         * remains completely unchanged.
         */
        Student validatedStudent
                = new Student(id, name, age, marks);

        /*
         * All validation passed.
         * Now update the existing student.
         */
        student.setName(validatedStudent.getName());
        student.setAge(validatedStudent.getAge());
        student.setMarks(validatedStudent.getMarks());

        System.out.println("Student updated successfully!");
    }

    /**
     * Deletes a student using the student ID.
     *
     * @param id student ID to delete
     * @return true if deleted, otherwise false
     */
    public boolean deleteStudent(int id) {

        // Find the student first.
        Student student = findStudentById(id);

        // Student doesn't exist.
        if (student == null) {
            return false;
        }

        // Remove the student from the list.
        students.remove(student);

        return true;
    }
}

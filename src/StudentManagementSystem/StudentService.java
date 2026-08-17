import java.util.ArrayList;

/**
 * Provides business operations for students.
 */
public class StudentService {

    // Stores all students in memory.
    private final ArrayList<Student> students;

    /**
     * Creates an empty student list.
     */
    public StudentService() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student after checking for duplicate ID.
     *
     * @param student student to add
     * @throws InvalidStudentDataException if ID already exists
     */
    public void addStudent(Student student)
            throws InvalidStudentDataException {

        if (findStudentById(student.getId()) != null) {

            throw new InvalidStudentDataException(
                    "Student ID " + student.getId() +
                            " already exists."
            );
        }

        students.add(student);

        System.out.println(
                "Student added successfully!"
        );
    }

    /**
     * Finds a student by ID.
     *
     * @param id student ID
     * @return student if found, otherwise null
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

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        System.out.println(
                "\n===== Student List ====="
        );

        for (Student student : students) {

            System.out.println(student);

            System.out.println(
                    "--------------------"
            );
        }
    }

    /**
     * Searches for a student by ID.
     *
     * @param id student ID
     */
    public void searchStudent(int id) {

        Student student = findStudentById(id);

        if (student == null) {

            System.out.println(
                    "Student with ID " +
                            id +
                            " not found."
            );

            return;
        }

        System.out.println(
                "\n===== Student Found ====="
        );

        System.out.println(student);
    }

    /**
     * Updates an existing student's information.
     *
     * All new values are validated before the existing
     * student is modified.
     *
     * @param id     existing student ID
     * @param name   new name
     * @param age    new age
     * @param marks  new marks
     * @throws InvalidStudentDataException if data is invalid
     */
    public void updateStudent(
            int id,
            String name,
            int age,
            double marks)
            throws InvalidStudentDataException {

        Student student = findStudentById(id);

        if (student == null) {

            throw new InvalidStudentDataException(
                    "Student with ID " +
                            id +
                            " not found."
            );
        }

        /*
         * Validate all new values before modifying
         * the existing student.
         */
        Student validatedStudent =
                new Student(
                        id,
                        name,
                        age,
                        marks
                );

        student.setName(
                validatedStudent.getName()
        );

        student.setAge(
                validatedStudent.getAge()
        );

        student.setMarks(
                validatedStudent.getMarks()
        );

        System.out.println(
                "Student updated successfully!"
        );
    }

    /**
     * Deletes a student using the student ID.
     *
     * @param id student ID
     * @return true if deleted, otherwise false
     */
    public boolean deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student == null) {
            return false;
        }

        students.remove(student);

        return true;
    }
}
import java.util.*;

class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

class Course {
    private String courseName;
    private String instructor;
    private List<String> students;

    public Course(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<String> getStudents() {
        return students;
    }

    public void enrollStudent(String studentName) {
        students.add(studentName);
    }
}

public class VirtualClassroom {

    private List<User> users = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerUser(String name, String role) {
        users.add(new User(name, role));
        System.out.println("User " + name + " registered as " + role);
    }

    public void createCourse(String courseName, String instructor) {
        courses.add(new Course(courseName, instructor));
        System.out.println("Course " + courseName + " created by " + instructor);
    }

    public void enrollStudent(String courseName, String studentName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                course.enrollStudent(studentName);
                System.out.println("Student " + studentName + " enrolled in course " + courseName);
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public void showCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName() + " (Instructor: " + course.getInstructor() + ")");
        }
    }

    public void showStudentsInCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName)) {
                System.out.println("Students in " + courseName + ":");
                for (String student : course.getStudents()) {
                    System.out.println("- " + student);
                }
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public static void main(String[] args) {
        VirtualClassroom classroom = new VirtualClassroom();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Virtual Classroom ---");
            System.out.println("1. Register User");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Show Courses");
            System.out.println("5. Show Students in Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter role (Student/Teacher): ");
                    String role = scanner.nextLine();
                    classroom.registerUser(name, role);
                    break;
                case 2:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter instructor name: ");
                    String instructor = scanner.nextLine();
                    classroom.createCourse(courseName, instructor);
                    break;
                case 3:
                    System.out.print("Enter course name: ");
                    String enrollCourseName = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    classroom.enrollStudent(enrollCourseName, studentName);
                    break;
                case 4:
                    classroom.showCourses();
                    break;
                case 5:
                    System.out.print("Enter course name: ");
                    String showCourseName = scanner.nextLine();
                    classroom.showStudentsInCourse(showCourseName);
                    break;
                case 6:
                    System.out.println("Exiting Virtual Classroom. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String dept;

    public Student(int studentID, String name, int age, String dept) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return dept;
    }


    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentManager {
    private Student[] students;
    private int count;

    public StudentManager(int capacity) {
        students = new Student[capacity];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Student array is full!");
        }
    }

    public void viewAllStudents() {
        if (count == 0) {
            System.out.println("No student records available.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
            }
        }
    }

    public void searchStudentByID(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager(100); // Capacity of 100 students

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    Student student = new Student(studentID, name, age, department);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchID = scanner.nextInt();
                    manager.searchStudentByID(searchID);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

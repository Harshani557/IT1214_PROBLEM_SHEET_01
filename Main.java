class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    // Constructor
    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Days Attended: " + daysAttended);
    }
}


class Classroom {
    private Student[] students = new Student[10];
    private int count = 0;

    // Method to add a new student
    public void addStudent(Student student) {
        if (count < 10) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Classroom is full.");
        }
    }

    // Method to update attendance
    public void updateAttendance(int studentId, int newDaysAttended) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDaysAttended);
                System.out.println("Attendance updated for ID " + studentId);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("\nAll Student Details:");
        for (int i = 0; i < count; i++) {
            students[i].displayDetails();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Create classroom
        Classroom classroom = new Classroom();

        // Add students
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        // Update Bob Jones's attendance to 16
        classroom.updateAttendance(102, 16);

        // Try to update non-existent student ID 104
        classroom.updateAttendance(104, 14);

        // Display all students
        classroom.displayAllStudents();
    }
}

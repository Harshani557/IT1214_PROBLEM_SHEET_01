class Student {
	//1
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    // 2
    public Student(String name, int exam1, int exam2, int exam3) {
        validateScore(exam1);
        validateScore(exam2);
        validateScore(exam3);

        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    // 3
    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
    }

    // 4
    public String getName() {
        return name;
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public int getExam3() {
        return exam3;
    }

    //5
    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}

//6
public class Q5 {
    public static void main(String[] args) {
        try {
           
            Student student = new Student("John", 75, 110, 90);
            double avg = student.calculateAverage();
            System.out.printf("Student: %s, Average Score: %.2f\n", student.getName(), avg);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
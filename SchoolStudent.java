package polymorphism;

public class SchoolStudent extends Student {

    private String schoolName;
    private String standard;
    private String section;
    private String board;
    private String[] subjects;
    private double[] marks;
    private double percentage;
    private char grade;

    public SchoolStudent(String name, int rollNo, String gender, int age,
                         String schoolName, String standard, String section, String board,
                         String[] subjects, double[] marks) {
        super(name, rollNo, gender, age);
        this.schoolName = schoolName;
        this.standard = standard;
        this.section = section;
        this.board = board;
        this.subjects = subjects;
        this.marks = marks;
        calculatePercentageAndGrade();
    }

    // Calculate percentage and grade
    private void calculatePercentageAndGrade() {
        double total = 0;
        for (double m : marks) {
            total += m;
        }
        percentage = total / marks.length;

        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 75)
            grade = 'B';
        else if (percentage >= 60)
            grade = 'C';
        else if (percentage >= 45)
            grade = 'D';
        else
            grade = 'F';
    }

    @Override
    public void displaydetails() {
        super.display();
        System.out.println("School Name: " + schoolName);
        System.out.println("Standard: " + standard);
        System.out.println("Section: " + section);
        System.out.println("Board: " + board);

        System.out.println("Subjects and Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " : " + marks[i]);
        }

        System.out.println("Percentage: " + percentage + "%");
        System.out.println(" Grade: " + grade);
        System.out.println("==================================================");
    }
}

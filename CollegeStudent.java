package polymorphism;

import java.util.Scanner;

public class CollegeStudent extends Student {

    private String collegename;
    private String course;
    private String department;
    private int totalsemester;
    private int currentsemester;
    private double[] cgpalist;
    private double finalcgpa;

    // Constructor
    public CollegeStudent(String name, int rollno, String gender, int age,
                          String collegename, String course, String department,
                          int totalsemester, int currentsemester) {
        super(name, rollno, gender, age);
        this.collegename = collegename;
        this.course = course;
        this.department = department;
        this.totalsemester = totalsemester;
        this.currentsemester = currentsemester;
        this.cgpalist = new double[totalsemester];
        this.finalcgpa = 0.0;
    }

    // Getters and Setters
    public double getFinalCgpa() {
        return finalcgpa;
    }

    public double[] getCgpaList() {
        return cgpalist;
    }

    public void setCgpaList(double[] cgpalist) {
        this.cgpalist = cgpalist;
        calculatefinalcgpa(); // Automatically recalculate average
    }

    public void setTotalSemester(int totalsem) {
        this.totalsemester = totalsem;
    }

    public void setCurrentSemester(int currentsem) {
        this.currentsemester = currentsem;
    }

    // Update CGPA per semester 
    public void updateCgpaInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Total Semester No.: ");
        totalsemester = sc.nextInt();

        System.out.print("Enter the Current Semester No.: ");
        currentsemester = sc.nextInt();

        cgpalist = new double[currentsemester];
        for (int i = 0; i < currentsemester; i++) {
            System.out.print("Enter CGPA for Semester " + (i + 1) + ": ");
            cgpalist[i] = sc.nextDouble();
        }

        calculatefinalcgpa();
        System.out.println("\n CGPA Updated Successfully!");
    }

    //  Update specific semester CGPA manually
    public void updatecgpa(int semester, double cgpa) {
        if (semester > 0 && semester <= totalsemester) {
            cgpalist[semester - 1] = cgpa;
            calculatefinalcgpa();
            System.out.println("CGPA updated for semester: " + semester);
        } else {
            System.out.println("Invalid Semester Number!");
        }
    }

    // Calculate final CGPA average
    public void calculatefinalcgpa() {
        double sum = 0;
        int count = 0;
        for (double d : cgpalist) {
            if (d > 0) {
                sum += d;
                count++;
            }
        }
        if (count > 0) {
            finalcgpa = sum / count;
        } else {
            finalcgpa = 0;
        }
    }

    //  Check placement eligibility 
    public void CheckPlacementEligibility() {
        if (finalcgpa == 0) {
            System.out.println("⚠️ Please update CGPA first using Option 5!");
            return;
        }

        System.out.println("Average CGPA: " + finalcgpa);
        if (finalcgpa >= 7.0) {
            System.out.println(getName() + " is Eligible for Placement! ✅");
        } else {
            System.out.println(getName() + " is Not Eligible for Placement ❌");
        }
    }

    // Display student details 
    @Override
    public void displaydetails() {
        super.display(); 
        System.out.println("College Name: " + collegename);
        System.out.println("Course Name: " + course);
        System.out.println("Department: " + department);
        System.out.println("Total Semesters: " + totalsemester);
        System.out.println("Current Semester: " + currentsemester);

        // Show current CGPA status
        if (finalcgpa > 0)
            System.out.println("Final CGPA: " + finalcgpa);
        else
            System.out.println("Final CGPA: Not Updated");

        System.out.println("==================================================");
    }

    //  Show full CGPA record (if user says 'y')
    public void displayCGPARecord() {
        System.out.println("\n==== CGPA Record ====");
        boolean found = false;

        for (int i = 0; i < cgpalist.length; i++) {
            if (cgpalist[i] > 0) {
                System.out.println("Semester " + (i + 1) + ": " + cgpalist[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No CGPA records found. Kindly update the CGPA details first.");
        } else {
            System.out.println("Final Average CGPA: " + finalcgpa);
        }

        System.out.println("====================================\n");
    }
}

package polymorphism;

public class HostelStudent extends Student {

    private String hostelname;
    private int roomno;
    private String wardenname;
    private double hostelfees;
    private CollegeStudent linkedCollegeStudent; // Link to college student

    public HostelStudent(String name, int rollno, String gender, int age,
                         String hostelname, int roomno, String wardenname, double hostelfees,
                         CollegeStudent linkedCollegeStudent) {

        super(name, rollno, gender, age);
        this.hostelname = hostelname;
        this.roomno = roomno;
        this.wardenname = wardenname;
        this.hostelfees = hostelfees;
        this.linkedCollegeStudent = linkedCollegeStudent;
    }

    public CollegeStudent getLinkedCollegeStudent() {
        return linkedCollegeStudent;
    }

    @Override
    public void displaydetails() {
        display();
        System.out.println("Hostel Name: " + hostelname);
        System.out.println("Room No: " + roomno);
        System.out.println("Warden Name: " + wardenname);
        System.out.println("Hostel Fees: " + hostelfees);
        if (linkedCollegeStudent != null) {
            System.out.println("Linked to College Student: " + linkedCollegeStudent.getName() +
                               " (Roll No: " + linkedCollegeStudent.getRollNo() + ")");
        }
        System.out.println("==================================================");
    }
}

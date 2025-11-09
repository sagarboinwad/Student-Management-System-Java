package polymorphism;

public class Student {
	
	private String name;
	private int rollno;
	private String gender;
	private int age;
	
	public Student(String name, int rollno, String gender, int age) {
		this.name = name;
		this.rollno = rollno;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getRollNo() {
		return rollno;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
	public void display() {
		System.out.println("Name :"+ name);
		System.out.println("Roll No :"+ rollno);
		System.out.println("Gender :"+ gender);
		System.out.println("Age :"+ age);
	}
	
	public void displaydetails() {
		
	}

}

package polymorphism;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		int choice;
		
		do {
			System.out.println("\n==============|| Student Management System ||============");
			System.out.println("1. Add School Student Data");
			System.out.println("2. Add College Student Data");
			System.out.println("3. Add Hostel Student Data");
			System.out.println("4. Display All Details");
			System.out.println("5. Update College CGPA");
			System.out.println("6. Check Placement Eligibility");
			System.out.println("7. Exit");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 -> {
			    System.out.print("Enter Name: ");
			    String name = sc.nextLine();

			    System.out.print("Enter Roll No: ");
			    int roll = sc.nextInt();
			    sc.nextLine(); // clear buffer

			    System.out.print("Enter Gender: ");
			    String gender = sc.nextLine();

			    System.out.print("Enter Age: ");
			    int age = sc.nextInt();
			    sc.nextLine(); // clear buffer

			    System.out.print("Enter School Name: ");
			    String school = sc.nextLine();

			    System.out.print("Enter Standard: ");
			    String std = sc.nextLine();

			    System.out.print("Enter Section: ");
			    String section = sc.nextLine();

			    System.out.print("Enter Board: ");
			    String board = sc.nextLine();

			    System.out.print("Enter Subject Names (comma separated): ");
			    String[] subjects = sc.nextLine().split(",");

			    
			    for (int i = 0; i < subjects.length; i++) {
			        subjects[i] = subjects[i].trim();
			    }

			    // Create marks array and ask marks for each subject
			    double[] marks = new double[subjects.length];
			    for (int i = 0; i < subjects.length; i++) {
			        System.out.print("Enter marks for " + subjects[i] + ": ");
			        while (!sc.hasNextDouble()) {
			            System.out.print("Invalid input! Enter numeric marks: ");
			            sc.next();
			        }
			        marks[i] = sc.nextDouble();
			    }
			    sc.nextLine(); // clear buffer

			    //Now call the correct constructor with both subjects & marks
			    students.add(new SchoolStudent(name, roll, gender, age, school, std, section, board, subjects, marks));
			    System.out.println("School Student Data Added Successfully!\n");
			}

			   case 2 ->{
				   System.out.print("Enter Name: ");
                   String name = sc.nextLine();
                   
                   System.out.print("Enter Roll No: ");
                   int roll = sc.nextInt(); 
                   sc.nextLine();
                   
                   System.out.print("Enter Gender: ");
                   String gender = sc.nextLine();
                   
                   System.out.print("Enter Age: ");
                   int age = sc.nextInt(); 
                   sc.nextLine();
                   
                   System.out.print("Enter College Name: ");
                   String college = sc.nextLine();
                   
                   System.out.print("Enter Course: ");
                   String course = sc.nextLine();
                   
                   System.out.print("Enter Department: ");
                   String dept = sc.nextLine();
                   
                   System.out.print("Enter Total Semesters: ");
                   int total = sc.nextInt();
                   
                   System.out.print("Enter Current Semester: ");
                   int current = sc.nextInt();
                   
                   students.add(new CollegeStudent(name, roll, gender, age, college, course, dept, total, current));
                   System.out.println("College Student Data added successfully! \n");
			   }
			   case 3 ->{
				   System.out.print("Enter College Student Roll No. Staying in Hostel: ");
				   int roll = sc.nextInt();
				   sc.nextLine();
				   
				   CollegeStudent linkedCollegeStudent = null;

				   for (Student s : students) {
				       if (s instanceof CollegeStudent && s.getRollNo() == roll) {
				           linkedCollegeStudent = (CollegeStudent) s;
				           break;
				       }
				   }

				   if (linkedCollegeStudent == null) {
				       System.out.println(" No College Student Found with that Roll No! Add College Student first.");
				       break;
				   }

				   
				   System.out.print("Enter Hostel Name: ");
				   String hostelName = sc.nextLine();
				   
				   System.out.print("Enter Room No: ");
				   int roomNo = sc.nextInt();
				   sc.nextLine();
				   
				   System.out.print("Enter Warden Name: ");
				   String wardenName = sc.nextLine();
				   
				   System.out.print("Enter Hostel Fees: ");
				   double hostelFees = sc.nextDouble();
				   sc.nextLine();

				   students.add(new HostelStudent(linkedCollegeStudent.getName(), 
				       linkedCollegeStudent.getRollNo(),
				       linkedCollegeStudent.getGender(),
				       linkedCollegeStudent.getAge(),
				       hostelName, roomNo, wardenName, hostelFees,
				       linkedCollegeStudent));

				   System.out.println("\n Hostel Student Data Linked and Added Successfully!");

			   }
			   
			   case 4->{
			   
				    System.out.println("\n==============|| Display Student Details ||============");

				    System.out.println("1. Display School Student Details");
				    System.out.println("2. Display College Student Details");
				    System.out.println("3. Display Hostel Student Details");
				    System.out.print("Enter your choice: ");
				    int displayChoice = sc.nextInt();

				    switch (displayChoice) {
				        case 1 -> {
				            System.out.println("\n===== School Student Details =====");
				            for (Student s : students) {
				                if (s instanceof SchoolStudent) {
				                    s.displaydetails();
				                }
				            }
				        }

				        case 2 -> {
				            System.out.println("\n========== College Student Details ==========");
				            for (Student s : students) {
				                if (s instanceof CollegeStudent college) {
				                    college.displaydetails();

				                    System.out.print("\nDo you want to view detailed CGPA record for this student? (y/n): ");
				                    char view = sc.next().charAt(0);
				                    if (view == 'y' || view == 'Y') {
				                        college.displayCGPARecord();
				                    }
				                }
				            }
				        }

				        case 3 -> {
				            System.out.println("\n===== Hostel Student Details =====");
				            for (Student s : students) {
				                if (s instanceof HostelStudent) {
				                    s.displaydetails();
				                }
				            }
				        }

				        default -> System.out.println("Invalid choice!");
				    }
				}

               case 5->{
            	   System.out.print("Enter Roll No to update CGPA: ");
                   int roll = sc.nextInt();
                   boolean found = false;
                   
                   for(Student s : students) {
                	   if(s instanceof CollegeStudent && s.getRollNo() == roll) {
                		   CollegeStudent cs = (CollegeStudent) s;
                		   found = true;
                		   
                    	   System.out.print("Enter the Total Semester No. :");
                    	   int totalsem = sc.nextInt();
                    	   cs.setTotalSemester(totalsem);
                    	   
                    	   System.out.print("Enter the Current Semester No. :");
                    	   int currentsem = sc.nextInt();
                    	   cs.setCurrentSemester(currentsem);
                    	   
                    	   double[] cgpas = new double[currentsem];
                    	   for(int i = 0; i <= currentsem - 1; i++) {
                    		   System.out.print("Enter CGPA for Semester "+ (i + 1)+ " :");
                    		   cgpas[i] = sc.nextDouble();
                    	   }
                    	   cs.setCgpaList(cgpas);
                    	   System.out.print("\n CGPA Updated Successfully!");
                    	   break;
                		  
                		
                	   }
                   }
                   if(!found) {
                	   System.out.print("\n NO College Student Found with that Roll No!\n");
                   }
               }
               
               case 6->{
            	   System.out.print("Enter Roll No to check placement eligibility: ");
                   int roll = sc.nextInt();
                   boolean found = false;
                   
                   for (Student s : students) {
                	   if( s instanceof CollegeStudent && s.getRollNo() == roll) {
                		   CollegeStudent cs = (CollegeStudent) s;
                		   found = true;
                		   
                		   double[] cgpas = cs.getCgpaList();
                		   if(cgpas == null || cgpas.length == 0) {
                			   System.out.print("Please update CGPA first using option 5!");
                		   }else {
                			   double total = 0;
                			   double avgcgpa;
                			   for(double d : cgpas) 
                				   
                				   total += d;
                			       avgcgpa = total / cgpas.length;
                			       System.out.print("Average CGPA :"+ avgcgpa);
                			       if(avgcgpa >= 7.0) {
                			    	   System.out.print(cs.getName()+ " \n is Eligible for Placement!");
                			       }else {
                			    	   System.out.print(cs.getName()+ " \n is Not Eligible for Placement!");
                			       }
                			       
                		   }
                		   break;
                		   
                		   
                	   }
                       
                   }
                   if(!found) {
                	   System.out.print("\n NO College Student Found with that Roll No!\\n");
                   }
                   
               }
              
               
               case 7->{
            	   System.out.print("Existing.....");
               }
               default->{
            	   System.out.print("Invalid Choice, Please Try Again!");
               }
              
			}
			
		}while(choice != 7);
		sc.close();

	}

}

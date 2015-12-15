package application;


import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.Integer;
import java.io.*;

public class Driver
{
    private static ArrayList<Country> destinations = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Parent> parents = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<FieldProgram> fp = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    
	private TextField textField;
	private TextArea textArea;
	private int stage = 0;
	
	String userType = null;
	String username = null;
	String StudentMenu = null; 
	String student = null; 

    public Driver(TextField textField, TextArea textArea) {
    	this.textField = textField;
    	this.textArea = textArea;
    }
    
    public int getStage() {
    	return stage;
    }
    
    /**
     * Asks for User input
     * Checks if it has a valid log in 
     */
    public void Login() 
    {
    	testmethod();

        if (stage == 0) {
        	userType = textField.getText();
        	stage++;
        	textArea.appendText("\nPlease enter username(First and Last name (no spaces!)):");
        	textField.setText("");
        } else if (stage == 1) {
        	username = textField.getText();
        	stage++;
        	textField.setText("");
        	textArea.appendText("\nPlease enter password: ");
        } else if (stage == 2) {
        	String password = textField.getText();
        	System.out.println("got pass");
        	System.out.println(userType);
        	
        	textField.setText("");
        	if (userType.equals("parent"))
        		if(CheckValidLoginParent(username, password)) {
        			Parent par = null;
        			for (Parent parent : parents) {
        				if (parent.getUsername().equals(username)) {
        					par = parent;
        				}
        			}
        			ParentMenu(par);
        		}
        	else if(userType.equals("student"))
        		if(CheckValidLoginStudent(username, password)) {
        			System.out.println("VALID");
        			Student stud = null;
        			for (Student student : students) {
        				if (student.getUsername().equals(username)) {
        					stud = student;
        				}
        			}
        			StudentMenu(stud);
        			System.out.println("Started");
        		}
        	else 
        		textArea.appendText("\nNot a valid user. Try Again.");
    			System.out.println(students);

        		stage--;
        }
        /*
          System.out.print("Are you a student or parent?: ");
          String userType = in.next();
          System.out.println();
          System.out.println(userType);    
       
          System.out.print("Please enter username(First and Last name (no spaces!)): ");
          String username = in.next();
          System.out.println();
          System.out.println(username);
   
          System.out.print("Please enter password: ");
          String password = in.next();
          System.out.println();
          System.out.println(password); 
          
          
          if(userType.equals("parent"))
            CheckValidLoginParent(username, password);
          else if(userType.equals("student"))
            CheckValidLoginStudent(username, password);
          else 
            System.out.println("Not a valid user");
            */         

          
    }
    
    
   
    
    /**
     * Checks if a student has a valid log in 
     * @param username and password are valid or not
     * 
     */
    public boolean CheckValidLoginStudent(String username, String password)
    {
      for(Student stud : students)
      { 
          if(username.equals(stud.getUsername()))
          {
            if(password.equals(stud.getPassword()))
                StudentMenu(stud);
                return true;
          }
      
        }
      return false;
    
    }
    
    /**
     * checks whether parent has a valid login 
     * @param username and password are valid or not
     */
    public boolean CheckValidLoginParent(String username, String password)
    {
      for(Parent par : parents)
      { 
          if(username.equals(par.getUsername()))
          {
            if(password.equals(par.getPassword()))
                ParentMenu(par);
                return true;
            }
        
        }
      return false;
      
    
    }
    
    /**
     * Displays Student Menu options when User says they are a student 
     * @param student has five options 
     * @precondition: if the student does not pick one of the 5 options presented, throws an IllegalArgumentException that it is not a valid input and it will bring you back to the student menu 
     * Will recover if input is wrong by taking the student back to the StudentMenu 
     */
    public void StudentMenu(Student student)
    {
        String StudentMenu = "0";
        while (!(StudentMenu.equals("5"))) {
        
        	textArea.appendText("\n1. Courses currently enrolled in: ");
        	textArea.appendText("\n2. Field programs currently enrolled in: ");
        	textArea.appendText("\n3. Current Location: ");
        	textArea.appendText("\n4. Change Username: ");
        	textArea.appendText("\n5. Log out");
        
        
        StudentMenu = textField.getText();
        try {
        if (StudentMenu.equals("1") || StudentMenu.equals("2") || StudentMenu.equals("3") || StudentMenu.equals("4") || StudentMenu.equals("5"))
            {
        
        switch(StudentMenu)
        {
            case "1": viewCourse(student);
                        break;
            case "2": viewFieldProgram(student);
                        break;
            case "3": viewCurrentLocation();
                        break;
            case "4": viewChangeUsername(student);
                        break;
            case "5": Logout();
                        break;
        }
        
        }
        else throw new IllegalArgumentException(" Not a valid input");
    }
        catch(IllegalArgumentException e)
        {
            System.err.println("Caught Illegal Argument Exception" + e.getMessage());
        }
    }} 
    
    /**
     * Allows a student to change their username 
     * @param Student student 
     * returns nothing
     */
    public void viewChangeUsername(Student student)
    {
    	textArea.appendText("Enter username greater than 5 characters");
        student.setUsername(in.next()); 
    }

    /**
     * allows a student to view their courses
     * @param Student student 
     */
    public void viewCourse(Student student)
    {
        System.out.println(student.getCourse());
         StudentMenu(student);
    } 
  
    
/**
* allows a student to view their field programs
*/
    public void viewFieldProgram(Student student)
    {
        System.out.println(student.getCourse());
        
        ArrayList<Course> courses = student.getCourse();
        System.out.println("Type 1,2,3, or 4:" );
        
        int FieldProgramMenu = Integer.parseInt(in.next());             //taking input to pass it in 
        Course course = courses.get(FieldProgramMenu - 1);
        
        //System.out.println(course.getFieldProgram());
         StudentMenu(student);
    }
    
    /**
     * allows a student to view their current location
     *
     */
    public void viewCurrentLocation()
    {
    	textArea.appendText("CurrentLocation");
        // StudentMenu(student);
    
    }
    
    /**
     * When a student chooses option 5 off the menu, it logs them out 
     */
    public void Logout()
    {
    	textArea.appendText("Goodbye!");
        return;
    }
    
    
    /**
     * Displays Parent menu options when User says they are a parent 
     * @param parent has three options 
     * @precondition: if the parent does not pick one of the three options presented, throws an IllegalArgumentException that it is not a valid input and it will bring you back to the parent menu 
     * if the input is wrong, it will recover by taking the parent back to the ParentMenu to pick again until the enter the correct input 
     */
    public void ParentMenu(Parent par) throws IllegalArgumentException 
    {
      String ParentMenu = "0";
        while (!(ParentMenu.equals("3"))) {
          
        	textArea.appendText("\n1. Fetch Child: ");
        	textArea.appendText("\n2. Add Child: ");
        	textArea.appendText("\n3. Log out");
        
        
        ParentMenu = textField.getText();
         
        try {
        if (ParentMenu.equals("1") || ParentMenu.equals("2") || ParentMenu.equals("3"))
            {
                
        switch(ParentMenu)
        {
            case "1": viewChild(par);
                        break;
            case "2": addChild(par);
                        break;
            case "3": Logout();
                        break;
        }
         
    }
        else throw new IllegalArgumentException(" Not a valid input");
    }
        catch(IllegalArgumentException e)
        {
            System.err.println("Caught Illegal Argument Exception" + e.getMessage());
        }
    }}
    
    
    /**
     * allows parent to view their child 
     */
    public void viewChild(Parent par)
    {
       
    	textArea.appendText("This is: " + par.getChild().toString());
      //  ParentMenu(par);
    }
    
    /**
     * allows a parent to add their child 
     */
    public void addChild(Parent par)
    {
        //par.addchild();
    	textArea.appendText("Child Added");
          //      ParentMenu(par);
    }
    
    
    
    // public void CourseMenu() //menu for the courses, allows student to add courses
    
    
    
    
    
    
    
    
    
    
    
    /**
     * The sample input 
     */
    public void testmethod()
    {
        
        Country unitedStates = new Country("United States", "San Diego", 1);
        Country unitedStates2 = new Country("United States", "Honolulu", 2);
        Country japan = new Country("Japan", "Yokohama", 3);
        Country japan2 = new Country("Japan", "Kobe", 4);
        Country china = new Country("China", "Shanghai", 5);
        Country china2 = new Country("China", "Hong Kong", 6);
        Country vietnam = new Country("Vietnam", "Ho Chi Minh City", 7);
        Country burma = new Country("Burma", "Ragoon", 8);
        Country india = new Country("India", "Cochin", 9);
        Country mauritius = new Country("Mauritius", "Port Louis", 10);
        Country southAfrica = new Country("South Africa", "Cape Town", 11);
        Country ghana = new Country("Ghana", "Takoradi", 12);
        Country ghana2 = new Country("Ghana", "Tema Acca", 13);
        Country morocco = new Country("Morocco", "Casablanca", 14);
        Country england = new Country("England", "London", 15);
        
        destinations.add(unitedStates);
        destinations.add(japan);
        destinations.add(japan2);
        destinations.add(china);
        destinations.add(china2);
        destinations.add(vietnam);
        destinations.add(burma);
        destinations.add(india);
        destinations.add(mauritius);
        destinations.add(southAfrica);
        destinations.add(ghana);
        destinations.add(ghana2);
        destinations.add(morocco);
        destinations.add(england);
        
        fp.add(new FieldProgram("Hiking", destinations.get(1)));
        fp.add(new FieldProgram("Catamaran", destinations.get(2)));
        fp.add(new FieldProgram("TajMahal", destinations.get(3)));
        
        courses.add(new Course ("Art History", 30, fp.get(1)));
        courses.add(new Course ("History", 30, fp.get(0)));
        courses.add(new Course ("Marine Biology", 30, fp.get(1)));
        
        
        
        
        Student vee = new Student ("VeroniqueHut", "1234", 1, null, null);
        Student Bob = new Student ("BobMax","5678",2, null, null);
        Student Matt = new Student ("MattLane", "1234", 3, null, null);
        Student [] classList = {vee, Bob, Matt};
        
     
        //students.add(new Student("","1234", null, null));
        
        //parents.add(new Parent ("AgnesHut", "1234", vee));
        //parents.add(new Parent ("JakeMax", "5678", null));
        
        saveStudents(classList);
        readClassList();
        
    }
   
    
    
    
    public static void saveStudents(Student [] classList)
    {
        FileWriter writer = null;
        int length = classList.length;
       
        try {
                writer = new FileWriter("classList.txt");
        for (int i = 0; i < length; i++)
        {
            Student s = classList[i]; 
            {
                System.out.println(s);
                students.add(s);
                writer.write("Student: " + s.getUsername() + " | Student Password: " + s.getPassword() + "| Student's Courses: " + s.getCourse()+ "\n");
            }
        } 
        
        }
        catch (IOException e) {
            System.err.println("IOException: " + "Something went wrong.");
        } 
        finally{
            try {
            writer.close();
        } catch (IOException e) {
            System.err.println("IOExcetion: " + "Couldn't close file.");
        }
        }
    }
    
    public static void readClassList() 
    {
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader("classList.txt"));
            String myData;
            do {
                myData = myReader.readLine();
                System.out.println(myData);
            } while (myData != null);
            myReader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Oh NO file not there!");
        }
        catch(IOException e) {
            System.out.println("Oh NO!");
        }
       
    }
    
    
    
    /**
     * driver
     */
    public static void main (String args[])
    {
       /*Driver driver = new Driver();
       driver.testmethod();
       driver.Login();*/
       

       
       
   
   
   
   
  
    }


}
    
    
   

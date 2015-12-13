package application;


import java.util.ArrayList;
public class Student extends User
{
    private User login;
    private int id;
    private Parent parent;
    private Course course;
    private ArrayList<Course> courses;
    
    public Student(String username, String password, int id, Parent parent, Course course)
    {
        super(username, password);
        this.id = id; 
        this.parent = parent;
        this.courses = new ArrayList<Course>();
        this.courses.add(null);
        this.courses.add(null);
        this.courses.add(null);
        this.courses.add(null);
    }
    
    
    public void addClass(Course course) throws IndexOutOfBoundsException
    {
        int nullIndex = courses.indexOf(null);
        try
        {
        if (nullIndex != -1)
        {
            courses.set(nullIndex, course);
        }
        else
        {
            throw new IndexOutOfBoundsException("You are already signed up for 4 classes!"); 
            
        }
            
       
    }
    catch(IndexOutOfBoundsException e)
    {
        System.err.println("IndexOutOfBoundsException: " + e.getMessage());
    }
    }
    
    public String getLogin()
    {
        return "username: " + super.getUsername()  + "password: " + super.getPassword();
    }
    
    public void setLogin(String username, String password)
    {
        this.setUsername(username);
        this.setPassword(password);
    }
    
   
    public String getPassword()
    {
        return super.getPassword();
    }
    
    public String getUsername()
    {
        return super.getUsername();
    }
    
    public void setParent(Parent parent)
    {
        this.parent = parent;
        
    }
    
    
    public Parent getParent()
    {
        return parent;
    }
    
    public ArrayList<Course> getCourse()
    {
        return courses;
    }
    
    public String toString()
    {
        String name = getUsername();
        return name;
    }
    }

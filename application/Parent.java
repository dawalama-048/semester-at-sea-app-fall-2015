package application;

public class Parent extends User
{
    private User login;
    private Student child;
    
    public Parent(String username,String password, Student child)
   {
        super(username, password);
        this.child = child;
   }
    
    public String getLogin()
    {
        String output = "username: " + super.getUsername()  + "password: " + super.getPassword();
        return output;
    }
    
    public String getUsername()
    {
        return super.getUsername();
    }
    
    public String getPassword()
    {
        return super.getPassword();
    }
    
    public void setLogin(String username, String password)
    {
        this.setUsername(username);
        this.setPassword(password);
    }
        
    public void addChild(Student child)
    {
        this.child = child; 
    }
    
    
    public Student getChild()
    {
        return child;
    }
    
   
}

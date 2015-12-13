package application;


public class User
{
    private String username;
    private String password;
    
    /** 
     * takes in the username and password
     * throws Not A Valid Entry if the value for either is incorrect
     */
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        
    }
    
    /**
     * gets the username String of the User
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * gets the password of the User
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Sets the username
     * @param username is a String 
     * @precondition: throws IllegalArgumentException that the username (which is a person's first and last name) is greater than 5 characters
     * 
     * @postcondition: checks if the previous userName is the same as the new one 
     */
    public void setUsername(String username) throws IllegalArgumentException 
    {
       System.out.println("setUsername");
       String previousUsername = this.username; 
        if (username.length() < 5)
        {
            throw new IllegalArgumentException("The username must be longer than five characters!");
        }
         this.username = username; 
         
        assert !(previousUsername.equals(this.username));
         
    }
    
    
    /**
     * sets the password
     * @param password is a string 
     * @precondition: throws IllegalArgumentException that the password needs to be greater than five characters
     * 
     */
    public void setPassword(String password) throws IllegalArgumentException
    {
        
        if (password.length() < 4)
        {
            throw new IllegalArgumentException("The password mustbe longer than five characters!");
        }
        this.password = password;
    }
    
}


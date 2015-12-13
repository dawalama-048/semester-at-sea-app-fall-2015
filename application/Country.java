package application;

public class Country
{
    private String name;
    private String city;
    private int iD;
    
    /**
     * specifies that a Country needs a name, city, and ID
     * @param are name, city, and ID
     * 
     */public Country(String name, String city, int iD)
    {
        this.name = name;
        this.city = city;
        this.iD = iD;
    }
    
    /**
     * Gets the Country name 
     */
    public String getCountryName()
    {
        return name;
    }
    
    /**
     * Gets the City within a Country
     */
    public String getCountryCity()
    {
        return city;
    }
    
    /**
     * sets the ID
     * @param makes sure the ID is an interger
     * @precondition: The ID needs to be < 0 
     */
    public void setID(int id) throws IllegalArgumentException
    {
        try
        {
            if (id < 0)
                throw new IllegalArgumentException("The ID needs to be greater than 0");
            }
            catch(IllegalArgumentException e)
            {
                System.err.println("You cannot input negative id numbers");
            }
            this.iD = id;
        
    }
    
    /**
     * gets the ID
     */
    public int getID()
    {
        return iD;
    }
    
    /**
     * returns name
     */
    public String toString()
    {
        return this.name;
    }
    
    
    
    
}


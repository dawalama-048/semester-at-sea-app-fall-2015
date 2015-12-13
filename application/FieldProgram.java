package application;


public class FieldProgram
{
    private String name;
    private Country country;
    
    public FieldProgram(String name, Country country)
    {
        this.name = name;
        this.country = country;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Country getCountry()
    {
        return country;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setCountry(Country country)
    {
        this.country = country;
    }
        
        
 
}


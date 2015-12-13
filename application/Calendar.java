package application;

import java.util.*;

public class Calendar
{
  private ArrayList<Course> courseCalendar = new ArrayList<Course>();
  private ArrayList<FieldProgram> fieldprogram = new ArrayList<FieldProgram>();
  private ArrayList<String> time = new ArrayList<String>();
  private ArrayList<Country> country = new ArrayList<Country>();
  
  public Calendar(Course course, FieldProgram fieldprogram, String time, Country country)
    {
        this.courseCalendar.add(course);
        this.fieldprogram.add(fieldprogram);
        this.time.add(time);
        this.country.add(country);
    }
    
  public void addEvent(Course course, FieldProgram fieldprogram, String time, Country country)
  {
        this.courseCalendar.add(course);
        this.fieldprogram.add(fieldprogram);
        this.time.add(time);
        this.country.add(country);
    }
  
  public String getEvent(Course courseCalendar, FieldProgram fieldprogram, Country country)
  {
      int length = 1;
      
      for (int i = 0;i < length; i++)
      {
         if(this.courseCalendar.get(i) == courseCalendar && this.fieldprogram.get(i) == fieldprogram &&
         this.country.get(i) == country)
         {
          return "hello";//courseCalendar + fieldprogram + country + time.get(i);
        }
        }
      return "Event not found";
    }
 
 
}

  
  
    
    
  

  
   
    
    
    
    



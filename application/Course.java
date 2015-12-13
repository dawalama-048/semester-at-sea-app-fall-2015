package application;


public class Course
{
    private String courseName;
    private int numberOfStudents;
    private Student [] students = new Student[30];
    private FieldProgram fp;
    
    
    public Course(String courseName, int numberOfStudents, FieldProgram attachedFP)
    {
        this.courseName = courseName;
        this.numberOfStudents = numberOfStudents;
        fp = attachedFP;
    }
    
    public void addStudent(Student student, int studentNum)
    {
        this.students[studentNum] = student;
        numberOfStudents++;
    }
    
    
    
    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }
    
    public String getCourseName()
    {
        return courseName;
    }
    
    public void setFieldProgram(FieldProgram fp)
    {
        this.fp = fp;
    }
    
    public String getFieldProgram()
    { 
        return fp.getName();
    }
    
    
    public void dropStudent(Student student)
    {
        for (int i = 0; i < 30; i++) 
        {
            if (this.students[i] == student)
            {
                this.students[i] = null;
            }
            
        }
    }
    
}

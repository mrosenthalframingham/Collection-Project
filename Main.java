import java.util.*;
import java.io.*;


 class jobs
//variables for number of jobs available within a company department and the number of employees currently working
{
  private int noEmp;
  private int noJobs;
  
  //no argument constructor
  public jobs()
  {
    noEmp = 0;
    noJobs = 0;
  }
  //constructor w/ parameters 
  public jobs(int noEmp, int noJobs) 
  { 
    this.noEmp = noEmp; 
    this.noJobs = noJobs; 
  }

  //mutator methods
  public void setNoEmp(int noEmp) 
  { 
    this.noEmp = noEmp; 
  } 
  public void setNoJobs(int noJobs) 
  { 
    this.noJobs = noJobs; 
  } 

  //accessor methods: 
  public int getNoEmp() 
  { 
    return noEmp; 
  }
  public int getnoJobs() 
  { 
    return noJobs; 
  }

  //toString method
  public String toString() 
  { 
    return "\nNumber of jobs in department: " + this.noJobs + "\nTotal number of employees within department: " + this.noEmp;
  }
  
  public void FileWriter(PrintWriter write)
  { 
    write.println(toString()); 
  }
  public boolean readX(Scanner A)
  {
    if (A.hasNextInt())
    {
      noEmp = A.nextInt(); 
      noJobs = A.nextInt(); 
      return true;
    }
    else return false;
  }
}

 class jobsCol

{
  private jobs[] data;
  private int y;

  public jobsCol(int size) 
  { 
    y = 0; 
   
    data = new jobs[size];
     
    for (int index = 0; index < size; index++)
       data[index] = new jobs();
  }
  
  //Displays results to the user
  public void results() 
  { 
     for (int index = 0; index < y; index++)
     {
    	System.out.print(data[index].toString());
     }
  }

//Method to read data frm a file
public void readX(String name)
     throws FileNotFoundException 
{
    try 
    { 
      FileReader reader = new FileReader(name); 
      Scanner A = new Scanner(reader);
      while (data[y].readX(A))
        y++;
      A.close();
    }
    catch(FileNotFoundException excep)
      { 
        System.out.print("The requested file was not found");
      }
  }

//Writes collection to a text file
public void write(String name) 
    throws FileNotFoundException
{
    System.out.println();

    PrintWriter writer = new PrintWriter("collection.txt");
    for (int index = 0; index < y; index++)
    {
      writer.println(data[index].toString());
    }
    writer.close();	   
}
}

//Driver class
public class Main
{
  public static void main(String[] args) 
	throws FileNotFoundException
  {        
     jobsCol obj1 = new jobsCol(10);
     obj1.readX("jobs.txt");
     obj1.results();
     obj1.write("collection.txt");
  }
}
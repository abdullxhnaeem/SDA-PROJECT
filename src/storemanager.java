import java.io.*;
import java.util.*;

public class storemanager extends employee
{
    //Constructor For Parents
    storemanager(String username, String password, int salary,String emId, String designation)
    {
        super();
    }

    //Default Constructor
    storemanager()
    {
        super();
    }

    //This Function Adds An Employee and then Saves it data to a Text File Named Employee Data
    public void addEmployee()
    {
        Scanner o = new Scanner(System.in);


        System.out.println("Input Employee ID :");
        this.emp_id = o.nextInt();

        o.nextLine();


        Scanner o2=new Scanner(System.in);

        System.out.println("Input Name :");
        this.username = o2.nextLine();
        System.out.println("Input Password :");
        this.password = o2.nextLine();
        System.out.println("Input Designation :");
        this.designation = o2.nextLine();

        System.out.println("Input Salary :");
        this.salary = o2.nextInt();

        //Saves the Data
        saveData();
    }



    //Helper Function to Save Employee Data
    private void saveData()
    {
        System.out.println("Data Saved");
        try
        {
            FileWriter f = new FileWriter("employees.txt",true);
            f.write(Integer.toString(emp_id) +','+username+','+password+','+designation+','+salary+','+'A'+'\n');
            f.close();
        }
        catch(IOException e)
        {
            System.out.println("Error Occured!!");
            e.printStackTrace();
        }
    }

    //Read the Employee Data
    public void readData()
    {
        try
        {
            File f = new File("employees.txt");
            Scanner o = new Scanner(f);
            while (o.hasNextLine())
            {
                String d = o.nextLine();
                String[] arr = d.split(",");
                for(int i=0;i<arr.length;i++)
                {
                    System.out.print(arr[i]+'\t');
                }
                System.out.print('\n');
            }
        }
        catch(IOException e)
        {
            System.out.println("Error Occured!");
        }
    }
}


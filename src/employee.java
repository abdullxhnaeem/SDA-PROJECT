import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class employee extends person{
    public int emp_id;
    protected String designation;
    protected int salary;

    public employee(String u, String p, String pn, String c, String e, String a) {
        super(u, p, pn, c, e, a);
    }

    public employee() {
        super();
    }

    public void login(String username,String password)
    {
        String line="";
        char id='x';

        // Comparing user data with file data
        File file=new File("employees.txt");

        try {
            file.createNewFile();
        }
        catch (IOException e) {
            System.out.println("Unable to create File");
            e.printStackTrace();
        }

        try {
            Scanner sc2 = new Scanner(file);

            while(sc2.hasNextLine()) {
                line = sc2.nextLine();

                boolean check1 = line.contains(username);   // checking if username present
                boolean check2 = line.contains(password);   // checking if password presen

                if (check1 == true && check2 == true) {
                    id=line.charAt(0);
                    System.out.println("You have successfully Logged In with employee id : " + id);
                    break;
                }

            }

            if(id=='x')
            {
                System.out.println("The employee is not found. ERROR IN INFO");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


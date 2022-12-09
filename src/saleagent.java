import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class saleagent {

    public void markAttendance(String Emp_name) throws IOException {

        File file=new File("employees.txt");
        Scanner scanner=new Scanner(file);

        String line="";
        boolean marked=false;


        while(scanner.hasNextLine())
        {
            line=scanner.nextLine();

            if(line.contains(Emp_name)&&line.contains("saleagent"))
            {
                marked=true;
                break;
            }
        }

        scanner.close();


        if(marked==true) {
            String arr[] = line.split(",");
            arr[5] = "P";

            String newInfo = arr[0] + ',' + arr[1] + ',' + arr[2] + ',' + arr[3] + ',' + arr[4] + ',' + arr[5];
            resetEmployeeData(Emp_name, newInfo);
        }
        else
        {
            System.out.println("No Sale Agent found in the system with that name.");
        }

    }

    public void resetEmployeeData(String name, String Empinfo) throws IOException {

        File oldfile = new File("employees.txt");
        File newfile = new File("newemployees.txt");

        newfile.createNewFile();

        Scanner oldS = new Scanner(oldfile);
        FileWriter newF = new FileWriter(newfile);

        String line = "";
        char id = 'a';

        while (oldS.hasNextLine()) {
            line = oldS.nextLine();

            if (line.contains(name)) {
                newF.write(Empinfo + '\n');
                System.out.println("Employee with name " + name +" has been marked Present. \n");
            } else {
                newF.write(line + '\n');
            }

        }

        newF.close();
        oldS.close();

        oldfile.delete();

        newfile.renameTo(oldfile);
    }

    public boolean checkin()
    {
        File obj = new File("data.txt");
        try
        {
            FileWriter fw = new FileWriter("data.txt",true);
            if(obj.createNewFile())  // creating new file
            {
                System.out.println("File Creation Successful: " + obj.getName());
            }
            else
            {
                System.out.println("This file already exists ");
            }
            String fempID;
            String fName;
            String feType;
            if(obj.length() == 0)
            {
                return false;
            }
            else
            {

                // Taking input from user or entering card
                Scanner objS = new Scanner(System.in);
                System.out.println(" Enter Credentials ");
                String name = objS.nextLine();    // name entered by user
                String EType = objS.nextLine();    // empoyee type entered by user
                String empid = objS.nextLine();    // empID entered by user

                Scanner sc = new Scanner(obj);  // taking input from file

                while(sc.hasNextLine())
                {
                    fempID = sc.nextLine();
                    fName = sc.nextLine();
                    feType = sc.nextLine();
                    sc.close();
                    if(empid.equals(fempID) && name.equals(fName) && EType.equals(feType) )
                    {
                        System.out.println(name +  " do you want to check in ? Enter Yes or No ");

                        Scanner objSa = new Scanner(System.in);
                        String chckin = objSa.nextLine();
                        if(chckin.equals("Yes"))
                        {
                            System.out.println("This Employee has just checked in ");
                            return true;
                        }
                        else if (chckin.equals("No"))
                        {
                            System.out.println("This Employee has not checked in ");
                            return false;
                        }
                        else
                        {
                            return false;
                        }


                    }
                    else
                    {
                        System.out.println(" Card Scanned belongs either to a customer or eihter one of the manager");
                        return false;
                    }
                }
            }
        }
        catch(IOException exc)
        {
            System.out.println("Error: Fail to open this file");
            exc.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean checkout()
    {
        File obj = new File("data.txt");
        try
        {
            FileWriter fw = new FileWriter("data.txt",true);
            if(obj.createNewFile())  // creating new file
            {
                System.out.println("File Creation Successful: " + obj.getName());
            }
            else
            {
                System.out.println("This file already exists ");
            }
            String fempID;
            String fName;
            String feType;
            if(obj.length() == 0)
            {
                return false;
            }
            else
            {

                // Taking input from user or entering card
                Scanner objScan = new Scanner(System.in);
                System.out.println(" Enter Credentials ");
                String name = objScan.nextLine();    // name entered by user
                String EType = objScan.nextLine();    // empoyee type entered by user
                String empid = objScan.nextLine();    // empID entered by user

                Scanner sc = new Scanner(obj);  // taking input from file

                while(sc.hasNextLine())
                {
                    fempID = sc.nextLine();
                    fName = sc.nextLine();
                    feType = sc.nextLine();
                    if(empid.equals(fempID) && name.equals(fName) && EType.equals(feType) )
                    {
                        System.out.println(name +  " do you want to check out ? Enter Yes or No ");

                        Scanner objSca = new Scanner(System.in);
                        String chckin = objSca.nextLine();
                        if(chckin.equals("Yes"))
                        {
                            System.out.println("This Employee has just checked out ");
                            return true;
                        }
                        else
                        {
                            System.out.println("This Employee has not checked out ");
                            return false;
                        }


                    }
                    else
                    {
                        System.out.println(" Card Scanned belongs either to a customer or eihter one of the manager");
                        return false;
                    }
                }
            }
        }
        catch(IOException exc)
        {
            System.out.println("Error: Fail to open this file");
            exc.printStackTrace();
            return false;
        }
        return false;
    }

}

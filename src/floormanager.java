import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class floormanager extends employee {
    floormanager()
    {

    }

    public void TrackAttendance(String Emp_name) throws IOException {

        File file=new File("employees.txt");
        Scanner scanner=new Scanner(file);

        String line="";
        boolean marked=false;


        while(scanner.hasNextLine())
        {
            line=scanner.nextLine();

            if(line.contains(Emp_name))
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
            System.out.println("No Employee found in the system with that name.");
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
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class store_admin {
    public void deactivate_user_account(String username, int choice) throws IOException {

        if (choice == 1) {
            File oldfile = new File("users.txt");
            File newfile = new File("newusers.txt");

            Scanner oldS = new Scanner(oldfile);
            FileWriter newF = new FileWriter(newfile);

            String line = "";
            char id = 'a';

            while (oldS.hasNextLine()) {
                line = oldS.nextLine();

                if (line.contains(username)) {
                    id = line.charAt(0);
                    System.out.println("Removing User with ID : " + id);
                } else {
                    newF.write(line + '\n');
                }
            }

            newF.close();
            oldS.close();

            oldfile.delete();

            boolean check = newfile.renameTo(oldfile);

            if (id != 'a') {
                System.out.println("Successfully de-activated the Customer Account with ID : " + id);
            }
            else {
                System.out.println("No such Customer present with that username.");
            }
        }

        else if (choice == 2) {
            File oldfile = new File("employees.txt");
            File newfile = new File("newemployees.txt");

            Scanner oldS = new Scanner(oldfile);
            FileWriter newF = new FileWriter(newfile);

            String line = "";
            char id = 'a';
            boolean admin_present=false;

            while (oldS.hasNextLine()) {
                line = oldS.nextLine();

                if(line.contains(username)&&line.contains("storeadmin"))
                {
                    admin_present=true;
                    newF.write(line+'\n');
                }
                else if (line.contains(username)&&admin_present==false) {
                    id = line.charAt(0);
                    System.out.println("Removing User with ID : " + id);
                }
                else {
                    newF.write(line + '\n');
                }
            }

            newF.close();
            oldS.close();

            oldfile.delete();

            boolean check = newfile.renameTo(oldfile);

            if(admin_present==true)
            {
                System.out.println("Unsuccessful, cannot De-activate the account of STORE ADMIN. ");
            }
            else if (id != 'a') {
                System.out.println("Successfully de-activated the Employee Account with ID : " + id);
            }
            else
            {
                System.out.println("No such Employee present with that username.");
            }
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public void Welcome() throws MalformedURLException
    {

        File o = new File("Agile.gif");

        URL url = o.toURI().toURL();


        Icon icon = new ImageIcon(url);

        JLabel label = new JLabel(icon);


        JFrame f = new JFrame("Animation");

        f.getContentPane().add(label);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();

        f.setLocationRelativeTo(null);

        f.setVisible(true);

        try

        {

            Thread.sleep(5000);

        } catch (InterruptedException e)

        {

            e.printStackTrace();

        }


        f.setVisible(false);

    }

    public static void main(String[] args) throws IOException {

        Main ABU=new Main();
        ABU.Welcome();

        while(true) {
            Scanner s = new Scanner(System.in);

            int option1;

            System.out.println("****************************************************************************************************************************** \n");
            System.out.println("                                           S & J BOUTIQUE SYSTEM.\n");
            System.out.println("Press 1 to LOGIN.");
            System.out.println("Press 2 to SIGNUP.");
            System.out.println("Press 3 to LEAVE STORE (Warning: Store admin will deactivate your account).");
            System.out.println("Press 4 to Add Items to Cart. ");
            System.out.println("Press 5  for Inventory Manager to Remove Product. ");
            System.out.println("Press 6 for Store Manager to Add Employee. ");
            System.out.println("Press 7 for Sale Agent to Mark Attendance of Sale Agents Only. ");
            System.out.println("Press 8 for Floor Manager to Mark/Track Attendance of Whole Staff. ");
            System.out.println("Press 9 to Show All Current Employees. ");
            System.out.println("Press 10 for Inventory Manager to update Quantity of product. ");
            System.out.println("Press 11 for Inventory Manager to add new product. ");
            System.out.println("Press 12 for CHECKIN. ");
            System.out.println("Press 13 for CHECKOUT. ");
            System.out.println("Press 0 to Exit SUCCESSFULLY. ");
            System.out.println("OPTION : ");

            option1 = s.nextInt();


            if (option1 == 2) {

                System.out.println("\n SIGNUP SYSTEM FOR CUSTOMER:");
                String username;
                String password;
                String phone_number;
                String CNIC;
                String Email;
                String Address;

                // Taking input from user
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter Username : ");
                username = sc.nextLine();

                System.out.print("Enter Password : ");
                password = sc.nextLine();

                System.out.print("Enter Phone Number : ");
                phone_number = sc.nextLine();

                System.out.print("Enter CNIC : ");
                CNIC = sc.nextLine();

                System.out.print("Enter Email : ");
                Email = sc.nextLine();

                System.out.print("Enter Address : ");
                Address = sc.nextLine();

                person person = new person(username, password, phone_number, CNIC, Email, Address);

                user u1 = new user(username, password, phone_number, CNIC, Email, Address);
                u1.signup(person);
            } else if (option1 == 1) {
                int option2;
                System.out.println("\n LOGIN SYSTEM :");

                System.out.println("Press 1 if you are a CUSTOMER.");
                System.out.println("Press 2 if you are an EMPLOYEE.");
                System.out.println("OPTION :");

                Scanner pp = new Scanner(System.in);

                option2 = pp.nextInt();

                String user;
                String pass;

                Scanner ss = new Scanner(System.in);

                System.out.print("Enter Username : ");
                user = ss.nextLine();

                System.out.print("Enter Password : ");
                pass = ss.nextLine();

                if (option2 == 1) {

                    user u2 = new user(null, null, null, null, null, null);
                    u2.login(user, pass);
                } else if (option2 == 2) {
                    employee employee = new employee(null, null, null, null, null, null);
                    employee.login(user, pass);
                }
            }
            else if (option1 == 3) {
                String user;
                String pass;
                int acc_type;

                Scanner uu = new Scanner(System.in);

                System.out.println("Press 1 if you want to Deactivate User Account.");
                System.out.println("Press 2 if you want to Deactivate Employee Account.");
                System.out.println("Choice : ");
                acc_type = uu.nextInt();

                Scanner tt = new Scanner(System.in);

                System.out.print("Enter Username to DEACTIVATE: ");
                user = tt.nextLine();

                store_admin admin = new store_admin();
                admin.deactivate_user_account(user, acc_type);
            }
            else if (option1 == 4) {
                String name;
                int quantity;

                Scanner bb = new Scanner(System.in);

                System.out.println("Enter The Name of Product : ");
                name = bb.nextLine();

                System.out.println("Enter The Quantity of Product : ");
                quantity = bb.nextInt();

                user aa = new user(null, null, null, null, null, null);
                aa.Add_to_cart(name, quantity);


            }
            else if (option1 == 5) {
                String name;
                int quantity;

                Scanner bb = new Scanner(System.in);

                System.out.println("Enter The Name of Product : ");
                name = bb.nextLine();

                System.out.println("Enter The Quantity of Product : ");
                quantity = bb.nextInt();

                inventorymanager i1=new inventorymanager();
                i1.remove_product(name,quantity);
            }
            else if(option1==6)
            {
                storemanager m=new storemanager();
                m.addEmployee();
            }

            else if (option1 == 7)
            {
                Scanner x=new Scanner(System.in);

                System.out.println("Enter Sale Agent Name : ");
                String ename=x.nextLine();


                saleagent agent = new saleagent();
                agent.markAttendance(ename);
            }

            else if (option1 == 8)
            {
                Scanner x=new Scanner(System.in);

                System.out.println("Enter Employee Name : ");
                String ename=x.nextLine();


                floormanager man=new floormanager();
                man.TrackAttendance(ename);
            }

            else if (option1 == 9)
            {
                System.out.println("All Current Employees in System : ");
                storemanager storemanager=new storemanager();
                storemanager.readData();
            }

            else if (option1 == 10)
            {
                String name;
                int quantity;

                Scanner ee = new Scanner(System.in);

                System.out.println("Enter The Name of Product : ");
                name = ee.nextLine();

                System.out.println("Enter The Quantity of Product : ");
                quantity = ee.nextInt();

                inventorymanager i2=new inventorymanager();
                i2.update_item(name,quantity);

            }

            else if (option1 == 11) {
                inventorymanager i3=new inventorymanager();
                i3.add_product();
            }
            else if (option1 == 12) {
                saleagent pop1=new saleagent();
                pop1.checkin();
            }
            else if (option1 == 13) {
                saleagent pop1=new saleagent();
                pop1.checkout();
            }

            else if (option1 == 0) {
                System.out.println("Program Exited Successfully");
                break;
            }
        }
    }


}
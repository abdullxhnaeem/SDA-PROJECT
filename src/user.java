import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//User inheriting from person
public class user extends person {
    public static int customer_id;
    public product cart_item=new product();
    public product cart_item_arr[]=new product[100];
    public static int item_count=0;


    // gets static id of user after every obj creation
    static {
        try {
            customer_id = getid();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public user(String u, String p, String pn, String c, String e, String a) {
        super(u, p, pn, c, e, a);
    }


    public static int getid() throws FileNotFoundException {

        File f = new File("users.txt");
        char id='a';
        int real_id=-1;
        String line="";

        if (f.length() == 0) {
            return 0;
        } else {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                line=sc.nextLine();
            }

        id=line.charAt(0);
        real_id= (int) id;
        real_id=real_id-48;
        return real_id;

        }
    }

    // SIGNUP FOR CUSTOMERS ONLY
    public void signup(person person) throws IOException {

        // code to create/open users file
        File file = new File("users.txt");
       try {
           file.createNewFile();
       }
       catch (IOException e) {
           System.out.println("Unable to create File");
           e.printStackTrace();
       }


        // code for checking whether the username is already present or in use
        boolean check_customer=false;

        Scanner scanner=new Scanner(file);
        String info="";
        String extra=person.username;

        while (scanner.hasNextLine())
        {
         info=scanner.nextLine();
         info.toLowerCase();
         extra.toLowerCase();
         check_customer=info.contains(extra);

         if(check_customer==true)
         {
             break;
         }
        }

        // code for adding customers credentials if username is not present already
        if(check_customer==false) {
            customer_id++;

            char id = (char) customer_id;
            id += 48;

            String input = id + "," + person.username + "," + person.password + "\n";

            FileWriter fileWriter = new FileWriter("users.txt", true);


            try {
                fileWriter.write(input);
            } catch (IOException e) {
                System.out.println("UNABLE TO WRITE");
                e.printStackTrace();
            }

            fileWriter.close();

            System.out.println("You have successfully Signed Up and your Info has been Saved");

        }
        else if(check_customer==true)
        {
            System.out.println("The customers username is already in use. Try again with different credentials");
        }
    }

    public void login(String username,String password)
    {
        String line="";
        char id='x';

        // Comparing user data with file data
        File file=new File("users.txt");

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
                    System.out.println("You have successfully Logged In with customer id : " + id);
                    break;
                }

            }

            if(id=='x')
            {
                System.out.println("The customer is not found. Create an Account");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void Add_to_cart(String name,int quantity) throws IOException {
        File f=new File("product.txt");

        Scanner s=new Scanner(f);
        String line="";
        while(s.hasNextLine())
        {
            line=s.nextLine();

            if(line.contains(name))
            {
                break;
            }
        }
        s.close();

        String arr[]=line.split(",");

        cart_item.name=arr[1];
        cart_item.id=Integer.parseInt(String.valueOf(arr[0]));
        cart_item.qty=quantity;
        cart_item.price=Integer.parseInt(String.valueOf(arr[3]));

        cart_item_arr[item_count]=cart_item;

        System.out.println("User added the product to cart having following info:");
        System.out.println("Product ID : "+cart_item_arr[item_count].id+"\nProduct Name : "+cart_item_arr[item_count].name+"\nProduct Quantity : "+cart_item_arr[item_count].qty+"\nProduct Price : "+ cart_item_arr[item_count].price);

        System.out.println("\nStock Updated Accordingly.");
        product p=new product();
        p.removeItemfromInventory(name,quantity);

    }

}




//code to read file

//        try {
//            Scanner scanner = new Scanner(file);
//            while(scanner.hasNextLine())
//            {
//                String line=scanner.nextLine();
//                System.out.println(line);
//            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class product {
    float price;
    int id, qty;
    String name;

    product() {
        name="";
        id=-1;
        qty=-1;
        price=-1;

    }

    public void UpdateQtyData(String name, int newQuantity) throws IOException
    {
        File file = new File("product.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create File");
            e.printStackTrace();
        }

        String input = "";
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            input = sc.nextLine();

            if (input.contains(name)) {
                break;
            }
        }

        sc.close();

        String arr[] = input.split(",");

        int oldQuantity = Integer.parseInt(String.valueOf(arr[2]));
        int totalQuantity = -1;

        totalQuantity = oldQuantity + newQuantity;
        String productinfo = arr[0] + ',' + arr[1] + ',' + totalQuantity + ',' + arr[3];
        fileUpdate(name, productinfo, totalQuantity);
        System.out.println("Stock Updated");
    }

    //Helper Function for Updating Stock
    private void fileUpdate(String name, String productinfo, int quantity) throws IOException
    {

        File oldfile = new File("product.txt");
        File newfile = new File("newproduct.txt");

        newfile.createNewFile();

        Scanner oldS = new Scanner(oldfile);
        FileWriter newF = new FileWriter(newfile);

        String line = "";
        char id = 'a';

        while (oldS.hasNextLine()) {
            line = oldS.nextLine();

            if (line.contains(name)) {
                newF.write(productinfo + '\n');
            } else {
                newF.write(line + '\n');
            }

        }

        newF.close();
        oldS.close();

        oldfile.delete();

        newfile.renameTo(oldfile);
    }

    //Helper Function For Setting Data
    private void setData()
    {
        Scanner o = new Scanner(System.in);

        System.out.println("Input ID :");
        this.id = o.nextInt();

        o.nextLine();

        System.out.println("Input Name :");
        this.name = o.nextLine();

        System.out.println("Input Price :");
        this.price = o.nextFloat();

        System.out.println("Input Quantitiy :");
        this.qty = o.nextInt();
    }


    public void addNewItem()
    {
        setData();

        try
        {
            FileWriter o = new FileWriter("product.txt",true);
            o.write(Integer.toString(id)+','+name+','+qty+','+price+'\n');
            o.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    //Lists the Current Products
    public void viewInventory()
    {
        try
        {
            File f = new File("product.txt");
            Scanner o = new Scanner(f);

            System.out.println("ID\tName\tQty\tPrice");
            while (o.hasNextLine())
            {
                String d = o.nextLine();
                String[] arr = d.split(",");
                for(int i=0;i<arr.length;i++)
                {
                    System.out.print(arr[i]+"\t");
                }
                System.out.print('\n');
            }
        }
        catch(IOException e)
        {
            System.out.println("Error Occured!");
        }
    }
    public void removeItemfromInventory(String name, int newQuantity) throws IOException {
        File file = new File("product.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create File");
            e.printStackTrace();
        }

        String input = "";
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            input = sc.nextLine();

            if (input.contains(name)) {
                break;
            }
        }

        sc.close();

        String arr[] = input.split(",");

        int oldQuantity = Integer.parseInt(String.valueOf(arr[2]));
        int totalQuantity = -1;

        if (newQuantity <= oldQuantity) {
            totalQuantity = oldQuantity - newQuantity;
            String productinfo = arr[0] + ',' + arr[1] + ',' + totalQuantity + ',' + arr[3];
            resetItemData(name, productinfo, totalQuantity);
        } else {
            System.out.println("The Stock doesn't have required Quantity. Try Again ");
        }
    }

    public void resetItemData(String name, String productinfo, int quantity) throws IOException {

        File oldfile = new File("product.txt");
        File newfile = new File("newproduct.txt");

        newfile.createNewFile();

        Scanner oldS = new Scanner(oldfile);
        FileWriter newF = new FileWriter(newfile);

        String line = "";
        char id = 'a';

        while (oldS.hasNextLine()) {
            line = oldS.nextLine();

            if (line.contains(name)) {
                newF.write(productinfo + '\n');
                System.out.println("Items removed and Quantity decreased Successfully. NEW QUANTITY/STOCK : " + quantity);
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


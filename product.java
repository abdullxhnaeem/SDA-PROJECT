import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Product
{
    float price;
    int id,qty;
    String name;

    Product()
    {

    }

    public void addNewItem()
    {

    }

    public void removeItem(String name)
    {
        File file=new File("product.txt");

        try {
            file.createNewFile();
        }
        catch (IOException e) {
            System.out.println("Unable to create File");
            e.printStackTrace();
        }

        Scanner

    }
}
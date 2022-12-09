import java.io.IOException;

public class inventorymanager extends employee{
    inventorymanager()
    {

    }

    public void add_product()
    {
        product p =new product();
        p.addNewItem();
    }

    public void update_item(String name,int q) throws IOException {
        product p =new product();
        p.UpdateQtyData(name,q);
    }

    public void remove_product(String name,int q) throws IOException {
        product p =new product();
        p.removeItemfromInventory(name,q);
    }
}

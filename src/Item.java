public class Item implements ItemInterface{
    String name;
    String description;
    double value;
    String expiry;

    Item(Item other){
        this.name = other.name;
        this.description = other.description;
        this.value = other.value;
        this.expiry = other.expiry;
    }
    Item(String name,String description,double value,String expiry){
        this.name = name;
        this.description = description;
        this.value = value;
        this.expiry = expiry;
    }
   @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow(name, description, value + "", expiry);
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow(name, value+"", column3);
    }
}

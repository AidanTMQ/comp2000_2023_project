public class Transactor {
    public String name;
    public Inventory inventory;

    public Transactor(String name, Inventory startingInventory) {
        this.name = name;
        this.inventory = startingInventory;
    }
    
    /**
     * Adds an item to the held Inventory.
     * 
     * @param item
     */
    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    /**
     * Removes and returns an item from the held Inventory that matches
     * the `itemName` parameter.
     * 
     * @param itemName
     */
    public ItemInterface removeItem(String itemName) {
        return inventory.removeOne(itemName);
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

}
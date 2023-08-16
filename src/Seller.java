public class Seller extends Transactor{

    public Seller(String storeName, Inventory startingInventory) {
        super(storeName, startingInventory);
    }

 
    /**
     * Purchases an item. As the Seller does not have a money attribute,
     * the item will always be "bought".
     */
    public void buy(ItemInterface item) {
        this.inventory.addOne(item);
    }

    /**
     * Attempt to sell an item by name. If an item with a matching name is
     * found, the item is removed and returned.
     * @param itemName
     * @return The sold item.
     */
    public ItemInterface sell(String itemName) {
        ItemInterface result = removeItem(itemName);
        if (result != null) {
            return result;
        }
        return null;
    }

    
}

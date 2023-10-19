import java.util.Optional;
import java.util.HashMap;

public class ItemDefinition {
    private String name;
    private String description;
    private String[] componentNames;
    private boolean isBaseItem;
    private Optional<Double> weight;

    public ItemDefinition(String n, String desc, Optional<Double> weightIfBase, String[] components) {
        name = n;
        description = desc;
        componentNames = components;
        isBaseItem = weightIfBase.isPresent();
        weight = weightIfBase;


    }

    /**
     * Create an instance of the item described by this ItemDefinition.
     * If the Item is made up of other items, then each sub-item should also be created.
     * @return An Item instance described by the ItemDefinition
     */
    public Item create() {
        Item item = new Item(this);
        // An ItemDefinition for a craftable item might follow a similar pattern
        // to how a craftable/composite item looks.
        return item;
    }

    // ItemDefinition might "craft" and return an item, using items from some source inventory.
    // You might use the Milestone 1 Basket transaction code as a guide 
    public void setWeight(double newWeight){
        this.weight = Optional.of(newWeight); 
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Format: {ItemDefinition item: Integer qty}
     * 
     * @return a HashMap that stores the ItemDefinition and Quantity of base 
     */
    public HashMap<ItemDefinition,Integer> getComponentQty(){
        HashMap<ItemDefinition, Integer> defQty = new HashMap<ItemDefinition, Integer>();
        for (String i : this.getComponentNames()) {
            ItemDefinition currentdef = ItemDictionary.get().defByName(i).get();
            defQty.merge(currentdef, 1, Integer::sum);
        }
        return defQty;
    }
    /**
     * @return returns the sum of the items parts
     */
    public double getCompositionWeight(){
        if (!isBaseItem) {
            double weight = 0.0;
            HashMap<ItemDefinition,Integer> defQty =  this.getComponentQty() ;
            for (ItemDefinition key : defQty.keySet()) {
                int counter = 0;
                while (counter < defQty.get(key)) {
                    weight += key.getWeight().get(); // should always work as can only craft with base item
                    counter++;
                }
            }
            return weight;
        }
        else return this.weight.get();
    }

    public String[] getComponentNames() {
        return componentNames;
    }
    /**
     * Updates Items
     */
    public void updateCompositionWeight(){
        this.setWeight(getCompositionWeight());
    }
    /**
     * Format: {ITEM 1}, {ITEM 2}, ...
     * 
     * @return a String of sub-item/component names in the above format
     */
    public String componentsString() {
        String output = "";
        for (String componentName : componentNames) {
            output += componentName + ", ";
        }
        return output;
    }

    public boolean isBaseItemDef() {
        return isBaseItem;
    }

    public Optional<Double> getWeight() {
        return weight;
    }

    public boolean equals(Item other) {
        return isOf(other.getDefinition());
    }

	public boolean isOf(ItemDefinition def) {
		return getName().equals(def.getName());
	}

}

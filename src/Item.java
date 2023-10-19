import java.util.HashMap;

public class Item implements ItemInterface {
    private ItemDefinition definition;

    /**
     * Creates an Item instance with a set definition.
     * The composition list is (created but) left empty. For composite items, the sub-components
     * should be retrieved/removed from some item source, and added with Item::Add(ItemInterface).
     * @param def
     */
    public Item(ItemDefinition def) {
        definition = def;
    }

    @Override
    public double getWeight() {
        double weight = definition.getWeight().orElse(this.getDefinition().getCompositionWeight());
        return weight;
    }

    @Override
    public String getName() {
        return definition.getName();
    }

    @Override
    public String getDescription() {
        return definition.getDescription();
    }

    @Override
    public ItemDefinition getDefinition() {
        return definition;
    }

    @Override
    public String getCompositionDescription() {
        String op = "";
        HashMap<ItemDefinition, Integer> defQty = this.getDefinition().getComponentQty();
        for (ItemDefinition key : defQty.keySet()) {
            int counter = 0;
            while (counter < defQty.get(key)) {
                op = op+"\n -  "+ defQty.get(key)+"x "+key.getName() + "  :\n       " + key.getDescription()+"\n";
                counter++;
            }

        }
        return op;
    }

    @Override
    public boolean equals(ItemInterface other) {
        return isOf(other.getDefinition());
    }

    @Override
    public boolean isOf(ItemDefinition def) {
        return getName().equals(def.getName());
    }

    @Override
    public String toString() {
        String output = String.format("Item: %s\nDescription: %s\nWeight: %.2f",
            getName(), getDescription(), getWeight());
        output += "\nHashCode: " + Integer.toHexString(this.hashCode());
        return output;
    }

}
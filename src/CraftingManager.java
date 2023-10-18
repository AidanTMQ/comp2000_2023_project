import java.util.HashMap;

public interface CraftingManager {
    HashMap<String,Integer>craft(Player player, ItemDefinition output);
}

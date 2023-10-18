import java.util.ArrayList;

public interface CraftingManager {
   void craft(Player player, ItemDefinition output);
   ArrayList<ItemDefinition> uncraft(Player player,ItemDefinition input);
}


/**
     * @param player the player whose inventory will have base items removed and composite items added
     * @param output the Item that will be crafted in the end and the source of the base items
     */

/**
 * @return
 */
public interface CraftingManager {
   void craft(Player player, ItemDefinition output);
   void uncraft(Player player,Item input);
}

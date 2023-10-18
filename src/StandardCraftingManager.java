import java.util.ArrayList;
import java.util.HashMap;

public class StandardCraftingManager implements CraftingManager{
    
    /**
     * @param player
     * @param output
     */

    /**
     * @return
     */
    @Override
    public void craft(Player player,ItemDefinition finalprod){
        Inventory playInv = player.getInventory();
        String[] stringlist = finalprod.componentsString().replaceAll("\\s", "").split(",");
        HashMap<ItemDefinition,Integer> defQty = new HashMap<ItemDefinition,Integer>();
        HashMap<String,Integer> missingComponents = new HashMap<String,Integer>();
        for(String i : stringlist){
            ItemDefinition currentdef = ItemDictionary.get().defByName(i).get();
            defQty.merge(currentdef, 1, Integer::sum);
        }
        boolean hascomps = true;
        for (ItemDefinition key : defQty.keySet()) {
            if(playInv.qtyOf(key)<defQty.get(key)){
                hascomps = false;
                missingComponents.merge(key.getName(), 1, Integer::sum);
            }
        }
        if(!hascomps){
            System.out.println("Inventory Missing Required Crafting Materials :");
            missingComponents.forEach((String x,Integer qty)->{
                System.out.println(qty+"x : "+x);
            });
            return;
        }else{
            Double weight = 0.0;
            for (ItemDefinition key : defQty.keySet()) {
                int counter = 0;
                while(counter<defQty.get(key)){
                    try{
                    playInv.removeOne(key);
                    } catch (Exception e) {
                        System.out.println(e.getStackTrace());
                    }
                    weight += key.getWeight().get(); // should always work as can only craft with base item
                    counter++;
                }
            }

            finalprod.create();
        }

    }

    @Override
    public ArrayList<ItemDefinition> uncraft(Player player, ItemDefinition input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncraft'");
    }
}

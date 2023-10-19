import java.util.ArrayList;
import java.util.HashMap;

public class StandardCraftingManager implements CraftingManager{
    
    /**
     * @param player the player whose inventory will have base items removed and
     *               composite items added
     * @param output the Item that will be crafted in the end and the source of the
     *               base items
     */

    /**
     * @return void
     */
    @Override
    public void craft(Player player,ItemDefinition output){
        Inventory playInv = player.getInventory();
        HashMap<ItemDefinition, Integer> defQty = output.getComponentQty();
        HashMap<String, Integer> missingComponents = new HashMap<String, Integer>();
        boolean hascomps = true;
        for (ItemDefinition key : defQty.keySet()) {
            if(playInv.qtyOf(key)<defQty.get(key)){
                hascomps = false;
                missingComponents.merge(key.getName(), 1, Integer::sum);
            }
        }
        if(!hascomps){
            System.err.println("Inventory Missing Required Crafting Materials :");
            missingComponents.forEach((String x,Integer qty)->{
                System.err.println(qty+"x : "+x);
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
                        System.err.println(e.getStackTrace());
                    }
                    weight += key.getWeight().get(); // should always work as can only craft with base item
                    counter++;
                }
            }

            output.setWeight(weight);
            playInv.add(output.create());
        }

    }

    @Override
    public void uncraft(Player player, Item input) {
        Inventory playerInv = player.getInventory();
        try {
            playerInv.remove(input);            
        } catch (Exception e) {
            System.err.println(e.getStackTrace()+"\n"+input.getName()+" could not be found");
            return;
        } finally{
            HashMap<ItemDefinition,Integer> defQty = input.getDefinition().getComponentQty();
            for (ItemDefinition key : defQty.keySet()) {
                    int counter = 0;
                    while(counter<defQty.get(key)){
                        playerInv.add(key.create());
                        counter++;
                    }
            
            }
        }   
    }


    
}

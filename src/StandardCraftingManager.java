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
    public ArrayList<Item> uncraft(){
        return new ArrayList<Item>();
    }
    @Override
    public HashMap<String,Integer> craft(Player player,ItemDefinition finalprod){
        
        String [] stringlist = finalprod.componentsString().trim().split(",");
        HashMap<String,Integer> nameQtyMap = new HashMap<String,Integer>();
        for(String str : stringlist){
            str.trim();
            if (nameQtyMap.putIfAbsent(str,1)==null){
                nameQtyMap.put(str,nameQtyMap.get(str)+1);
            }
        }
        
        HashMap<String,Integer> missingResources = new HashMap<String,Integer>();
        nameQtyMap.forEach((String name, Integer qtyreq)->{
            System.out.println("name:"+name+", qty"+qtyreq);
            int playerItemQty = player.getInventory().qtyOf(name);
            if (playerItemQty<qtyreq){
                missingResources.put(name,qtyreq - playerItemQty);
            }
        });
        if(missingResources.size()==0){
            nameQtyMap.forEach((String name, Integer qtyreq)->{
            player.getInventory().remove(name,qtyreq);
        });
        }else{
            System.err.println("Could Not Craft Missing the Following Items");
            missingResources.forEach((String name,Integer qtyreq)->{
                System.err.println("    - "+qtyreq+" x "+name);
            });
        }
        return missingResources;
    }
}

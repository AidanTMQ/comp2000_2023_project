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
    public void craft(Player player,ItemDefinition output){
        String [] stringlist = output.componentsString().trim().split(",");
        HashMap<String,Integer> nameQtyMap = new HashMap<String,Integer>();
        for (String str = stringlist) /// do later
        for(String name:output.componentsString().trim().split(",")){
            name.trim()
        }
    }
}

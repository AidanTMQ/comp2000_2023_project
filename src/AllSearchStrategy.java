import java.util.ArrayList;

public class AllSearchStrategy implements SearchStrategy {

    @Override
    public ArrayList<ItemInterface> execute(ArrayList<ItemInterface> stock, String term) {
        ArrayList<ItemInterface> result = new ArrayList<ItemInterface>(stock); // copy stock
        for (int i = 0; i < result.size(); i++) {
            ItemInterface curItem = result.get(i);
            if (!curItem.getName().contains(term) && !curItem.getDescription().contains(term)) {
                result.remove(i);
                i--; // Go back to revisit current index on next run of loop
            }
        }
        return result;
    }


}
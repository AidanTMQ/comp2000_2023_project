import java.util.ArrayList;
public interface SearchStrategy {
    ArrayList<ItemInterface> execute(ArrayList<ItemInterface> stock, String term);
}

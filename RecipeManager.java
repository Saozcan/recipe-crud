import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private static RecipeManager instance;
    private List<Recipe> appetizers;
    private List<Recipe> mainDishes;
    private List<Recipe> desserts;
    // private constructor to prevent outside instantiation
    private RecipeManager() {
        // initialization code here
        appetizers = new ArrayList<>();
        mainDishes = new ArrayList<>();
        desserts = new ArrayList<>();
    }
    public static RecipeManager getInstance() {
        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }
    // recipe-related methods here, including methods to add recipes to the appropriate category lists
    public void addAppetizer(Recipe recipe) {
        appetizers.add(recipe);
    }
    public void addMainDish(Recipe recipe) {
        mainDishes.add(recipe);
    }
    public void addDessert(Recipe recipe) {
        desserts.add(recipe);
    }

    public List<Recipe> getAppetizers() {
        return appetizers;
    }

    public List<Recipe> getMainDishes() {
        return mainDishes;
    }

    public List<Recipe> getDesserts() {
        return desserts;
    }

    public Recipe getRecipe(String name) {
        for (Recipe recipe : appetizers) {
            if (recipe.getName().contains(name)) {
                return recipe;
            }
        }
        for (Recipe recipe : mainDishes) {
            if (recipe.getName().contains(name)) {
                return recipe;
            }
        }
        for (Recipe recipe : desserts) {
            if (recipe.getName().contains(name)) {
                return recipe;
            }
        }
        return null;
    }
}
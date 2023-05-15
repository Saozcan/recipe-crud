import java.util.List;
import java.util.Set;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private float rating;
    private String category;
    private Set<String> tags;
    private List<RecipeObserver> observers;
    // getters and setters for name, ingredients, steps, rating, category, and tags
    public void addObserver(RecipeObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(RecipeObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (RecipeObserver observer : observers) {
            observer.update(this);
        }
    }
}
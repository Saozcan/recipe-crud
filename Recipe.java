import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private int rating;
    private String category;
    private Set<String> tags;
    private List<RecipeObserver> observers;

    public Recipe() {
        observers = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
        notifyObservers(); // Notify observers when the rating is updated
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

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

    // Other methods specific to Recipe class
}

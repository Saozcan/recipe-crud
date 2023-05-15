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
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public void addStep(Step step) {
        steps.add(step);
    }

    public void removeStep(Step step) {
        steps.remove(step);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public void printRecipe() {
        System.out.println("Name: " + name);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient);
        }
        System.out.println("Steps:");
        for (Step step : steps) {
            System.out.println(step);
        }
        System.out.println("Rating: " + rating);
        System.out.println("Category: " + category);
        System.out.println("Tags: " + tags);
    }

    @Override
    public String toString() {
        printRecipe();
        return "";
    }
}

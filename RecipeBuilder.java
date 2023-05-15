import java.util.List;
import java.util.Set;

public class RecipeBuilder {
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private String category;
    private int rating;
    private Set<String> tags;
    // setters for name, ingredients, steps, rating, and tags
    public Recipe build() {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        recipe.setSteps(steps);
        recipe.setRating(rating);
        recipe.setCategory(category);
        recipe.setTags(tags);
        return recipe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
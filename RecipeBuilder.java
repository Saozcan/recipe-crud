import java.util.Set;

public class RecipeBuilder {
    private String name;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private int rating;
    private Set<String> tags;
    // setters for name, ingredients, steps, rating, and tags
    public Recipe build(String category) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        recipe.setSteps(steps);
        recipe.setRating(rating);
        recipe.setCategory(category);
        recipe.setTags(tags);
        return recipe;
    }
}
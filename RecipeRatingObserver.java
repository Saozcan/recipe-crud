public class RecipeRatingObserver implements RecipeObserver {
    @Override
    public void update(Recipe recipe) {
        // Perform actions when a recipe's rating is updated
        System.out.println("Recipe rating has been updated: " + recipe.getName());
    }
}
